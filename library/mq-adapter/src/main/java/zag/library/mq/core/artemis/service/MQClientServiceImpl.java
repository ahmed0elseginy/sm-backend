package zag.library.mq.core.artemis.service;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import zag.library.common.enums.AppHeaders;
import zag.library.common.interfaces.Events;
import zag.library.mq.api.service.MQClientService;
import zag.library.session.api.service.RequestContext;

import java.time.LocalDateTime;

import static zag.library.session.core.model.enums.CommonRequestContextKeys.LANGUAGE;
import static zag.library.session.core.model.enums.CommonRequestContextKeys.USER_TOKEN;


@Log4j2
@Service
@AllArgsConstructor
public class MQClientServiceImpl implements MQClientService {
    private final JmsTemplate jms;
    private final RequestContext context;

    private Message setMessageHeaders(Events<?, ?> event, Message message) throws JMSException {
        message.setStringProperty(AppHeaders.EVENT_NAME.mqHeader(), event.name());
        message.setStringProperty(AppHeaders.AUTHORIZATION.mqHeader(), this.context.get(USER_TOKEN));
        message.setStringProperty(AppHeaders.ACCEPT_LANGUAGE.mqHeader(), this.context.get(LANGUAGE));

//        if (ThreadContext.get(TRACE_ID) != null)
//            message.setStringProperty(TRACE_ID.mqHeader(), ThreadContext.get(TRACE_ID));

        message.setStringProperty(AppHeaders.PUBLISHED_ON.mqHeader(), LocalDateTime.now().toString());
        return message;
    }

    @Override
    public void sendMessage(Events<?, ?> event, Object body) {
        if (body == null)
            throw new IllegalArgumentException("Message body is null");

        this.jms.convertAndSend(event.domain().destination(), body,
                message -> this.setMessageHeaders(event, message)
        );
        log.info("Event {} is published on Topic {} with Payload {}", event, event.domain().destination(), body);
    }

    @Override
    public void sendMessage(Events<?, ?> event, Object body, Long delayedTime) {
        if (body == null)
            throw new IllegalArgumentException("Cannot send null message on " +
                    "Topic: " + event.domain().destination() + " with Event: " + event.name());

        this.jms.convertAndSend(event.domain().destination(), body, message -> {
            message.setJMSDeliveryTime(System.currentTimeMillis() + delayedTime);
            return this.setMessageHeaders(event, message);
        });
        log.info("Event {} is published on Topic {} with Payload {}", event, event.domain().destination(), body);
    }
}

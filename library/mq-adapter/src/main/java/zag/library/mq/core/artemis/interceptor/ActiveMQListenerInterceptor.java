package zag.library.mq.core.artemis.interceptor;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.activemq.artemis.api.core.ActiveMQException;
import org.apache.activemq.artemis.api.core.Interceptor;
import org.apache.activemq.artemis.api.core.client.ClientMessage;
import org.apache.activemq.artemis.core.client.impl.ClientMessageImpl;
import org.apache.activemq.artemis.core.protocol.core.Packet;
import org.apache.activemq.artemis.core.protocol.core.impl.wireformat.SessionReceiveMessage;
import org.apache.activemq.artemis.spi.core.protocol.RemotingConnection;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Log4j2
@RequiredArgsConstructor
public class ActiveMQListenerInterceptor implements Interceptor {

    @Override
    public boolean intercept(Packet packet, RemotingConnection connection) throws ActiveMQException {
        if (packet instanceof SessionReceiveMessage messagePacket && connection.isClient()
                && messagePacket.getMessage().getUserID() != null) {
            ClientMessage message = (ClientMessage) messagePacket.getMessage();
            String messageBody = message.getStringBody();
            String topicName = message.getAddress();
            Map<String, String> headers = new HashMap<>();
            (((ClientMessageImpl) message).getProperties()).getMap().forEach((header, value) -> {
                if (value != null) {
                    headers.put(header, value.toString());
                    log.debug("Header: " + header + " and Value: " + value);
                } else
                    log.debug("Header: " + header + " is null");
            });

            log.debug("Received message from Topic: " + topicName + " with \nBody: " + messageBody);

//            if(messageBody == null){
//                log.error("Message body is null");
//                message.acknowledge();
//                return false;
//            }
        }

        return true;
    }
}

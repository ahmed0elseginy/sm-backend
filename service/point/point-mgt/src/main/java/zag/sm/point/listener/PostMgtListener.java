package zag.sm.point.listener;

import lombok.AllArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import zag.sm.point.model.enums.PointsType;
import zag.sm.point.service.mq.PostMgtListenerService;
import zag.sm.post.model.PostEventData;
import zag.sm.post.model.enums.PostEvents;

import static zag.library.common.enums.AppHeaders.EVENT_NAME_MQ_HEADER;
import static zag.sm.post.model.enums.PostDomains.POST_TOPIC_NAME;

@Component
@AllArgsConstructor
public class PostMgtListener {

    private final PostMgtListenerService postListenerService;

    @JmsListener(destination = POST_TOPIC_NAME)
    public void onPostEvent(@Header(EVENT_NAME_MQ_HEADER) String eventName, @Payload PostEventData post) {

        Long userId = post.getCreatedById();
        PostEvents event=PostEvents.valueOf(eventName);

        if (eventName.equals(PostEvents.CREATE_POST.name())) {
            postListenerService.insertTransaction(event.id(), userId, PointsType.POSITIVE);
        }

        if (eventName.equals(PostEvents.DELETE_POST.name())) {
            postListenerService.insertTransaction(event.id(), userId, PointsType.NEGATIVE);
        }

    }

}

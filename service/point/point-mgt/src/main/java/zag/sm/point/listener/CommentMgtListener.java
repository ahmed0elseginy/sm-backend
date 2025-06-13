package zag.sm.point.listener;

import lombok.AllArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import zag.sm.point.model.enums.PointsType;
import zag.sm.point.service.mq.CommentMgtListenerService;
import zag.sm.post.model.CommentEventData;
import zag.sm.post.model.enums.CommentEvents;

import static zag.library.common.enums.AppHeaders.EVENT_NAME_MQ_HEADER;
import static zag.sm.post.model.enums.PostDomains.COMMENT_TOPIC_NAME;


@Component
@AllArgsConstructor
public class CommentMgtListener {

    private final CommentMgtListenerService commentMgtListenerService;

    @JmsListener(destination = COMMENT_TOPIC_NAME)
    public void onCommentEvent(@Header(EVENT_NAME_MQ_HEADER) String eventName, @Payload CommentEventData comment) {

        CommentEvents event=CommentEvents.valueOf(eventName);

       switch(event){
           case CREATE_COMMENT :
               commentMgtListenerService.createCommentPoints(event.id(),comment.getCreatedById());
               break;
           case DELETE_COMMENT:
               commentMgtListenerService.deleteCommentPoints(event.id(),comment.getCreatedById());
               break;
       }


    }

}

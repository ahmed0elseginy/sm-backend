package zag.sm.post.listener;

import lombok.AllArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import zag.sm.post.service.mq.ReportMgtListenerService;
import zag.sm.report.model.ReportEventData;
import zag.sm.report.model.enums.ReportEvents;

import static zag.library.common.enums.AppHeaders.EVENT_NAME_MQ_HEADER;
import static zag.sm.report.model.enums.ReportDomains.REPORT_TOPIC_NAME;

@Component
@AllArgsConstructor
public class ReportMgtListener {

    private final ReportMgtListenerService reportService;

    @JmsListener(destination = REPORT_TOPIC_NAME)
    public void reportEvent(@Header(EVENT_NAME_MQ_HEADER) String eventName,
                            @Payload ReportEventData report){
        ReportEvents event = ReportEvents.valueOf(eventName);
        switch (event){
            case APPROVE_REPORT -> reportService.deletePost(report.getPostId());
        }


    }

}

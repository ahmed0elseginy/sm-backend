package zag.sm.point.listener;

import lombok.AllArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import zag.sm.point.service.mq.ReportMgtListenerService;
import zag.sm.report.model.ReportEventData;
import zag.sm.report.model.enums.ReportEvents;

import static zag.library.common.enums.AppHeaders.EVENT_NAME_MQ_HEADER;
import static zag.sm.report.model.enums.ReportDomains.REPORT_TOPIC_NAME;

@Component
@AllArgsConstructor
public class ReportMgtListener {

    private final ReportMgtListenerService reportMgtService;

    @JmsListener(destination =REPORT_TOPIC_NAME)
    public void onReportEvent(@Header(EVENT_NAME_MQ_HEADER) String eventName,
                              @Payload ReportEventData report) {

        ReportEvents event = ReportEvents.valueOf(eventName);
        switch (event) {
            case CREATED_REPORT:
                System.out.println("hello");
                reportMgtService.createReportPoints(event.id(), report.getCreatedById(), report.getPostOwnerId());
                break;
            case APPROVE_REPORT:
                reportMgtService.approveReportPoints(event.id(), report.getLastModifiedById());
                break;
            case REJECT_REPORT:
                reportMgtService.rejectReportPoints(event.id(), report.getCreatedById(), report.getPostOwnerId());
                break;
        }






    }

}

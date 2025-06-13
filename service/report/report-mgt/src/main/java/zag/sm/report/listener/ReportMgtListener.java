package zag.sm.report.listener;

import lombok.AllArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import zag.library.session.api.service.RequestContext;
import zag.sm.report.model.ReportEventData;
import zag.sm.report.model.enums.ReportEvents;
import zag.sm.report.service.AdminService;

import static zag.library.common.enums.AppHeaders.EVENT_NAME_MQ_HEADER;
import static zag.library.session.core.model.enums.CommonRequestContextKeys.USER_ID;
import static zag.sm.report.model.enums.ReportDomains.REPORT_TOPIC_NAME;

@Component
@AllArgsConstructor
public class ReportMgtListener {

    private final AdminService adminService;
    public final RequestContext context;

    @JmsListener(destination = REPORT_TOPIC_NAME)
    public void reportEvent(@Header(EVENT_NAME_MQ_HEADER) String eventName,
                            @Payload ReportEventData report){
        ReportEvents event = ReportEvents.valueOf(eventName);
        switch (event){
            case APPROVE_REPORT -> adminService.cascadeActionToRelatedReports(
                    report.getPostId(),
                    report.getLastModifiedById(),
                    report.getId()
            );
        }


    }

}

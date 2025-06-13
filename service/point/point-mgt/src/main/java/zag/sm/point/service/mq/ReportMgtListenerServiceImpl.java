package zag.sm.point.service.mq;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import zag.library.error.exception.BusinessException;
import zag.sm.point.model.enums.PointsType;
import zag.sm.point.repository.entity.Event;
import zag.sm.point.repository.entity.EventSetting;
import zag.sm.point.repository.entity.UserPoints;
import zag.sm.point.repository.jpa.EventJPARepository;
import zag.sm.point.repository.jpa.EventSettingsJPARepository;
import zag.sm.point.repository.jpa.UserPointsJPARepository;
import zag.sm.report.model.enums.ReportEvents;

import static zag.sm.point.model.enums.PointErrors.EVENT_NOT_FOUND;
import static zag.sm.point.model.enums.PointErrors.EVENT_SETTINGS_NOT_FOUND;

@Service
@AllArgsConstructor
public class ReportMgtListenerServiceImpl implements ReportMgtListenerService{

    private final PostMgtListenerService postMgtListenerService;
    private final EventJPARepository eventJPARepository;
    private final EventSettingsJPARepository eventSettingsRepository;
    private final UserPointsJPARepository userPointsRepository;

    @Override
    public void createReportPoints(Integer eventId, Long reporterId, Long postOwnerId) {
        this.userTransaction( eventId, reporterId, postOwnerId);
    }

    @Override
    public void approveReportPoints(Integer eventId, Long userId) {
        postMgtListenerService.insertTransaction(eventId,userId, PointsType.POSITIVE);
    }

    @Override
    public void rejectReportPoints(Integer eventId, Long reporterId, Long postOwnerId) {
        this.userTransaction( eventId, reporterId, postOwnerId);
    }


    private void userTransaction(Integer eventId, Long reporterId, Long postOwnerId){
        Event event=  eventJPARepository.findById(eventId).orElseThrow(
                () -> new BusinessException(EVENT_NOT_FOUND)
        );

        EventSetting eventSettings=  eventSettingsRepository.findById(event.getId()).orElseThrow(
                () -> new BusinessException(EVENT_SETTINGS_NOT_FOUND)
        );

        if(eventId.equals(ReportEvents.CREATED_REPORT.id())){

            UserPoints reporterPoints=UserPoints.builder()
                    .event(event)
                    .userId(reporterId)
                    .points(eventSettings.getPositivePoints())
                    .build();

            userPointsRepository.save(reporterPoints);

            UserPoints postOwnerPoints=UserPoints.builder()
                    .event(event)
                    .userId(postOwnerId)
                    .points(eventSettings.getNegativePoints())
                    .build();

            userPointsRepository.save(postOwnerPoints);

        } else if (eventId.equals(ReportEvents.REJECT_REPORT.id())) {

            UserPoints reporterPoints=UserPoints.builder()
                    .event(event)
                    .userId(reporterId)
                    .points(eventSettings.getNegativePoints())
                    .build();

            userPointsRepository.save(reporterPoints);

            UserPoints postOwnerPoints=UserPoints.builder()
                    .event(event)
                    .userId(postOwnerId)
                    .points(eventSettings.getPositivePoints())
                    .build();

            userPointsRepository.save(postOwnerPoints);
        }


    }


}

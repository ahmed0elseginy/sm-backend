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
import zag.sm.point.repository.jpa.PointsJPARepository;

import static zag.sm.point.model.enums.PointErrors.*;


@Service
@AllArgsConstructor
public class PostMgtListenerServiceImpl implements PostMgtListenerService {

    private final EventJPARepository eventRepository;
    private final EventSettingsJPARepository eventSettingsRepository;
    private final PointsJPARepository pointsRepository;

    @Override
    public Long insertTransaction(Integer eventId, Long userId, PointsType transactionType) {
        EventSetting eventPointSettings = eventSettingsRepository.findById(eventId)
                .orElseThrow(() -> new BusinessException(EVENT_SETTINGS_NOT_FOUND));

        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new BusinessException(EVENT_NOT_FOUND));

        if (!event.getIsActive()) {
            throw new BusinessException(EVENT_NOT_ACTIVE);
        }

        Integer addedPoints = null;
        if (transactionType.equals(PointsType.POSITIVE)){
            addedPoints = eventPointSettings.getPositivePoints();
        }
        if (transactionType.equals(PointsType.NEGATIVE)){
            addedPoints = eventPointSettings.getNegativePoints();
        }
        UserPoints pointTransaction = UserPoints.builder()
                .points(addedPoints)
                .event(event)
                .userId(userId)
                .build();
        UserPoints savedPointTransaction = pointsRepository.save(pointTransaction);

        return savedPointTransaction.getId();
    }


}

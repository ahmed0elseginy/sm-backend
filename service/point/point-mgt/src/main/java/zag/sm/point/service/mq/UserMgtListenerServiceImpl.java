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
import zag.sm.point.repository.jpa.UserPointsJPARepository;

import static zag.sm.point.model.enums.PointErrors.*;

@Service
@AllArgsConstructor
public class UserMgtListenerServiceImpl implements UserMgtListenerService{

    private final EventJPARepository eventRepository;
    private final EventSettingsJPARepository eventSettingsRepository;
    private final PointsJPARepository pointsRepository;
    private final UserPointsJPARepository userPointsRepository;

    @Override
    public void registrationPoints(Long userId, Integer eventId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new BusinessException(EVENT_NOT_FOUND));

        if (!event.getIsActive()) {
            throw new BusinessException(EVENT_NOT_ACTIVE);
        }

        EventSetting eventSettings = eventSettingsRepository.findById(eventId)
                .orElseThrow(() -> new BusinessException(EVENT_SETTINGS_NOT_FOUND));

        Integer negativePoints = eventSettings.getNegativePoints();
        Integer positivePoints = eventSettings.getPositivePoints();

        UserPoints userPoints = UserPoints.builder()
                .userId(userId)
                .event(event)
                .points(positivePoints)
                .build();

        userPointsRepository.save(userPoints);
    }

    @Override
    public void addRolePoints(Long userId, Integer eventId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new BusinessException(EVENT_NOT_FOUND));

        if (!event.getIsActive()) {
            throw new BusinessException(EVENT_NOT_ACTIVE);
        }

        EventSetting eventSettings = eventSettingsRepository.findById(eventId)
                .orElseThrow(() -> new BusinessException(EVENT_SETTINGS_NOT_FOUND));

        Integer negativePoints = eventSettings.getNegativePoints();
        Integer positivePoints = eventSettings.getPositivePoints();

        UserPoints pointTransaction = UserPoints.builder()
                .points(positivePoints)
                .event(event)
                .userId(userId)
                .build();
        UserPoints savedPointTransaction = pointsRepository.save(pointTransaction);
    }

    @Override
    public void removeRolePoints(Long userId, Integer eventId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new BusinessException(EVENT_NOT_FOUND));

        if (!event.getIsActive()) {
            throw new BusinessException(EVENT_NOT_ACTIVE);
        }

        EventSetting eventSettings = eventSettingsRepository.findById(eventId)
                .orElseThrow(() -> new BusinessException(EVENT_SETTINGS_NOT_FOUND));

        Integer negativePoints = eventSettings.getNegativePoints();
        Integer positivePoints = eventSettings.getPositivePoints();

        UserPoints pointTransaction = UserPoints.builder()
                .points(negativePoints)
                .event(event)
                .userId(userId)
                .build();
        UserPoints savedPointTransaction = pointsRepository.save(pointTransaction);
    }

}

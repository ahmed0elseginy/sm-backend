package zag.sm.point.service.mq;

import lombok.AllArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import zag.library.error.exception.BusinessException;
import zag.sm.point.model.enums.PointsType;
import zag.sm.point.repository.entity.Event;
import zag.sm.point.repository.entity.EventSetting;
import zag.sm.point.repository.entity.UserPoints;
import zag.sm.point.repository.jpa.EventJPARepository;
import zag.sm.point.repository.jpa.EventSettingsJPARepository;
import zag.sm.point.repository.jpa.UserPointsJPARepository;

import java.util.Optional;

import static zag.sm.point.model.enums.PointErrors.*;

@AllArgsConstructor
@Service
public class CommentMgtListenerServiceImpl implements CommentMgtListenerService {


    private final PostMgtListenerService postMgtListenerService;

    @Override
    public void createCommentPoints(Integer eventId, Long userId) {
        postMgtListenerService.insertTransaction(eventId, userId,PointsType.POSITIVE);
    }

    @Override
    public void deleteCommentPoints(Integer eventId, Long userId) {
        postMgtListenerService.insertTransaction(eventId, userId,PointsType.NEGATIVE);
    }
}

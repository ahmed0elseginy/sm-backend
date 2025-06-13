package zag.sm.point.service.mq;

import zag.sm.point.model.enums.PointsType;

public interface CommentMgtListenerService {

    void createCommentPoints(Integer eventId, Long userId);

    void deleteCommentPoints(Integer eventId, Long userId);
}

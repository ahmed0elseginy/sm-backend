package zag.sm.point.service.mq;

import zag.sm.point.model.enums.PointsType;

public interface PostMgtListenerService {

    Long insertTransaction (Integer eventId, Long userId, PointsType transactionType);

}

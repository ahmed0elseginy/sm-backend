package zag.sm.point.service.mq;


import zag.sm.point.model.enums.PointsType;

public interface UserMgtListenerService {

    void registrationPoints(Long userId, Integer eventId);

    void addRolePoints(Long userId, Integer eventId);

    void removeRolePoints(Long userId, Integer eventId);

}

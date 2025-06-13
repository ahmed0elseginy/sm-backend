package zag.sm.point.service.mq;

public interface ReportMgtListenerService {

    void createReportPoints(Integer eventId,Long reporterId,Long postOwnerId);
    void approveReportPoints(Integer eventId, Long userId);
    void rejectReportPoints(Integer eventId,Long reporterId,Long postOwnerId);



}

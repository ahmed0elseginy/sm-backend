package zag.sm.report.service;

import zag.sm.report.model.generated.*;

import java.util.Date;

public interface AdminService {

    LightReportResultSet getAllReportsByFilter(
            Integer statusId, Integer categoryId, java.util.Date createdOnFrom, Date createdOnTo,
            OrderByAttributes orderBy, OrderDirections orderDir, Integer pageOffset, Integer pageSize
    );

    void performReportAction(Long reportId, ReportActions action, PerformActionRequest performActionRequest);
    FullReportDetails getReportsDetailsById(Long reportId);

     void cascadeActionToRelatedReports(Long postId, Long currentUserId, Long reportId) ;



    }

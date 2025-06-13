package zag.sm.report.service;

import lombok.AllArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import zag.library.error.exception.BusinessException;
import zag.library.filter.PaginationInfo;
import zag.library.filter.SortingInfo;
import zag.library.session.api.service.RequestContext;
import zag.sm.report.mapper.ReportMapper;
import zag.sm.report.model.dto.LightJpaReport;
import zag.sm.report.model.enums.ReportActions;
import zag.sm.report.model.enums.ReportDomains;
import zag.sm.report.model.enums.ReportEvents;
import zag.sm.report.model.enums.ReportStatuses;
import zag.sm.report.model.filter.ReportSearchFilter;
import zag.sm.report.model.generated.*;
import zag.sm.report.model.vto.PostVTO;
import zag.sm.report.repository.entity.Report;
import zag.sm.report.repository.entity.Status;
import zag.sm.report.repository.jpa.ReportJPARepository;
import zag.sm.report.repository.jpa.ReportRepository;
import zag.sm.report.repository.jpa.StatusJPARepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static zag.library.common.enums.AppHeaders.EVENT_NAME;
import static zag.library.session.core.model.enums.CommonRequestContextKeys.USER_ID;
import static zag.library.session.core.model.enums.CommonRequestContextKeys.USER_TOKEN;
import static zag.sm.report.model.enums.ReportErrors.*;
import static zag.sm.report.model.enums.ReportEvents.APPROVE_REPORT;
import static zag.sm.report.model.enums.ReportEvents.REJECT_REPORT;
import static zag.sm.report.model.enums.ReportStatuses.CASCADED_APPROVAL;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final ReportRepository reportRepository;
    private final ReportJPARepository reportJPARepository;
    private final StatusJPARepository statusGPARepository;
    private final PostService postService;
    private final UserService userService;
    private final ReportMapper reportMapper;
    private final RequestContext context;
    private final JmsTemplate jmsTemplate;

    @Override
    public LightReportResultSet getAllReportsByFilter(
            Integer statusId, Integer categoryId, Date createdOnFrom, Date createdOnTo,
            OrderByAttributes orderBy, OrderDirections orderDir, Integer pageOffset, Integer pageSize) {

        ReportSearchFilter filter = ReportSearchFilter.builder()
                .createdOnFrom(createdOnFrom)
                .createOnTo(createdOnTo)
                .categoryId(categoryId)
                .statusId(statusId)
                .pagination(PaginationInfo.builder().pageOffset(pageOffset).pageSize(pageSize).build())
                .sorting(SortingInfo.builder().orderBy(orderBy != null ? orderBy.getValue() : null).orderDir(orderDir != null ? orderDir.getValue() : null).build())
                .build();

        LightJpaReport reports = reportRepository.getAllReport(filter);

        List<LightReportListItem> filtrationReports = reports.getReports().stream().map(
                (report) -> {
                    //report,PostDetailsVTO,LightuserVTO
                    return reportMapper.toLightListItem(report,
                            reportMapper.toPostDetails(postService.getPostById(report.getPostId())),
                            userService.getUsersByIds(List.of(report.getCreatedById())).getData().get(0)
                    );
                }
        ).toList();

        return LightReportResultSet.builder()
                .data(filtrationReports)
                .total(reports.getTotalCount())
                .build();
    }

    @Override
    public void performReportAction(Long reportId, zag.sm.report.model.generated.ReportActions action, PerformActionRequest performActionRequest) {

        Long currentUserId = context.get(USER_ID, Long.class);
        String userToken = context.get(USER_TOKEN, String.class);

        Report report = reportJPARepository.findById(reportId)
                .orElseThrow(() -> new BusinessException(REPORT_NOT_FOUND));
        ReportStatuses _status = ReportActions.valueOf(action.getValue()).getStatus();
        Status status = statusGPARepository.findById(_status.getId())
                .orElseThrow(() -> new BusinessException(STATUS_NOT_FOUND));
        ;
        Date currentDate = new Date();
        if (action.getValue().equals(ReportActions.APPROVE.name())) {
            report.setStatus(status);
            report.setLastModifiedOn(currentDate);
            report.setLastModifiedById(currentUserId);
//          postService.deletePostById(report.getPostId());
//          cascadeActionToRelatedReports(report.getPostId(), currentUserId, reportId);    //Asyncrouns
            reportJPARepository.save(report);

            PostVTO post = postService.getPostById(report.getPostId());

            jmsTemplate.convertAndSend(
                    ReportDomains.REPORT.destination(),
                    reportMapper.toReportEventData(report, post.getCreatedBy().getId().longValue()),
                    message -> {
                        message.setStringProperty(EVENT_NAME.mqHeader(), APPROVE_REPORT.name());
                        return message;
                    });

        } else if (action.getValue().equals(ReportActions.REJECT.name())) {
            report.setStatus(status);
            report.setLastModifiedOn(currentDate);
            report.setLastModifiedById(currentUserId);
            if (performActionRequest.getRejectReason() != null) {
                report.setRejectReason(performActionRequest.getRejectReason());
                reportJPARepository.save(report);

                PostVTO post = postService.getPostById(report.getPostId());

                jmsTemplate.convertAndSend(
                        ReportDomains.REPORT.destination(),
                        reportMapper.toReportEventData(report, post.getCreatedBy().getId().longValue()),
                        message -> {
                            message.setStringProperty(EVENT_NAME.mqHeader(), REJECT_REPORT.name());
                            return message;
                        });
            } else {
                throw new BusinessException(MISSING_DATA);
            }
        } else {
            // throw new BusinessException(UNSUPPORTED_ACTION);
        }

    }

    public void cascadeActionToRelatedReports(Long postId, Long currentUserId, Long reportId) {
        Optional<Status> optionalStatus = statusGPARepository.findById(CASCADED_APPROVAL.getId());
        if (optionalStatus.isPresent()) {
            Status status = optionalStatus.get();
            List<Report> relatedReports = reportJPARepository.findAllByPostId(postId);
            for (Report relatedReport : relatedReports) {
                if (!relatedReport.getId().equals(reportId)) {
                    relatedReport.setStatus(status);
                    relatedReport.setLastModifiedOn(new Date());
                    relatedReport.setLastModifiedById(currentUserId);
                    reportJPARepository.save(relatedReport);
                }
            }

        }
    }

    @Override
    public FullReportDetails getReportsDetailsById(Long reportId) {

        Report report = reportJPARepository.findById(reportId)
                .orElseThrow(() -> new BusinessException(REPORT_NOT_FOUND));


        LightUserVTO lightUser = userService.getUsersByIds(
                        List.of(report.getCreatedById()))
                .getData().get(0);

        LightUserVTO lastModifiedBy;

        if (report.getLastModifiedById() != null) {
            lastModifiedBy = userService.getUsersByIds(
                            List.of(report.getLastModifiedById()))
                    .getData().get(0);
        } else {
            lastModifiedBy = null;
        }

        ReportDetails reportDetails = ReportDetails.builder()
                .createdOn(report.getCreatedOn())
                .lastModifiedBy(lastModifiedBy)
                .lastModifiedOn(report.getLastModifiedOn())
                .createdBy(lightUser)
                .category(reportMapper.toLookupVTO(report.getCategory()))
                .status(reportMapper.toLookupVTO(report.getStatus()))
                .reason(report.getReason())
                .build();

        List<Report> relatedReports = reportJPARepository.findRelatedReports(report.getPostId(), reportId);
        if (relatedReports == null || relatedReports.isEmpty()) {
            relatedReports = List.of();
        }

        List<PostReportListItem> reportListItems = relatedReports.stream().map(
                (reportRelated) -> {
                    return reportMapper.toPostReportListItems(reportRelated,
                            userService.getUsersByIds(List.of(reportRelated.getCreatedById())).getData().get(0));
                }
        ).toList();

        PostDetailsVTO postDetails = reportMapper.toFullPostDetails(postService.getPostById(report.getPostId()));

        return FullReportDetails.builder()
                .reportDetails(reportDetails)
                .post(postDetails)
                .relatedReports(reportListItems)
                .build();
    }
}

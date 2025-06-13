package zag.sm.report.service;

import lombok.AllArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import zag.library.error.exception.BusinessException;
import zag.library.session.api.service.RequestContext;
import zag.sm.report.mapper.ReportMapper;
import zag.sm.report.model.enums.ReportDomains;
import zag.sm.report.model.enums.ReportEvents;
import zag.sm.report.model.generated.ReportRequestDTO;
import zag.sm.report.model.vto.PostVTO;
import zag.sm.report.repository.entity.Category;
import zag.sm.report.repository.entity.Report;
import zag.sm.report.repository.entity.workflow.PostReportDetails;
import zag.sm.report.repository.entity.workflow.WorkflowRequest;
import zag.sm.report.repository.jpa.CategoryJPARepository;
import zag.sm.report.repository.jpa.ReportJPARepository;
import zag.sm.report.repository.jpa.StatusJPARepository;
import zag.sm.report.repository.jpa.workflow.PostReportDetailsRepo;

import static zag.library.common.enums.AppHeaders.AUTHORIZATION;
import static zag.library.common.enums.AppHeaders.EVENT_NAME;
import static zag.library.session.core.model.enums.CommonRequestContextKeys.USER_ID;
import static zag.library.session.core.model.enums.CommonRequestContextKeys.USER_TOKEN;
import static zag.sm.report.model.enums.ReportErrors.CATEGORY_NOT_FOUND;
import static zag.sm.report.model.enums.ReportErrors.REPORT_ALREADY_EXISTS;
import static zag.sm.report.model.enums.ReportEvents.CREATED_REPORT;
import static zag.sm.report.model.enums.ReportStatuses.PENDING;

@Service("ReportServiceImpl")
@AllArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final ReportJPARepository reportRepository;
    private final PostReportDetailsRepo postReportDetailsRepo;
    private final StatusJPARepository statusRepository;
    private final CategoryJPARepository categoryRepository;
    private final RequestContext context;
    private final ReportMapper reportMapper;
    private final JmsTemplate jmsTemplate;
    private final PostService postService;

    @Override
    public WorkflowRequest createPostReport(WorkflowRequest request, Long postId, ReportRequestDTO reportRequestDTO) {
        Long currentUserId = context.get(USER_ID, Long.class);

        Category category = categoryRepository.findById(reportRequestDTO.getCategoryId())
                .orElseThrow(() -> new BusinessException(CATEGORY_NOT_FOUND));

        PostReportDetails postReportDetails = PostReportDetails.builder()
                .category(category)
                .reason(reportRequestDTO.getReason())
                .rejectReason(null)
                .postId(postId)
                .request(request)
                .build();

        postReportDetailsRepo.save(postReportDetails);


        System.out.println("Execute Method Id Done");
        return request;
    }


    @Override
    public void generateReport(Long postId, ReportRequestDTO reportRequestDTO) {
        Long currentUserId = context.get(USER_ID, Long.class);

        Category category = categoryRepository.findById(reportRequestDTO.getCategoryId())
                .orElseThrow(() -> new BusinessException(CATEGORY_NOT_FOUND));
        Report report = reportMapper.toReport(reportRequestDTO, currentUserId, postId);

        if (reportRepository.existsByPostIdAndCreatedByIdAndStatus(postId, currentUserId)) {
            throw new BusinessException(REPORT_ALREADY_EXISTS);
        }

        report.setCategory(category);
        report.setStatus(statusRepository.findById(PENDING.getId()).get());
        reportRepository.save(report);

        PostVTO post = postService.getPostById(report.getPostId());

        System.out.println(reportMapper.toReportEventData(report, post.getCreatedBy().getId().longValue()));

        Long postOwnerId = post.getCreatedBy().getId().longValue();

        jmsTemplate.convertAndSend(
                ReportDomains.REPORT.destination(),
                reportMapper.toReportEventData(report, postOwnerId),
                message -> {
                    message.setStringProperty(EVENT_NAME.mqHeader(), CREATED_REPORT.name());
                    return message;
                });

    }


}

package zag.sm.report.service.workflow;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import zag.library.session.api.service.RequestContext;
import zag.sm.report.repository.entity.workflow.Workflow;
import zag.sm.report.repository.entity.workflow.WorkflowRequest;
import zag.sm.report.repository.entity.workflow.WorkflowTransition;
import zag.sm.report.repository.jpa.workflow.WorkflowRepository;
import zag.sm.report.repository.jpa.workflow.WorkflowRequestRepository;
import zag.sm.report.repository.jpa.workflow.WorkflowTransitionRepository;

import java.util.Date;

import static zag.library.session.core.model.enums.CommonRequestContextKeys.USER_ID;

@AllArgsConstructor
@Service
public class RequestServiceImpl implements RequestService {

    private final WorkflowRequestRepository requestRepo;
    private final WorkflowTransitionRepository transitionRepo;
    private final WorkflowRepository workflowRepo;
    private final RequestContext context;

    @Override
    public WorkflowRequest createRequest(int workflowId, WorkflowTransition transition) {
        Long currentUserId = context.get(USER_ID, Long.class);

        Workflow workflow = workflowRepo.findById(workflowId).orElseThrow(
                () -> new RuntimeException("This Workflow Not Exist")
        );

        WorkflowTransition transition1 = transitionRepo.findById(transition.getId()).orElseThrow(
                () -> new RuntimeException("This Transition Not Exist")
        );

        WorkflowRequest request = WorkflowRequest.builder()
                .createdById(currentUserId)
                .currentStatus(transition.getFromStatus())
                .workflow(workflow)
                .createdOn(new Date())
                .build();

        return requestRepo.save(request);
    }

    @Override
    public WorkflowRequest updateRequest(WorkflowRequest request, WorkflowTransition transition) {

        WorkflowRequest existRequest = requestRepo.findById(request.getId()).orElseThrow(
                () -> new RuntimeException("This Request Not Found")
        );
        existRequest.setCurrentStatus(transition.getToStatus());
        existRequest.setLastModifiedOn(new Date());

        return requestRepo.save(existRequest);
    }


}

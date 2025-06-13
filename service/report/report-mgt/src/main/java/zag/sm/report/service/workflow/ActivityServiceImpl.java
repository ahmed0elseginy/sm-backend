package zag.sm.report.service.workflow;

import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import zag.sm.report.model.generated.ReportRequestDTO;
import zag.sm.report.repository.entity.workflow.Workflow;
import zag.sm.report.repository.entity.workflow.WorkflowActivity;
import zag.sm.report.repository.entity.workflow.WorkflowRequest;
import zag.sm.report.repository.entity.workflow.WorkflowTransition;
import zag.sm.report.repository.jpa.workflow.WorkflowActivityRepo;
import zag.sm.report.repository.jpa.workflow.WorkflowRepository;
import zag.sm.report.repository.jpa.workflow.WorkflowTransitionRepository;

import java.lang.reflect.Method;
import java.util.List;

@AllArgsConstructor
@Service
public class ActivityServiceImpl implements ActivityService {

    private final WorkflowActivityRepo activityRepo;
    private final WorkflowRepository workflowRepo;
    private final WorkflowTransitionRepository transitionRepo;
    private final ApplicationContext context;

    @Override
    public List<WorkflowActivity> findTransitionActivity(int workflowId, int transitionId) {
        Workflow workflow = workflowRepo.findById(workflowId).orElseThrow(
                () -> new RuntimeException("This Workflow Not Found")
        );

        WorkflowTransition transition = transitionRepo.findById(transitionId).orElseThrow(
                () -> new RuntimeException("This Transition Not Found")
        );

        System.out.println(activityRepo.findActivitiesByTransitionId(transitionId));
        return activityRepo.findActivitiesByTransitionId(transitionId);
    }

    @Override
    public WorkflowRequest executeActivity(WorkflowRequest request, List<WorkflowActivity> activities, Long postId, ReportRequestDTO reportRequestDTO) {
        activities.forEach(activity -> {
            try {
                String className = activity.getClassName(); // should be bean name like "reportServiceImpl"
                String methodName = activity.getMethodName(); // e.g. "createPostReport"

                Object service = context.getBean(className);

                Method method = service.getClass().getMethod(
                        methodName,
                        WorkflowRequest.class,
                        Long.class,
                        ReportRequestDTO.class
                );

                method.invoke(service, request, postId, reportRequestDTO);
                System.out.println("executeActivity is done");

            } catch (Exception e) {
                throw new RuntimeException("Failed to execute activity: " + activity.getClassName() + "#" + activity.getMethodName(), e);
            }
        });

        return request;
    }

}

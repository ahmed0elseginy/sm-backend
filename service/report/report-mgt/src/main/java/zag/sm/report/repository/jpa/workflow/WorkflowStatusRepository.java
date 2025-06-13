package zag.sm.report.repository.jpa.workflow;

import org.springframework.data.jpa.repository.JpaRepository;
import zag.sm.report.repository.entity.workflow.WorkflowRequest;
import zag.sm.report.repository.entity.workflow.WorkflowStatus;

public interface WorkflowStatusRepository extends JpaRepository<WorkflowStatus, Integer> {
}

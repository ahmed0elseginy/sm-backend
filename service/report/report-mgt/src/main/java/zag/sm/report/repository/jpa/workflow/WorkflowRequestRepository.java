package zag.sm.report.repository.jpa.workflow;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zag.sm.report.repository.entity.workflow.WorkflowRequest;

@Repository
public interface WorkflowRequestRepository extends JpaRepository<WorkflowRequest, Long> {
}

package zag.sm.report.repository.jpa.workflow;

import org.springframework.data.jpa.repository.JpaRepository;
import zag.sm.report.repository.entity.workflow.Workflow;

public interface WorkflowRepository extends JpaRepository<Workflow, Integer> {
}

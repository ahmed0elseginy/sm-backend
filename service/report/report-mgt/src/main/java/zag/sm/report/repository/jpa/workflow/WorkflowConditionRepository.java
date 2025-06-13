package zag.sm.report.repository.jpa.workflow;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zag.sm.report.repository.entity.workflow.WorkflowCondition;

@Repository
public interface WorkflowConditionRepository extends JpaRepository<WorkflowCondition, Integer> {
}

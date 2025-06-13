package zag.sm.report.repository.jpa.workflow;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import zag.sm.report.repository.entity.Report;
import zag.sm.report.repository.entity.workflow.WorkflowAction;

import java.util.List;

@Repository
public interface WorkflowActionRepository extends JpaRepository<WorkflowAction, Integer> {

    @Query("""
    SELECT a
    FROM WorkflowAction a
    JOIN a.transitions t
     WHERE t.fromStatus IS NULL AND a.workflow.id = :workflowId
""")
    WorkflowAction findInitialActionByWorkflowId(@Param("workflowId") int workflowId);



}

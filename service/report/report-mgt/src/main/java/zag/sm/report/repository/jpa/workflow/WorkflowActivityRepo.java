package zag.sm.report.repository.jpa.workflow;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import zag.sm.report.repository.entity.workflow.WorkflowActivity;

import java.util.List;

@Repository
public interface WorkflowActivityRepo extends JpaRepository<WorkflowActivity, Integer> {

    @Query("SELECT a FROM WorkflowActivity a JOIN a.transitions t WHERE t.id = :transitionId")
    List<WorkflowActivity> findActivitiesByTransitionId(@Param("transitionId") int transitionId);


}

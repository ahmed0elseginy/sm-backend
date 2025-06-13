package zag.sm.report.repository.jpa.workflow;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import zag.sm.report.repository.entity.workflow.WorkflowActivity;
import zag.sm.report.repository.entity.workflow.WorkflowCondition;
import zag.sm.report.repository.entity.workflow.WorkflowTransition;

import java.util.List;
import java.util.Optional;

@Repository
public interface WorkflowTransitionRepository extends JpaRepository<WorkflowTransition, Integer> {

   Optional<List<WorkflowTransition>>findByFromStatusId(@Param("fromStatusId") Integer fromstatusId);

   @Query("SELECT t FROM WorkflowTransition t JOIN t.actions a WHERE a.id = :actionId")
   List<WorkflowTransition> findTransitionByAction(@Param("actionId") int actionId);

/*
   @Query(value = """
    SELECT DISTINCT action_id
    FROM wf_transition_action ta
    WHERE ta.transition_id IN (:transitionIds)
""", nativeQuery = true)
   List<Integer> findActionsByTransition(@Param("transitionIds") List<Integer> transitionIds);

   @Query("""
    SELECT ta
    FROM WFTransitionCondition ta
    WHERE ta.transition.id = :transitionId
   """)
   WorkflowCondition findConditionsByTransition(@Param("transitionId") Integer transitionId);
*/
}

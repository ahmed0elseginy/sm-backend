package zag.sm.point.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zag.sm.point.repository.entity.Event;

@Repository
public interface EventJPARepository extends JpaRepository<Event, Integer> {

}

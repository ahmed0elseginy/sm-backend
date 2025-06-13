package zag.sm.point.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zag.sm.point.repository.entity.EventSetting;

@Repository
public interface EventSettingsJPARepository extends JpaRepository<EventSetting, Integer> {

}

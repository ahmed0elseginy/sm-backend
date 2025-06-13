package zag.sm.point.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import zag.sm.point.repository.entity.UserPoints;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface UserPointsJPARepository extends JpaRepository<UserPoints, Integer> {

    boolean existsByUserIdAndEventId(Long userId, Integer eventId);

    Optional<UserPoints> findByUserIdAndEventId(Long userId, Integer eventId);
}

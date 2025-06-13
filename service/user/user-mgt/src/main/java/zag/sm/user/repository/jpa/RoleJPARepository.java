package zag.sm.user.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zag.sm.user.repository.entity.Role;

@Repository
public interface RoleJPARepository extends JpaRepository<Role, Integer> {
}

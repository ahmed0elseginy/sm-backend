package zag.sm.user.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zag.sm.user.repository.entity.UserRole;
import zag.sm.user.repository.entity.pk.UserRoleId;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRoleJPARepository extends JpaRepository<UserRole, UserRoleId> {
    List<UserRole> findAllByUserId(Long userId);

    UserRole findByUserIdAndRoleId(Long userId, Integer roleId);
}

package zag.sm.user.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import zag.sm.user.repository.entity.User;

import java.util.List;

@Repository
public interface UserJPARepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    User findByMobileNumber(String mobileNumber);

    @Query("SELECT u FROM User u WHERE u.id IN :ids")
    List<User>findAllByIds(@Param("ids")List<Long> ids);

}

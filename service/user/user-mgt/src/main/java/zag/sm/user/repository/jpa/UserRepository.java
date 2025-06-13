package zag.sm.user.repository.jpa;

import zag.sm.user.model.filter.UserSearchFilter;
import zag.sm.user.repository.entity.User;

import java.util.List;

public interface UserRepository {

    List<User> findUsersByFilter(UserSearchFilter filter);

}

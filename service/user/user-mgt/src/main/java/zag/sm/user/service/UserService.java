package zag.sm.user.service;

import zag.sm.user.model.generated.UserResultSet;

import java.util.List;

public interface UserService {

    UserResultSet getUsers(List<Long> userIds,String fullName,int numOfPage,int pageSize);

}

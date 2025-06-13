package zag.sm.post.service;

import zag.sm.post.model.vto.UserResultSet;

import java.util.List;

public interface UserService {

    UserResultSet getUsersByIds(List<Long> userIds);

}

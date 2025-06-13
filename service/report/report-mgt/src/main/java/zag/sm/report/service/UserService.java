package zag.sm.report.service;

import zag.sm.report.model.vto.UserResultSet;

import java.util.List;

public interface UserService {

    UserResultSet getUsersByIds(List<Long> userIds);

//    public LightUserVTO getUserById(Long userId);

}

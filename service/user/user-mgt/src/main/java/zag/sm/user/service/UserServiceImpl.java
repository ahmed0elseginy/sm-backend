package zag.sm.user.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import zag.library.filter.PaginationInfo;
import zag.sm.user.model.filter.UserSearchFilter;
import zag.sm.user.model.generated.LightUserVTO;
import zag.sm.user.model.generated.UserResultSet;
import zag.sm.user.repository.entity.User;
import zag.sm.user.repository.jpa.UserRepository;
import zag.sm.user.repository.jpa.UserRoleJPARepository;

import java.util.List;

@Service
@AllArgsConstructor

public class UserServiceImpl implements UserService {

    private final UserRoleJPARepository userRoleRepository;

    private final UserRepository userRepository;

    @Override
    public UserResultSet getUsers(List<Long> userIds, String fullName, int numOfPage, int pageSize) {

        UserSearchFilter filter = UserSearchFilter.builder()
                .ids(userIds)
                .fullName(fullName)
                .pagination(PaginationInfo.builder().pageOffset(numOfPage * pageSize).pageSize(pageSize).build())
                .build();

        //List<User> users=userRepository.findAllByIds(userIds);
        List<User> users = userRepository.findUsersByFilter(filter);

        List<LightUserVTO> lightUserList = users.stream().map(
                user -> {
                    return LightUserVTO.builder()
                            .id(user.getId())
                            .fullName(user.getFirstName() + " " + user.getLastName())
                            .build();
                }
        ).toList();

        return UserResultSet.builder().data(lightUserList).build();

    }



}

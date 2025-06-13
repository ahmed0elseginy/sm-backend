package zag.sm.user.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import zag.library.error.exception.BusinessException;
import zag.library.session.api.service.RequestContext;
import zag.sm.user.mapper.UserMapper;
import zag.sm.user.model.generated.UserProfileDTO;
import zag.sm.user.model.generated.UserProfileVTO;
import zag.sm.user.repository.entity.User;
import zag.sm.user.repository.jpa.UserJPARepository;

import java.util.Optional;

import static zag.library.session.core.model.enums.CommonRequestContextKeys.USER_ID;
import static zag.sm.user.model.enums.UserErrors.USER_NOT_FOUND;

@Service
@AllArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {

    private final UserJPARepository userRepository;
    private final RequestContext context;
    private final UserMapper mapper;

    @Override
    public UserProfileVTO getUserProfileDetails() {
        Long currentUserId = context.get(USER_ID, Long.class);
        Optional<User> userOptional = userRepository.findById(currentUserId);

        if (userOptional.isEmpty())
            throw new BusinessException(USER_NOT_FOUND);

        return mapper.toUserProfileVTO(userOptional.get());
    }

    @Override
    public void updateUserProfileDetails(UserProfileDTO userProfileDTO) {
        Long currentUserId = context.get(USER_ID, Long.class);
        Optional<User> userOptional = userRepository.findById(currentUserId);

        if (userOptional.isEmpty())
            throw new BusinessException(USER_NOT_FOUND);

        User _user = userOptional.get();
        _user = mapper.updateUser(userProfileDTO, _user);
        _user.setLastModifiedBy(_user);
        userRepository.save(_user);
    }

    private String getTokenFromSecurityContext() {
        Object credentials = SecurityContextHolder.getContext().getAuthentication().getCredentials();
        return (credentials != null) ? credentials.toString() : "";
    }

}

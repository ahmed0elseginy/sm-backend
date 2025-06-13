package zag.sm.user.mapper;

import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import zag.library.security.api.service.SecurityService;
import zag.library.security.core.model.vto.SecurityAuthorityVTO;
import zag.library.security.core.model.vto.SecurityUserVTO;
import zag.library.session.api.service.RequestContext;
import zag.library.session.core.model.enums.CommonRequestContextKeys;
import zag.sm.user.model.generated.CreateUserDTO;
import zag.sm.user.model.generated.UserProfileDTO;
import zag.sm.user.model.generated.UserProfileVTO;
import zag.sm.user.repository.entity.User;
import zag.sm.user.repository.entity.UserRole;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true),
        imports = {Collectors.class, Date.class, Long.class, CommonRequestContextKeys.class})
@MapperConfig(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public abstract class UserMapper {
    @Autowired
    protected SecurityService securityService;

    @Autowired
    protected RequestContext context;

    @Mapping(target = "password", expression = "java(securityService.encryptPassword(dto.getPassword()))")
    public abstract User toUser(CreateUserDTO dto);

    public abstract UserProfileVTO toUserProfileVTO(User user);

    @Mapping(target = "lastModifiedOn", expression = "java(new Date())")
    public abstract User updateUser(UserProfileDTO dto, @MappingTarget User user);

    @Mapping(target = "username", source = "email")
    public abstract SecurityUserVTO toSecurityUserVTO(User user);

    public Long getCurrentUserId() {
        return context.get(CommonRequestContextKeys.USER_ID, Long.class);
    }

    @Mapping(target = "role", source = "role.id")
    public abstract SecurityAuthorityVTO toSecurityAuthorityVTOList(UserRole from);

    public abstract List<SecurityAuthorityVTO> toSecurityAuthorityVTOList(List<UserRole> roles);



}

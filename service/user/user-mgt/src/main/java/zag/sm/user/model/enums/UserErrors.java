package zag.sm.user.model.enums;

import lombok.AllArgsConstructor;
import zag.library.common.interfaces.Domains;
import zag.library.error.interfaces.Errors;

import static zag.sm.user.model.enums.UserDomains.ROLE;
import static zag.sm.user.model.enums.UserDomains.USER;

@AllArgsConstructor
public enum UserErrors implements Errors<UserErrors, UserDomains> {
    USER_NOT_FOUND(USER, "0001", "User not found"),
    MOBILE_NUMBER_ALREADY_EXIST(USER, "0002", "Mobile Number already exists"),
    EMAIL_ALREADY_EXIST(USER, "0003", "This email already exists"),
    ROLE_NOT_FOUND(ROLE, "0001", "Role not found"),

    ;
    private final Domains<UserDomains> domain;
    private final String code;
    private final String defaultMessage;

    @Override
    public Domains<UserDomains> domain() {
        return domain;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String defaultMessage() {
        return defaultMessage;
    }
}

package zag.library.security.api.model.enums;

import lombok.AllArgsConstructor;
import zag.library.common.interfaces.Domains;
import zag.library.error.interfaces.Errors;

import static zag.library.security.api.model.enums.SecurityDomains.*;

@AllArgsConstructor
public enum SecurityErrors implements Errors<SecurityErrors, SecurityDomains> {
    INVALID_CREDENTIALS(SECURITY, "0001", "Invalid credentials, Wrong Email or Password"),

    USER_NOT_FOUND(LOGIN, "0001", "User not Found"),

    MISSING_TOKEN(JWT_TOKEN, "0001", "Missing or Non Bearer Authorization Token in the Request"),
    MISSING_USERNAME(JWT_TOKEN, "0002", "Missing username in the JWT Token"),
    INVALID_TOKEN(JWT_TOKEN, "0003", "Invalid Authorization Token provided"),
    TOKEN_USER_NOT_FOUND(LOGIN, "0004", "User of the token is not Found in the System"),
    ;
    private final Domains<SecurityDomains> domain;
    private final String code;
    private final String defaultMessage;

    @Override
    public Domains<SecurityDomains> domain() {
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

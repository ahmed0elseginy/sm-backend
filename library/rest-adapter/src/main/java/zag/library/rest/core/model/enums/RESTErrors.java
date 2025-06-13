package zag.library.rest.core.model.enums;

import lombok.AllArgsConstructor;
import zag.library.common.interfaces.Domains;
import zag.library.error.interfaces.Errors;

@AllArgsConstructor
public enum RESTErrors implements Errors<RESTErrors, RESTDomains> {
    INTERNAL_SERVER_ERROR(RESTDomains.REST, "0001", "Internal Server Error"),
    UN_AUTHENTICATED_REQ(RESTDomains.REST, "0002", "Request isn't Authenticated"),
    UN_AUTHORIZED_REQ(RESTDomains.REST, "0003", "User isn't Authorized to access this resource"),
    INVALID_REQUEST(RESTDomains.REST, "0004", "Invalid Request received"),
    ;
    private final Domains<RESTDomains> domain;
    private final String code;
    private final String defaultMessage;

    @Override
    public Domains<RESTDomains> domain() {
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

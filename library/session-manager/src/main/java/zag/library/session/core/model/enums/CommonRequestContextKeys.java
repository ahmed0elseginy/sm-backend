package zag.library.session.core.model.enums;


import zag.library.session.api.model.interfaces.RequestContextKeys;

public enum CommonRequestContextKeys implements RequestContextKeys<CommonRequestContextKeys> {
    USER_ID("Current User Id"),
    ROLES_IDS("Current User Roles Ids"),
    USER_TOKEN("Current User Token"),
    USERNAME("Current Username"),
    USER_EMAIL("Current User Email"),
    USER_MOBILE("Current User Mobile"),
    LANGUAGE("Current Language"),
    USER_AGENT("User Agent"),
    REQUEST_TYPE("Request Type"),
    REQUEST_DESTINATION("Request Destination"),
    REQUEST_ID("Request Id"),
    REQUEST_DATE("Request Date"),
    ;

    private final String title;

    CommonRequestContextKeys(String title) {
        this.title = title;
    }

    @Override
    public String title() {
        return title;
    }
}

package zag.sm.point.model.enums;

import lombok.AllArgsConstructor;
import zag.library.common.interfaces.Domains;

@AllArgsConstructor
public enum UserDomains implements Domains<UserDomains> {
    REGISTER(3, "sm.user"),
//    LOGIN(3, "sm.user"),
    USER_ROLE(3, "sm.user"),
//    REMOVE_ADMIN_ROLE(3, "sm.user")
    ;

    private final Integer id;
    private final String destination;

    @Override
    public Integer id() {
        return id;
    }

    @Override
    public String destination() {
        return destination;
    }

}

package zag.sm.user.model.enums;

import lombok.AllArgsConstructor;
import zag.library.common.interfaces.Domains;

@AllArgsConstructor
public enum UserDomains implements Domains<UserDomains> {
    USER(201, ""), ROLE(202, ""),
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

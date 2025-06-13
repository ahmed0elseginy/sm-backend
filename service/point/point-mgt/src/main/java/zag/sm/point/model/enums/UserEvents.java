package zag.sm.point.model.enums;

import lombok.AllArgsConstructor;
import zag.library.common.interfaces.Domains;
import zag.library.common.interfaces.Events;

import static zag.sm.point.model.enums.PointDomains.COMMENT;
import static zag.sm.point.model.enums.UserDomains.REGISTER;
import static zag.sm.point.model.enums.UserDomains.USER_ROLE;

@AllArgsConstructor
public enum UserEvents implements Events {
    REGISTER_USER(6, REGISTER),
    ASSIGN_ADMIN_ROLE(7, USER_ROLE),
    REMOVE_ADMIN_ROLE(8, USER_ROLE),
    ;

    private final Integer id;
    private final Domains domain;

    @Override
    public Integer id() {
        return id;
    }

    @Override
    public Domains domain() {
        return domain;
    }
}

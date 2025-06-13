package zag.sm.user.model.enums;

import lombok.AllArgsConstructor;
import zag.library.common.interfaces.Domains;
import zag.library.common.interfaces.Events;

import static zag.sm.user.model.enums.UserDomains.USER;

@AllArgsConstructor
public enum UserEvents implements Events {
    CREATE_USER(1, USER),;

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

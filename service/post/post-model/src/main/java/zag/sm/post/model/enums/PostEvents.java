package zag.sm.post.model.enums;

import lombok.AllArgsConstructor;
import zag.library.common.interfaces.Domains;
import zag.library.common.interfaces.Events;

import static zag.sm.post.model.enums.PostDomains.POST;

@AllArgsConstructor
public enum PostEvents implements Events {
    CREATE_POST(1, POST),
    DELETE_POST(2, POST)
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

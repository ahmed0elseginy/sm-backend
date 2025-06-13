package zag.sm.post.model.enums;

import lombok.AllArgsConstructor;
import zag.library.common.interfaces.Domains;
import zag.library.common.interfaces.Events;

import static zag.sm.post.model.enums.PostDomains.COMMENT;

@AllArgsConstructor
public enum CommentEvents implements Events {
    CREATE_COMMENT(4, COMMENT),
    DELETE_COMMENT(5, COMMENT),
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

package zag.sm.post.model.enums;

import lombok.AllArgsConstructor;
import zag.library.common.interfaces.Domains;
import zag.library.common.interfaces.Events;

import static zag.sm.post.model.enums.PostDomains.REACTION;

@AllArgsConstructor
public enum CommentReactionEvents implements Events {

    CREATE_REACTION(1, REACTION),
    UPDATE_REACTION(2, REACTION),
    DELETE_REACTION(3, REACTION);;

    private Integer id;
    private Domains domain;

    @Override
    public Integer id() {
        return id;
    }

    @Override
    public Domains domain() {
        return domain;
    }
}

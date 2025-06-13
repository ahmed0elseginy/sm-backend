package zag.sm.post.model.enums;

import lombok.AllArgsConstructor;
import zag.library.common.interfaces.Domains;
import zag.library.error.interfaces.Errors;
import zag.sm.post.model.enums.PostDomains;

import static zag.sm.post.model.enums.PostDomains.*;

@AllArgsConstructor
public enum PostErrors implements Errors<PostErrors, PostDomains> {
    POST_NOT_FOUND(POST, "0001", "Post not found"),
    COMMENT_NOT_FOUND(COMMENT, "0001", "Comment not found"),
    IN_CORRECT_POST(COMMENT, "0002", "Post Id provided is not the same as the post id in the comment"),
    IN_CORRECT_USER(COMMENT, "0003", "Comment not authorized by this user"),
    NOT_PERMITTED(POST, "0003", "Not permitted"),
    REACTED_USER_ID(REACTION, "0001", "You already reacted to this comment"),
    ;

    private final Domains<PostDomains> domain;
    private final String code;
    private final String defaultMessage;

    @Override
    public Domains<PostDomains> domain() {
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

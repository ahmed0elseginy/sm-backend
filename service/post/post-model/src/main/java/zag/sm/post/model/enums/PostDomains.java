package zag.sm.post.model.enums;

import lombok.AllArgsConstructor;
import zag.library.common.interfaces.Domains;

@AllArgsConstructor
public enum PostDomains implements Domains<PostDomains> {
    POST(201, "sm.post"),
    COMMENT(202, "sm.comment"),
    REACTION(203, "sm.reaction");

    public static final String POST_TOPIC_NAME="#{T(zag.sm.post.model.enums.PostDomains).POST.destination()}";
    public static final String COMMENT_TOPIC_NAME="#{T(zag.sm.post.model.enums.PostDomains).COMMENT.destination()}";

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

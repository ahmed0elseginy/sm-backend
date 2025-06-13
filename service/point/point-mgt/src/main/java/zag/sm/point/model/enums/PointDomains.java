package zag.sm.point.model.enums;

import lombok.AllArgsConstructor;
import zag.library.common.interfaces.Domains;

@AllArgsConstructor
public enum PointDomains implements Domains<PointDomains> {
    COMMENT(201, "sm.comment"),
    EVENT(202, "sm.event"),
    POINT(203, "sm.point"),

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

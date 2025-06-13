package zag.sm.point.model.enums;

import lombok.AllArgsConstructor;
import zag.library.common.interfaces.Domains;
import zag.library.common.interfaces.Events;

@AllArgsConstructor
public enum PointEvents implements Events<PointEvents, PointDomains> {
    // CREATE_POINT(1, POINT),
    ;

    private final Integer id;
    private final Domains<PointDomains> domain;

    @Override
    public Integer id() {
        return id;
    }

    @Override
    public Domains<PointDomains> domain() {
        return domain;
    }

}

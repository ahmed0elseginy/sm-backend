package zag.sm.point.model.enums;

import lombok.AllArgsConstructor;
import zag.library.common.interfaces.Domains;
import zag.library.error.interfaces.Errors;

import static zag.sm.point.model.enums.PointDomains.EVENT;
import static zag.sm.point.model.enums.PointDomains.POINT;

@AllArgsConstructor
public enum PointErrors implements Errors<PointErrors, PointDomains> {
    EVENT_NOT_FOUND(EVENT, "0001", "Event not found"),
    EVENT_NOT_ACTIVE(EVENT, "0002", "Event is not active, points cannot be awarded"),
    POINTS_ALREADY_EXIST(POINT, "0001", "Points already awarded for this comment"),
    POINTS_NOT_FOUND(POINT, "0002", "No Points for this comment"),
    EVENT_SETTINGS_NOT_FOUND(EVENT, "0003", "Event Settings not found"),
    ;
    private final Domains<PointDomains> domain;
    private final String code;
    private final String defaultMessage;

    @Override
    public Domains<PointDomains> domain() {
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

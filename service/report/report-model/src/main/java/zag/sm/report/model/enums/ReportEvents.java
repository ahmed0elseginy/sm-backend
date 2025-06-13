package zag.sm.report.model.enums;

import lombok.AllArgsConstructor;
import zag.library.common.interfaces.Domains;
import zag.library.common.interfaces.Events;

import static zag.sm.report.model.enums.ReportDomains.REPORT;

@AllArgsConstructor
public enum ReportEvents implements Events {

    CREATED_REPORT(3, REPORT),
    APPROVE_REPORT(9, REPORT),
    REJECT_REPORT(10, REPORT);

    private final Integer id;
    private final Domains domain;


    @Override
    public Integer id() {
        return id;
    }

    @Override
    public Domains<?> domain() {
        return domain;
    }
}

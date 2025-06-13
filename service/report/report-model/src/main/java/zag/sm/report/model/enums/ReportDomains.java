package zag.sm.report.model.enums;

import lombok.AllArgsConstructor;
import zag.library.common.interfaces.Domains;

@AllArgsConstructor
public enum ReportDomains implements Domains<ReportDomains> {
    REPORT(301, "sm.report"),
    CATEGORY(302, "sm.category"),
    ;

    public static final String REPORT_TOPIC_NAME="#{T(zag.sm.report.model.enums.ReportDomains).REPORT.destination()}";

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

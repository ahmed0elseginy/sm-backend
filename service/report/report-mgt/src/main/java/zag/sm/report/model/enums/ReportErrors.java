package zag.sm.report.model.enums;

import lombok.AllArgsConstructor;
import zag.library.common.interfaces.Domains;
import zag.library.error.interfaces.Errors;

import static zag.sm.report.model.enums.ReportDomains.CATEGORY;
import static zag.sm.report.model.enums.ReportDomains.REPORT;

@AllArgsConstructor
public enum ReportErrors implements Errors<ReportErrors, ReportDomains> {
    REPORT_NOT_FOUND(REPORT, "0001", "Report not found"),
    REPORT_ALREADY_EXISTS(REPORT, "0003", "Your Previous Report Is Under Process"),
    CATEGORY_NOT_FOUND(CATEGORY, "0003", "Category not found"),
    UNSUPPORTED_ACTION(REPORT, "0002", "Unsupported Action"),
    MISSING_DATA(REPORT, "0004", "Missing Data"),
    STATUS_NOT_FOUND(REPORT, "0005", "Status Not Found")
    ;
    private final Domains<ReportDomains> domain;
    private final String code;
    private final String defaultMessage;

    @Override
    public Domains<ReportDomains> domain() {
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

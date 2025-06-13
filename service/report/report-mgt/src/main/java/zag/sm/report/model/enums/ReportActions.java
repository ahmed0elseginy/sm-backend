package zag.sm.report.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static zag.sm.report.model.enums.ReportStatuses.APPROVED;
import static zag.sm.report.model.enums.ReportStatuses.REJECTED;

@Getter
@AllArgsConstructor
public enum ReportActions {

    APPROVE(APPROVED),
    REJECT(REJECTED);

    private final ReportStatuses status;

}

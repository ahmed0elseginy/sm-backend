package zag.sm.report.model.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ReportStatuses {

    PENDING(1),
    APPROVED(2),
    CASCADED_APPROVAL(3),
    REJECTED(4);

    private final Integer id;


}

package zag.sm.report.repository.jpa;

import zag.sm.report.model.dto.LightJpaReport;
import zag.sm.report.model.filter.ReportSearchFilter;


public interface ReportRepository {

    LightJpaReport getAllReport(ReportSearchFilter filter);

}

package zag.sm.report.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import zag.sm.report.repository.entity.Report;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LightJpaReport {

    List<Report>reports;
    Long totalCount;


}

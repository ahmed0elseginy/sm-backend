package zag.sm.report.model.filter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import zag.library.filter.SearchFilter;

import java.util.Date;

@Data
@AllArgsConstructor
@SuperBuilder
public class ReportSearchFilter extends SearchFilter {

    private Date createdOnFrom;
    private Date createOnTo;
    private Integer statusId;
    private Integer categoryId;


}

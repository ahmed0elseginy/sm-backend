package zag.sm.report.model.generated;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * LightReportResultSet
 */
@lombok.Builder
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.6.0")
public class LightReportResultSet implements Serializable {

    private static final long serialVersionUID = 1L;

    @Valid
    private List<@Valid LightReportListItem> data = new ArrayList<>();

    private Long total;

    public LightReportResultSet data(List<@Valid LightReportListItem> data) {
        this.data = data;
        return this;
    }

    public LightReportResultSet addDataItem(LightReportListItem dataItem) {
        if (this.data == null) {
            this.data = new ArrayList<>();
        }
        this.data.add(dataItem);
        return this;
    }

    /**
     * Get data
     *
     * @return data
     */
    @Valid
    @Schema(name = "data", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("data")
    public List<@Valid LightReportListItem> getData() {
        return data;
    }

    public void setData(List<@Valid LightReportListItem> data) {
        this.data = data;
    }

    public LightReportResultSet total(Long total) {
        this.total = total;
        return this;
    }

    /**
     * Total Number Of Reports
     *
     * @return total
     */

    @Schema(name = "total", description = "Total Number Of Reports", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("total")
    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LightReportResultSet lightReportResultSet = (LightReportResultSet) o;
        return Objects.equals(this.data, lightReportResultSet.data)
                && Objects.equals(this.total, lightReportResultSet.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, total);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class LightReportResultSet {\n");
        sb.append("    data: ").append(toIndentedString(data)).append("\n");
        sb.append("    total: ").append(toIndentedString(total)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

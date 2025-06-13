package zag.sm.report.model.generated;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * ReportRequestDTO
 */
@lombok.Builder
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.6.0")
public class ReportRequestDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer categoryId;

    private String reason;

    public ReportRequestDTO categoryId(Integer categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    /**
     * The ID of the report category
     *
     * @return categoryId
     */
    @NotNull
    @Schema(name = "categoryId", example = "1", description = "The ID of the report category", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("categoryId")
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public ReportRequestDTO reason(String reason) {
        this.reason = reason;
        return this;
    }

    /**
     * reason about the report
     *
     * @return reason
     */

    @Schema(name = "reason", example = "The report contains false information.", description = "reason about the report", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("reason")
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ReportRequestDTO reportRequestDTO = (ReportRequestDTO) o;
        return Objects.equals(this.categoryId, reportRequestDTO.categoryId)
                && Objects.equals(this.reason, reportRequestDTO.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, reason);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ReportRequestDTO {\n");
        sb.append("    categoryId: ").append(toIndentedString(categoryId)).append("\n");
        sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
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

package zag.sm.report.model.generated;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;

import java.io.Serializable;
import java.util.Objects;

/**
 * PerformActionRequest
 */
@lombok.Builder
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor

@JsonTypeName("performAction_request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.6.0")
public class PerformActionRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private String rejectReason;

    public PerformActionRequest rejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
        return this;
    }

    /**
     * The reason for rejecting the report (if applicable)
     *
     * @return rejectReason
     */

    @Schema(name = "rejectReason", example = "The report contains false information.", description = "The reason for rejecting the report (if applicable)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("rejectReason")
    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PerformActionRequest performActionRequest = (PerformActionRequest) o;
        return Objects.equals(this.rejectReason, performActionRequest.rejectReason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rejectReason);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PerformActionRequest {\n");
        sb.append("    rejectReason: ").append(toIndentedString(rejectReason)).append("\n");
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

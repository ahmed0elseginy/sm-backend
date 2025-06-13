package zag.sm.report.model.generated;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * ReportDetails
 */
@lombok.Builder
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.6.0")
public class ReportDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    private LookupVTO category;

    private String reason;

    private LookupVTO status;

    private LightUserVTO createdBy;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date createdOn;

    private LightUserVTO lastModifiedBy;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date lastModifiedOn;

    public ReportDetails category(LookupVTO category) {
        this.category = category;
        return this;
    }

    /**
     * Get category
     *
     * @return category
     */
    @Valid
    @Schema(name = "category", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("category")
    public LookupVTO getCategory() {
        return category;
    }

    public void setCategory(LookupVTO category) {
        this.category = category;
    }

    public ReportDetails reason(String reason) {
        this.reason = reason;
        return this;
    }

    /**
     * Get reason
     *
     * @return reason
     */

    @Schema(name = "reason", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("reason")
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ReportDetails status(LookupVTO status) {
        this.status = status;
        return this;
    }

    /**
     * Get status
     *
     * @return status
     */
    @Valid
    @Schema(name = "status", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("status")
    public LookupVTO getStatus() {
        return status;
    }

    public void setStatus(LookupVTO status) {
        this.status = status;
    }

    public ReportDetails createdBy(LightUserVTO createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    /**
     * Get createdBy
     *
     * @return createdBy
     */
    @Valid
    @Schema(name = "createdBy", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("createdBy")
    public LightUserVTO getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(LightUserVTO createdBy) {
        this.createdBy = createdBy;
    }

    public ReportDetails createdOn(Date createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    /**
     * Get createdOn
     *
     * @return createdOn
     */
    @Valid
    @Schema(name = "createdOn", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("createdOn")
    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public ReportDetails lastModifiedBy(LightUserVTO lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
        return this;
    }

    /**
     * Get lastModifiedBy
     *
     * @return lastModifiedBy
     */
    @Valid
    @Schema(name = "lastModifiedBy", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("lastModifiedBy")
    public LightUserVTO getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(LightUserVTO lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public ReportDetails lastModifiedOn(Date lastModifiedOn) {
        this.lastModifiedOn = lastModifiedOn;
        return this;
    }

    /**
     * Get lastModifiedOn
     *
     * @return lastModifiedOn
     */
    @Valid
    @Schema(name = "lastModifiedOn", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("lastModifiedOn")
    public Date getLastModifiedOn() {
        return lastModifiedOn;
    }

    public void setLastModifiedOn(Date lastModifiedOn) {
        this.lastModifiedOn = lastModifiedOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ReportDetails reportDetails = (ReportDetails) o;
        return Objects.equals(this.category, reportDetails.category)
                && Objects.equals(this.reason, reportDetails.reason)
                && Objects.equals(this.status, reportDetails.status)
                && Objects.equals(this.createdBy, reportDetails.createdBy)
                && Objects.equals(this.createdOn, reportDetails.createdOn)
                && Objects.equals(this.lastModifiedBy, reportDetails.lastModifiedBy)
                && Objects.equals(this.lastModifiedOn, reportDetails.lastModifiedOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, reason, status, createdBy, createdOn, lastModifiedBy, lastModifiedOn);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ReportDetails {\n");
        sb.append("    category: ").append(toIndentedString(category)).append("\n");
        sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
        sb.append("    createdOn: ").append(toIndentedString(createdOn)).append("\n");
        sb.append("    lastModifiedBy: ").append(toIndentedString(lastModifiedBy)).append("\n");
        sb.append("    lastModifiedOn: ").append(toIndentedString(lastModifiedOn)).append("\n");
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

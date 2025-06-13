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
 * PostReportListItem
 */
@lombok.Builder
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.6.0")
public class PostReportListItem implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private LookupVTO category;

    private LookupVTO status;

    private LightUserVTO createdBy;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date createdOn;

    public PostReportListItem id(Long id) {
        this.id = id;
        return this;
    }

    /**
     * ID of the related report.
     *
     * @return id
     */

    @Schema(name = "id", description = "ID of the related report.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PostReportListItem category(LookupVTO category) {
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

    public PostReportListItem status(LookupVTO status) {
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

    public PostReportListItem createdBy(LightUserVTO createdBy) {
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

    public PostReportListItem createdOn(Date createdOn) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PostReportListItem postReportListItem = (PostReportListItem) o;
        return Objects.equals(this.id, postReportListItem.id)
                && Objects.equals(this.category, postReportListItem.category)
                && Objects.equals(this.status, postReportListItem.status)
                && Objects.equals(this.createdBy, postReportListItem.createdBy)
                && Objects.equals(this.createdOn, postReportListItem.createdOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, status, createdBy, createdOn);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PostReportListItem {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    category: ").append(toIndentedString(category)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
        sb.append("    createdOn: ").append(toIndentedString(createdOn)).append("\n");
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

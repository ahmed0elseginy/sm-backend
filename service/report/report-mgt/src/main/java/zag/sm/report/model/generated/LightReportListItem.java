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
 * LightReportListItem
 */
@lombok.Builder
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.6.0")
public class LightReportListItem implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private LightPostVTO post;

    private LightUserVTO createdBy;

    private LookupVTO category;

    private LookupVTO status;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date createdOn;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date lastModifiedOn;

    public LightReportListItem id(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     */

    @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LightReportListItem post(LightPostVTO post) {
        this.post = post;
        return this;
    }

    /**
     * Get post
     *
     * @return post
     */
    @Valid
    @Schema(name = "post", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("post")
    public LightPostVTO getPost() {
        return post;
    }

    public void setPost(LightPostVTO post) {
        this.post = post;
    }

    public LightReportListItem createdBy(LightUserVTO createdBy) {
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

    public LightReportListItem category(LookupVTO category) {
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

    public LightReportListItem status(LookupVTO status) {
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

    public LightReportListItem createdOn(Date createdOn) {
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

    public LightReportListItem lastModifiedOn(Date lastModifiedOn) {
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
        LightReportListItem lightReportListItem = (LightReportListItem) o;
        return Objects.equals(this.id, lightReportListItem.id) && Objects.equals(this.post, lightReportListItem.post)
                && Objects.equals(this.createdBy, lightReportListItem.createdBy)
                && Objects.equals(this.category, lightReportListItem.category)
                && Objects.equals(this.status, lightReportListItem.status)
                && Objects.equals(this.createdOn, lightReportListItem.createdOn)
                && Objects.equals(this.lastModifiedOn, lightReportListItem.lastModifiedOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, post, createdBy, category, status, createdOn, lastModifiedOn);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class LightReportListItem {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    post: ").append(toIndentedString(post)).append("\n");
        sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
        sb.append("    category: ").append(toIndentedString(category)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    createdOn: ").append(toIndentedString(createdOn)).append("\n");
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

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
 * PostDetailsVTO
 */
@lombok.Builder
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.6.0")
public class PostDetailsVTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String title;

    private LightUserVTO createdBy;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date createdOn;

    private String content;

    public PostDetailsVTO id(Long id) {
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

    public PostDetailsVTO title(String title) {
        this.title = title;
        return this;
    }

    /**
     * Get title
     *
     * @return title
     */

    @Schema(name = "title", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public PostDetailsVTO createdBy(LightUserVTO createdBy) {
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

    public PostDetailsVTO createdOn(Date createdOn) {
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

    public PostDetailsVTO content(String content) {
        this.content = content;
        return this;
    }

    /**
     * Get content
     *
     * @return content
     */

    @Schema(name = "content", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PostDetailsVTO postDetailsVTO = (PostDetailsVTO) o;
        return Objects.equals(this.id, postDetailsVTO.id) && Objects.equals(this.title, postDetailsVTO.title)
                && Objects.equals(this.createdBy, postDetailsVTO.createdBy)
                && Objects.equals(this.createdOn, postDetailsVTO.createdOn)
                && Objects.equals(this.content, postDetailsVTO.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, createdBy, createdOn, content);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PostDetailsVTO {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    title: ").append(toIndentedString(title)).append("\n");
        sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
        sb.append("    createdOn: ").append(toIndentedString(createdOn)).append("\n");
        sb.append("    content: ").append(toIndentedString(content)).append("\n");
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

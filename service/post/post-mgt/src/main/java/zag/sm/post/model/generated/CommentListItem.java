package zag.sm.post.model.generated;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.*;
import java.util.Date;
import java.util.Objects;
import org.hibernate.validator.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * CommentListItem
 */
@lombok.Builder
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.6.0")
public class CommentListItem implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String content;

    private LightUserVTO createdBy;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date createdOn;

    private CommentReactions currentUserReaction;

    private Long numOfLikes;

    private Long numOfDisLikes;

    public CommentListItem id(Long id) {
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

    public CommentListItem content(String content) {
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

    public CommentListItem createdBy(LightUserVTO createdBy) {
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

    public CommentListItem createdOn(Date createdOn) {
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

    public CommentListItem currentUserReaction(CommentReactions currentUserReaction) {
        this.currentUserReaction = currentUserReaction;
        return this;
    }

    /**
     * Get currentUserReaction
     *
     * @return currentUserReaction
     */
    @Valid
    @Schema(name = "currentUserReaction", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("currentUserReaction")
    public CommentReactions getCurrentUserReaction() {
        return currentUserReaction;
    }

    public void setCurrentUserReaction(CommentReactions currentUserReaction) {
        this.currentUserReaction = currentUserReaction;
    }

    public CommentListItem numOfLikes(Long numOfLikes) {
        this.numOfLikes = numOfLikes;
        return this;
    }

    /**
     * Get numOfLikes
     *
     * @return numOfLikes
     */

    @Schema(name = "numOfLikes", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("numOfLikes")
    public Long getNumOfLikes() {
        return numOfLikes;
    }

    public void setNumOfLikes(Long numOfLikes) {
        this.numOfLikes = numOfLikes;
    }

    public CommentListItem numOfDisLikes(Long numOfDisLikes) {
        this.numOfDisLikes = numOfDisLikes;
        return this;
    }

    /**
     * Get numOfDisLikes
     *
     * @return numOfDisLikes
     */

    @Schema(name = "numOfDisLikes", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("numOfDisLikes")
    public Long getNumOfDisLikes() {
        return numOfDisLikes;
    }

    public void setNumOfDisLikes(Long numOfDisLikes) {
        this.numOfDisLikes = numOfDisLikes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CommentListItem commentListItem = (CommentListItem) o;
        return Objects.equals(this.id, commentListItem.id) && Objects.equals(this.content, commentListItem.content)
                && Objects.equals(this.createdBy, commentListItem.createdBy)
                && Objects.equals(this.createdOn, commentListItem.createdOn)
                && Objects.equals(this.currentUserReaction, commentListItem.currentUserReaction)
                && Objects.equals(this.numOfLikes, commentListItem.numOfLikes)
                && Objects.equals(this.numOfDisLikes, commentListItem.numOfDisLikes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, createdBy, createdOn, currentUserReaction, numOfLikes, numOfDisLikes);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CommentListItem {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    content: ").append(toIndentedString(content)).append("\n");
        sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
        sb.append("    createdOn: ").append(toIndentedString(createdOn)).append("\n");
        sb.append("    currentUserReaction: ").append(toIndentedString(currentUserReaction)).append("\n");
        sb.append("    numOfLikes: ").append(toIndentedString(numOfLikes)).append("\n");
        sb.append("    numOfDisLikes: ").append(toIndentedString(numOfDisLikes)).append("\n");
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

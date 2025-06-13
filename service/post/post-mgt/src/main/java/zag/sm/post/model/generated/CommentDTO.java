package zag.sm.post.model.generated;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.*;
import java.util.Objects;
import org.hibernate.validator.constraints.*;

/**
 * CommentDTO
 */
@lombok.Builder
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.6.0")
public class CommentDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String content;

    public CommentDTO content(String content) {
        this.content = content;
        return this;
    }

    /**
     * Get content
     *
     * @return content
     */
    @NotNull
    @Schema(name = "content", requiredMode = Schema.RequiredMode.REQUIRED)
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
        CommentDTO commentDTO = (CommentDTO) o;
        return Objects.equals(this.content, commentDTO.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CommentDTO {\n");
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

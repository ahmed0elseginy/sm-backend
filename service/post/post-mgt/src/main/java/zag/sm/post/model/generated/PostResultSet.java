package zag.sm.post.model.generated;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.hibernate.validator.constraints.*;

/**
 * PostResultSet
 */
@lombok.Builder
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.6.0")
public class PostResultSet implements Serializable {

    private static final long serialVersionUID = 1L;

    @Valid
    private List<@Valid PostListItem> data = new ArrayList<>();

    private Long total;

    public PostResultSet data(List<@Valid PostListItem> data) {
        this.data = data;
        return this;
    }

    public PostResultSet addDataItem(PostListItem dataItem) {
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
    public List<@Valid PostListItem> getData() {
        return data;
    }

    public void setData(List<@Valid PostListItem> data) {
        this.data = data;
    }

    public PostResultSet total(Long total) {
        this.total = total;
        return this;
    }

    /**
     * Total Number Of Posts
     *
     * @return total
     */

    @Schema(name = "total", description = "Total Number Of Posts", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
        PostResultSet postResultSet = (PostResultSet) o;
        return Objects.equals(this.data, postResultSet.data) && Objects.equals(this.total, postResultSet.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, total);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PostResultSet {\n");
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

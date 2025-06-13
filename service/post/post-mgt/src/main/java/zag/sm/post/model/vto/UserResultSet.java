package zag.sm.post.model.vto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import zag.sm.post.model.generated.LightUserVTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * UserResultSet
 */
@lombok.Builder
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.6.0")
public class UserResultSet implements Serializable {

    private static final long serialVersionUID = 1L;

    @Valid
    private List<@Valid LightUserVTO> data = new ArrayList<>();

    public UserResultSet data() {
        this.data = data;
        return this;
    }

    public UserResultSet addDataItem(LightUserVTO dataItem) {
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
    public List<@Valid LightUserVTO> getData() {
        return data;
    }

    public void setData(List<@Valid LightUserVTO> data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserResultSet userResultSet = (UserResultSet) o;
        return Objects.equals(this.data, userResultSet.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UserResultSet {\n");
        sb.append("    data: ").append(toIndentedString(data)).append("\n");
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

package zag.sm.user.model.generated;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.*;
import java.util.Objects;
import org.hibernate.validator.constraints.*;

/**
 * LookupVTO
 */
@lombok.Builder
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.6.0")
public class LookupVTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String titleEn;

    public LookupVTO id(Integer id) {
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
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LookupVTO titleEn(String titleEn) {
        this.titleEn = titleEn;
        return this;
    }

    /**
     * Get titleEn
     *
     * @return titleEn
     */

    @Schema(name = "titleEn", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("titleEn")
    public String getTitleEn() {
        return titleEn;
    }

    public void setTitleEn(String titleEn) {
        this.titleEn = titleEn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LookupVTO lookupVTO = (LookupVTO) o;
        return Objects.equals(this.id, lookupVTO.id) && Objects.equals(this.titleEn, lookupVTO.titleEn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titleEn);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class LookupVTO {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    titleEn: ").append(toIndentedString(titleEn)).append("\n");
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

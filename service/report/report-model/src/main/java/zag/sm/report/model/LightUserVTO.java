package zag.sm.report.model;


import java.io.Serializable;
import java.util.Objects;

/**
 * LightUserVTO
 */
@lombok.Builder
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor

public class LightUserVTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String fullName;

    public LightUserVTO id(Integer id) {
        this.id = id;
        return this;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LightUserVTO fullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LightUserVTO lightUserVTO = (LightUserVTO) o;
        return Objects.equals(this.id, lightUserVTO.id) && Objects.equals(this.fullName, lightUserVTO.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class LightUserVTO {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    fullName: ").append(toIndentedString(fullName)).append("\n");
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

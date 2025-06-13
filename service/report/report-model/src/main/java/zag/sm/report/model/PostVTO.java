package zag.sm.report.model;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * PostVTO
 */
@lombok.Builder
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor

public class PostVTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String title;

    private String content;

    private LightUserVTO createdBy;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdOn;

    public PostVTO id(Long id) {
        this.id = id;
        return this;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PostVTO title(String title) {
        this.title = title;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public PostVTO content(String content) {
        this.content = content;
        return this;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public PostVTO createdBy(LightUserVTO createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public LightUserVTO getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(LightUserVTO createdBy) {
        this.createdBy = createdBy;
    }

    public PostVTO createdOn(Date createdOn) {
        this.createdOn = createdOn;
        return this;
    }

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
        PostVTO postVTO = (PostVTO) o;
        return Objects.equals(this.id, postVTO.id) && Objects.equals(this.title, postVTO.title)
                && Objects.equals(this.content, postVTO.content) && Objects.equals(this.createdBy, postVTO.createdBy)
                && Objects.equals(this.createdOn, postVTO.createdOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, createdBy, createdOn);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PostVTO {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    title: ").append(toIndentedString(title)).append("\n");
        sb.append("    content: ").append(toIndentedString(content)).append("\n");
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

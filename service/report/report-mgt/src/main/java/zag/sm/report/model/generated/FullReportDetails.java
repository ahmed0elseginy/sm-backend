package zag.sm.report.model.generated;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * FullReportDetails
 */
@lombok.Builder
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.6.0")
public class FullReportDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    private ReportDetails reportDetails;

    private PostDetailsVTO post;

    @Valid
    private List<@Valid PostReportListItem> relatedReports = new ArrayList<>();

    public FullReportDetails reportDetails(ReportDetails reportDetails) {
        this.reportDetails = reportDetails;
        return this;
    }

    /**
     * Get reportDetails
     *
     * @return reportDetails
     */
    @Valid
    @Schema(name = "reportDetails", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("reportDetails")
    public ReportDetails getReportDetails() {
        return reportDetails;
    }

    public void setReportDetails(ReportDetails reportDetails) {
        this.reportDetails = reportDetails;
    }

    public FullReportDetails post(PostDetailsVTO post) {
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
    public PostDetailsVTO getPost() {
        return post;
    }

    public void setPost(PostDetailsVTO post) {
        this.post = post;
    }

    public FullReportDetails relatedReports(List<@Valid PostReportListItem> relatedReports) {
        this.relatedReports = relatedReports;
        return this;
    }

    public FullReportDetails addRelatedReportsItem(PostReportListItem relatedReportsItem) {
        if (this.relatedReports == null) {
            this.relatedReports = new ArrayList<>();
        }
        this.relatedReports.add(relatedReportsItem);
        return this;
    }

    /**
     * Get relatedReports
     *
     * @return relatedReports
     */
    @Valid
    @Schema(name = "relatedReports", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("relatedReports")
    public List<@Valid PostReportListItem> getRelatedReports() {
        return relatedReports;
    }

    public void setRelatedReports(List<@Valid PostReportListItem> relatedReports) {
        this.relatedReports = relatedReports;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FullReportDetails fullReportDetails = (FullReportDetails) o;
        return Objects.equals(this.reportDetails, fullReportDetails.reportDetails)
                && Objects.equals(this.post, fullReportDetails.post)
                && Objects.equals(this.relatedReports, fullReportDetails.relatedReports);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reportDetails, post, relatedReports);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FullReportDetails {\n");
        sb.append("    reportDetails: ").append(toIndentedString(reportDetails)).append("\n");
        sb.append("    post: ").append(toIndentedString(post)).append("\n");
        sb.append("    relatedReports: ").append(toIndentedString(relatedReports)).append("\n");
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

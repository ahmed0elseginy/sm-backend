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
 * ErrorVTO
 */
@lombok.Builder
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.6.0")
public class ErrorVTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String domain;

    private String code;

    private String message;

    @Valid
    private List<@Valid FormError> formErrors = new ArrayList<>();

    public ErrorVTO domain(String domain) {
        this.domain = domain;
        return this;
    }

    /**
     * Get domain
     *
     * @return domain
     */

    @Schema(name = "domain", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("domain")
    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public ErrorVTO code(String code) {
        this.code = code;
        return this;
    }

    /**
     * Get code
     *
     * @return code
     */

    @Schema(name = "code", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ErrorVTO message(String message) {
        this.message = message;
        return this;
    }

    /**
     * Get message
     *
     * @return message
     */

    @Schema(name = "message", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorVTO formErrors(List<@Valid FormError> formErrors) {
        this.formErrors = formErrors;
        return this;
    }

    public ErrorVTO addFormErrorsItem(FormError formErrorsItem) {
        if (this.formErrors == null) {
            this.formErrors = new ArrayList<>();
        }
        this.formErrors.add(formErrorsItem);
        return this;
    }

    /**
     * Get formErrors
     *
     * @return formErrors
     */
    @Valid
    @Schema(name = "formErrors", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("formErrors")
    public List<@Valid FormError> getFormErrors() {
        return formErrors;
    }

    public void setFormErrors(List<@Valid FormError> formErrors) {
        this.formErrors = formErrors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ErrorVTO errorVTO = (ErrorVTO) o;
        return Objects.equals(this.domain, errorVTO.domain) && Objects.equals(this.code, errorVTO.code)
                && Objects.equals(this.message, errorVTO.message)
                && Objects.equals(this.formErrors, errorVTO.formErrors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(domain, code, message, formErrors);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ErrorVTO {\n");
        sb.append("    domain: ").append(toIndentedString(domain)).append("\n");
        sb.append("    code: ").append(toIndentedString(code)).append("\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
        sb.append("    formErrors: ").append(toIndentedString(formErrors)).append("\n");
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

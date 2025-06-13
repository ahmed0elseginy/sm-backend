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
 * UserProfileVTO
 */
@lombok.Builder
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.6.0")
public class UserProfileVTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String firstName;

    private String lastName;

    private String mobileNumber;

    private String email;

    private String gender;

    public UserProfileVTO id(Long id) {
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

    public UserProfileVTO firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * Get firstName
     *
     * @return firstName
     */

    @Schema(name = "firstName", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public UserProfileVTO lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * Get lastName
     *
     * @return lastName
     */

    @Schema(name = "lastName", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UserProfileVTO mobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
        return this;
    }

    /**
     * Get mobileNumber
     *
     * @return mobileNumber
     */

    @Schema(name = "mobileNumber", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("mobileNumber")
    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public UserProfileVTO email(String email) {
        this.email = email;
        return this;
    }

    /**
     * Get email
     *
     * @return email
     */

    @Schema(name = "email", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserProfileVTO gender(String gender) {
        this.gender = gender;
        return this;
    }

    /**
     * Get gender
     *
     * @return gender
     */

    @Schema(name = "gender", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserProfileVTO userProfileVTO = (UserProfileVTO) o;
        return Objects.equals(this.id, userProfileVTO.id) && Objects.equals(this.firstName, userProfileVTO.firstName)
                && Objects.equals(this.lastName, userProfileVTO.lastName)
                && Objects.equals(this.mobileNumber, userProfileVTO.mobileNumber)
                && Objects.equals(this.email, userProfileVTO.email)
                && Objects.equals(this.gender, userProfileVTO.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, mobileNumber, email, gender);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UserProfileVTO {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
        sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
        sb.append("    mobileNumber: ").append(toIndentedString(mobileNumber)).append("\n");
        sb.append("    email: ").append(toIndentedString(email)).append("\n");
        sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
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

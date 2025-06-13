package zag.sm.user.model.generated;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.*;
import java.util.Objects;
import org.hibernate.validator.constraints.*;

/**
 * UserProfileDTO
 */
@lombok.Builder
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.6.0")
public class UserProfileDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String firstName;

    private String lastName;

    private String mobileNumber;

    private Genders gender;

    public UserProfileDTO firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * Get firstName
     *
     * @return firstName
     */
    @NotNull
    @Size(min = 2, max = 25)
    @Schema(name = "firstName", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public UserProfileDTO lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * Get lastName
     *
     * @return lastName
     */
    @NotNull
    @Size(min = 2, max = 25)
    @Schema(name = "lastName", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UserProfileDTO mobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
        return this;
    }

    /**
     * Get mobileNumber
     *
     * @return mobileNumber
     */
    @NotNull
    @Schema(name = "mobileNumber", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("mobileNumber")
    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public UserProfileDTO gender(Genders gender) {
        this.gender = gender;
        return this;
    }

    /**
     * Get gender
     *
     * @return gender
     */
    @NotNull
    @Valid
    @Schema(name = "gender", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("gender")
    public Genders getGender() {
        return gender;
    }

    public void setGender(Genders gender) {
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
        UserProfileDTO userProfileDTO = (UserProfileDTO) o;
        return Objects.equals(this.firstName, userProfileDTO.firstName)
                && Objects.equals(this.lastName, userProfileDTO.lastName)
                && Objects.equals(this.mobileNumber, userProfileDTO.mobileNumber)
                && Objects.equals(this.gender, userProfileDTO.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, mobileNumber, gender);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UserProfileDTO {\n");
        sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
        sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
        sb.append("    mobileNumber: ").append(toIndentedString(mobileNumber)).append("\n");
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

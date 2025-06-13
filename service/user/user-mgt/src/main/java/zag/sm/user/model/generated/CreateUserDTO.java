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
 * CreateUserDTO
 */
@lombok.Builder
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.6.0")
public class CreateUserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String firstName;

    private String lastName;

    private String mobileNumber;

    private String password;

    private String email;

    private Genders gender;

    public CreateUserDTO firstName(String firstName) {
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

    public CreateUserDTO lastName(String lastName) {
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

    public CreateUserDTO mobileNumber(String mobileNumber) {
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

    public CreateUserDTO password(String password) {
        this.password = password;
        return this;
    }

    /**
     * Get password
     *
     * @return password
     */
    @NotNull
    @Schema(name = "password", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CreateUserDTO email(String email) {
        this.email = email;
        return this;
    }

    /**
     * Get email
     *
     * @return email
     */
    @NotNull
    @jakarta.validation.constraints.Email
    @Schema(name = "email", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CreateUserDTO gender(Genders gender) {
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
        CreateUserDTO createUserDTO = (CreateUserDTO) o;
        return Objects.equals(this.firstName, createUserDTO.firstName)
                && Objects.equals(this.lastName, createUserDTO.lastName)
                && Objects.equals(this.mobileNumber, createUserDTO.mobileNumber)
                && Objects.equals(this.password, createUserDTO.password)
                && Objects.equals(this.email, createUserDTO.email) && Objects.equals(this.gender, createUserDTO.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, mobileNumber, password, email, gender);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CreateUserDTO {\n");
        sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
        sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
        sb.append("    mobileNumber: ").append(toIndentedString(mobileNumber)).append("\n");
        sb.append("    password: ").append(toIndentedString(password)).append("\n");
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

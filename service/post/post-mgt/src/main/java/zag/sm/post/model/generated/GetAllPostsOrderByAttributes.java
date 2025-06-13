package zag.sm.post.model.generated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.*;
import java.util.*;
import org.hibernate.validator.constraints.*;

/**
 * Gets or Sets GetAllPostsOrderByAttributes
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.6.0")
public enum GetAllPostsOrderByAttributes {

    TITLE("TITLE"),

    POST_OWNER("POST_OWNER"),

    CREATION_DATE("CREATION_DATE");

    private String value;

    GetAllPostsOrderByAttributes(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static GetAllPostsOrderByAttributes fromValue(String value) {
        for (GetAllPostsOrderByAttributes b : GetAllPostsOrderByAttributes.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}

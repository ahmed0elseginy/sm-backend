package zag.sm.post.model.generated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.annotation.Generated;
import jakarta.validation.constraints.*;
import java.util.*;
import org.hibernate.validator.constraints.*;

/**
 * Gets or Sets CommentReactions
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.6.0")
public enum CommentReactions {

    LIKE("LIKE"),

    DIS_LIKE("DIS_LIKE");

    private String value;

    CommentReactions(String value) {
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
    public static CommentReactions fromValue(String value) {
        for (CommentReactions b : CommentReactions.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}

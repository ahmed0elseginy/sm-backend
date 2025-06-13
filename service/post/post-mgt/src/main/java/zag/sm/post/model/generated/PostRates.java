package zag.sm.post.model.generated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.annotation.Generated;

/**
 * Gets or Sets PostRates
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.6.0")
public enum PostRates {

    NUMBER_1(1),

    NUMBER_2(2),

    NUMBER_3(3),

    NUMBER_4(4),

    NUMBER_5(5);

    private Integer value;

    PostRates(Integer value) {
        this.value = value;
    }

    @JsonValue
    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static PostRates fromValue(Integer value) {
        for (PostRates b : PostRates.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}

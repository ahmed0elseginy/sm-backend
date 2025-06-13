package zag.sm.report.model.generated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.annotation.Generated;

/**
 * Gets or Sets OrderByAttributes
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.6.0")
public enum OrderByAttributes {

    REPORT_CATEGORY("REPORT_CATEGORY"),

    REPORT_STATUS("REPORT_STATUS"),

    CREATION_DATE("CREATION_DATE");

    private String value;

    OrderByAttributes(String value) {
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
    public static OrderByAttributes fromValue(String value) {
        for (OrderByAttributes b : OrderByAttributes.values()) {
            if (b.value.equals(value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}

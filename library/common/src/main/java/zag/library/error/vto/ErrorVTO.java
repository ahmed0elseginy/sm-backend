package zag.library.error.vto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import zag.library.error.interfaces.Errors;

import java.text.MessageFormat;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorVTO {
    private String code;
    private String domain;
    private String message;
    private List<FormError> formErrors;

    public static ErrorVTO of(Errors<?, ?> error) {
        return ErrorVTO.builder().code(error.code()).domain(error.domain().name()).message(error.defaultMessage()).build();
    }

    public static ErrorVTO of(Errors<?, ?> error, Object[] args) {
        return ErrorVTO.builder().code(error.code()).domain(error.domain().name())
                .message(MessageFormat.format(error.defaultMessage(), args)).build();
    }
}

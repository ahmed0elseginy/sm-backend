package zag.library.error.exception;

import lombok.Getter;
import zag.library.error.interfaces.Errors;

@Getter
public class InternalServerException extends AppException {

    public InternalServerException(Errors<?, ?> error) {
        super(error);
    }

    public InternalServerException(Errors<?, ?> error, Object... args) {
        super(error, args);
    }
}

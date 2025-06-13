package zag.library.error.exception;

import lombok.Getter;
import zag.library.error.interfaces.Errors;

@Getter
public class BusinessException extends AppException {

    public BusinessException(Errors<?, ?> error) {
        super(error);
    }

    public BusinessException(Errors<?, ?> error, Object... args) {
        super(error, args);
    }
}

package zag.library.security.api.model.exception;

import lombok.Getter;
import zag.library.error.exception.AppException;
import zag.library.error.interfaces.Errors;

@Getter
public class AuthenticationException extends AppException {

    public AuthenticationException(Errors<?, ?> error) {
        super(error);
    }

    public AuthenticationException(Errors<?, ?> error, Object... args) {
        super(error, args);
    }
}

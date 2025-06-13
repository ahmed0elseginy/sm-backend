package zag.library.security.api.model.exception;

import lombok.Getter;
import zag.library.error.exception.AppException;
import zag.library.error.interfaces.Errors;

@Getter
public class AuthorizationException extends AppException {

    public AuthorizationException(Errors<?, ?> error) {
        super(error);
    }

    public AuthorizationException(Errors<?, ?> error, Object... args) {
        super(error, args);
    }
}

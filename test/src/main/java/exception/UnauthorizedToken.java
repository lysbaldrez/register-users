package exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnauthorizedToken extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public UnauthorizedToken(String message) {
        super(message);
    }
}

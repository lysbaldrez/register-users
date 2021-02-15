package com.concrete.api.test.exceptionHandler;

import com.concrete.api.test.exception.UnauthorizedToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UnauthorizedToken.class)
    public ResponseEntity<ApiError> handleNegocio(UnauthorizedToken ex, WebRequest request)
    {
        HttpStatus status = HttpStatus.UNAUTHORIZED;
        ApiError apiError = new ApiError(status, ex.getMessage());

        return new ResponseEntity<ApiError>(apiError, HttpStatus.UNAUTHORIZED);
    }

}

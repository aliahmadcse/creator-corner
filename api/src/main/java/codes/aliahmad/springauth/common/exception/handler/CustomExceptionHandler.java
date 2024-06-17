package codes.aliahmad.springauth.common.exception.handler;

import codes.aliahmad.springauth.common.exception.BusinessError;
import codes.aliahmad.springauth.common.exception.BusinessException;
import codes.aliahmad.springauth.common.exception.ErrorType;
import codes.aliahmad.springauth.common.exception.ExceptionType;
import codes.aliahmad.springauth.common.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class CustomExceptionHandler
{
  @ExceptionHandler(BusinessException.class)
  public ResponseEntity<ErrorResponse> handleBusinessException(BusinessException ex)
  {
    ErrorResponse response = new ErrorResponse(ex.getMessage(), ex.getExceptionType().getStatus().value());
    return new ResponseEntity<>(response, ex.getExceptionType().getStatus());
  }

  @ExceptionHandler(AuthenticationException.class)
  public ResponseEntity<ErrorResponse> handleAuthenticationException(AuthenticationException ex)
  {
    ErrorResponse response = new ErrorResponse("Authentication failed", HttpStatus.UNAUTHORIZED.value());
    return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
  }

  @ExceptionHandler(BusinessError.class)
  public ResponseEntity<ErrorResponse> handleBusinessError(BusinessError error)
  {
    ErrorResponse response = new ErrorResponse(error.getMessage(), error.getErrorType().getStatus().value());
    return new ResponseEntity<>(response, error.getErrorType().getStatus());
  }

  @ExceptionHandler(AccessDeniedException.class)
  public ResponseEntity<ErrorResponse> handleAccessDenied(AccessDeniedException error)
  {
    ErrorResponse response = new ErrorResponse(ExceptionType.ACCESS_DENIED.getMessage(),
            ExceptionType.ACCESS_DENIED.getStatus().value());
    return new ResponseEntity<>(response, ExceptionType.ACCESS_DENIED.getStatus());
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public final ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request) {
    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult().getAllErrors().forEach((error) -> {
      String fieldName = ((FieldError) error).getField();
      String errorMessage = error.getDefaultMessage();
      errors.put(fieldName, errorMessage);
    });

    return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponse> handleBusinessError(Exception error)
  {
    log.error(error.getMessage(), error);
    ErrorResponse response = new ErrorResponse(ErrorType.INTERNAL_SERVER_ERROR.getMessage(), ErrorType.
            INTERNAL_SERVER_ERROR.getStatus().value());
    return new ResponseEntity<>(response, ErrorType.INTERNAL_SERVER_ERROR.getStatus());
  }

}

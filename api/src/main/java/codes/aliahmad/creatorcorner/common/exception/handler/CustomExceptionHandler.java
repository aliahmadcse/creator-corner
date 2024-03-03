package codes.aliahmad.creatorcorner.common.exception.handler;

import codes.aliahmad.creatorcorner.common.exception.BusinessError;
import codes.aliahmad.creatorcorner.common.exception.BusinessException;
import codes.aliahmad.creatorcorner.common.exception.ErrorType;
import codes.aliahmad.creatorcorner.common.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

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

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponse> handleBusinessError(Exception error)
  {
    log.error(error.getMessage(), error);
    ErrorResponse response = new ErrorResponse(ErrorType.INTERNAL_SERVER_ERROR.getMessage(), ErrorType.
            INTERNAL_SERVER_ERROR.getStatus().value());
    return new ResponseEntity<>(response, ErrorType.INTERNAL_SERVER_ERROR.getStatus());
  }

}

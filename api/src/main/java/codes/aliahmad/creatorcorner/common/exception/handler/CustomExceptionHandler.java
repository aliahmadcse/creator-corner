package codes.aliahmad.creatorcorner.common.exception.handler;

import codes.aliahmad.creatorcorner.common.exception.BusinessError;
import codes.aliahmad.creatorcorner.common.exception.BusinessException;
import codes.aliahmad.creatorcorner.common.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
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
}

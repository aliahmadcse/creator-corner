package codes.aliahmad.springauth.common.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException
{
  private final ExceptionType exceptionType;

  public BusinessException(ExceptionType exception)
  {
    super(exception.getMessage());
    this.exceptionType = exception;
  }
}

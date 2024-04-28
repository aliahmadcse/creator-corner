package codes.aliahmad.springauth.common.exception;


import lombok.Getter;

@Getter
public class BusinessError extends RuntimeException
{
  private final ErrorType errorType;

  public BusinessError(ErrorType error)
  {
    super(error.getMessage());
    this.errorType = error;
  }

}

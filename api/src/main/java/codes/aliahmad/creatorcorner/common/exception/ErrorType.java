package codes.aliahmad.creatorcorner.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorType
{
  INTERNAL_SERVER_ERROR("Something went wrong, Please try again", HttpStatus.INTERNAL_SERVER_ERROR);

  private final String message;
  private final HttpStatus status;
}

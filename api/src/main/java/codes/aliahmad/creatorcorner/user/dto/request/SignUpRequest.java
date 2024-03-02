package codes.aliahmad.creatorcorner.user.dto.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequest
{
  private String email;
  private char[] password;
}

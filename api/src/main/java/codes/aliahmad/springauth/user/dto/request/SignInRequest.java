package codes.aliahmad.springauth.user.dto.request;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignInRequest
{
  @NotBlank(message = "Email can't be empty")
  private String email;
  @NotBlank(message = "Password can't be empty")
  private String password;
}

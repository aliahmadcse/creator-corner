package codes.aliahmad.creatorcorner.user.service.impl;

import codes.aliahmad.creatorcorner.common.exception.BusinessException;
import codes.aliahmad.creatorcorner.common.exception.ExceptionType;
import codes.aliahmad.creatorcorner.user.dto.request.SignUpRequest;
import codes.aliahmad.creatorcorner.user.dto.response.JwtResponse;
import codes.aliahmad.creatorcorner.user.entity.Role;
import codes.aliahmad.creatorcorner.user.entity.User;
import codes.aliahmad.creatorcorner.user.model.ERole;
import codes.aliahmad.creatorcorner.user.service.AuthService;
import codes.aliahmad.creatorcorner.user.service.RoleService;
import codes.aliahmad.creatorcorner.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService
{
  private final UserService userService;
  private final RoleService roleService;
  private final PasswordEncoder encoder;

  @Override
  public JwtResponse registerUser(SignUpRequest signUpRequest)
  {
    if (userService.existByEmail(signUpRequest.getEmail()))
    {
      throw new BusinessException(ExceptionType.USER_ALREADY_EXISTS);
    }

    Role role = roleService.findByName(ERole.USER);

    // Create new user's account
    User userToSave = User.builder().email(signUpRequest.getEmail())
            .password(encoder.encode(Arrays.toString(signUpRequest.getPassword())))
            .role(role)
            .build();

    User _ = userService.save(userToSave);

    return authenticateUser(signUpRequest.getEmail(), signUpRequest.getPassword());
  }

  public JwtResponse authenticateUser(String email, char[] password)
  {
    return null;
  }
}

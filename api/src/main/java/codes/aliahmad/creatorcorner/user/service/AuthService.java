package codes.aliahmad.creatorcorner.user.service;

import codes.aliahmad.creatorcorner.user.dto.request.SignInRequest;
import codes.aliahmad.creatorcorner.user.dto.request.SignUpRequest;
import codes.aliahmad.creatorcorner.user.dto.response.JwtResponse;

public interface AuthService
{
  JwtResponse registerUser(SignUpRequest signUpRequest);

  JwtResponse authenticateUser(SignInRequest signInRequest);

}

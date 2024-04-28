package codes.aliahmad.springauth.user.service;

import codes.aliahmad.springauth.user.dto.request.SignInRequest;
import codes.aliahmad.springauth.user.dto.request.SignUpRequest;
import codes.aliahmad.springauth.user.dto.response.JwtResponse;

public interface AuthService
{
  JwtResponse registerUser(SignUpRequest signUpRequest);

  JwtResponse authenticateUser(SignInRequest signInRequest);

  void logout(String token);

  JwtResponse refreshAuth(String email);
}

package codes.aliahmad.creatorcorner.user.resource;


import codes.aliahmad.creatorcorner.user.dto.request.SignInRequest;
import codes.aliahmad.creatorcorner.user.dto.request.SignUpRequest;
import codes.aliahmad.creatorcorner.user.dto.response.JwtResponse;
import codes.aliahmad.creatorcorner.user.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthResource
{

  private final AuthService authService;


  @PostMapping("/signin")
  public ResponseEntity<JwtResponse> authenticateUser(@Valid @RequestBody SignInRequest signInRequest)
  {
    return ResponseEntity.ok(authService.authenticateUser(signInRequest));
  }

  @PostMapping("/signup")
  public ResponseEntity<JwtResponse> registerUser(@Valid @RequestBody SignUpRequest signUpRequest)
  {
    return new ResponseEntity<>(authService.registerUser(signUpRequest), HttpStatus.OK);
  }

//  @GetMapping("/refresh")
//  public ResponseEntity<JwtResponse> refreshAuth(@RequestParam("token") String token)
//  {
//    return new ResponseEntity<>(authService.refreshAuth(token), HttpStatus.OK);
//  }

}

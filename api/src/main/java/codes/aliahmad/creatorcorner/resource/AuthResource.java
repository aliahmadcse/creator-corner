package codes.aliahmad.creatorcorner.resource;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthResource
{

  private final AuthService authService;


//  @PostMapping("/signin")
//  public ResponseEntity<JwtResponse> authenticateUser(@Valid @RequestBody SignInRequest signInRequest)
//  {
//    return ResponseEntity.ok(authService.authenticateUser(signInRequest));
//  }


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

package codes.aliahmad.springauth.user.resource;


import codes.aliahmad.springauth.user.entity.User;
import codes.aliahmad.springauth.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserResource
{

  private final UserService userService;

  @GetMapping("/{id}")
  public ResponseEntity<User> getUser(@Valid @PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails)
  {
    return new ResponseEntity<>(userService.findById(id, userDetails.getUsername()), HttpStatus.OK);
  }

  @GetMapping("/email/{email}")
  public ResponseEntity<User> getUserByEmail(@Valid @PathVariable String email, @AuthenticationPrincipal UserDetails userDetails)
  {
    return new ResponseEntity<>(userService.findByEmail(email, userDetails.getUsername()), HttpStatus.OK);
  }

  @PutMapping
  public ResponseEntity<User> updateUser(@Valid @RequestBody User user)
  {
    return new ResponseEntity<>(userService.updateUser(user), HttpStatus.CREATED);
  }

  @GetMapping
  @PreAuthorize("hasAuthority('ADMIN')")
  public String getHello()
  {
    return "Hello World!";
  }

}

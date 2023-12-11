package codes.aliahmad.creatorcorner.resource;


import codes.aliahmad.creatorcorner.entity.User;
import codes.aliahmad.creatorcorner.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserResource
{

  private final UserService userService;

  @GetMapping("/{id}")
  public ResponseEntity<User> getUser(@Valid @PathVariable Long id)
  {
    return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
  }

  @PutMapping
  public ResponseEntity<User> updateUser(@Valid @RequestBody User user)
  {
    return new ResponseEntity<>(userService.updateUser(user), HttpStatus.CREATED);
  }
}

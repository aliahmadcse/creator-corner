package codes.aliahmad.springauth.user.security.service;

import codes.aliahmad.springauth.user.entity.User;
import codes.aliahmad.springauth.user.security.model.UserDetailsModel;
import codes.aliahmad.springauth.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService
{
  private final UserService userService;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
  {
    User user = userService.findByEmail(email);

    return UserDetailsModel.build(user);
  }
}

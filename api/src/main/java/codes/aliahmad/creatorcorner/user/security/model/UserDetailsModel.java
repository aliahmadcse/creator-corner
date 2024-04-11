package codes.aliahmad.creatorcorner.user.security.model;

import codes.aliahmad.creatorcorner.user.entity.User;
import codes.aliahmad.creatorcorner.user.model.ERole;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@RequiredArgsConstructor
public class UserDetailsModel implements UserDetails
{
  private final String email;
  private final String password;
  private final Collection<? extends GrantedAuthority> authorities;

  public static UserDetailsModel build(User user)
  {
    List<GrantedAuthority> authorities = Stream.of(user.getRole())
            .map(role -> new SimpleGrantedAuthority(role.getName().getValue()))
            .collect(Collectors.toList());

    return new UserDetailsModel(user.getEmail(), user.getPassword(), authorities);
  }

  public static UserDetailsModel build(ERole role, String email)
  {
    List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(role.getValue()));

    return new UserDetailsModel(email, null, authorities);
  }


  @Override
  public Collection<? extends GrantedAuthority> getAuthorities()
  {
    return authorities;
  }

  @Override
  public String getPassword()
  {
    return password;
  }

  @Override
  public String getUsername()
  {
    return email;
  }

  @Override
  public boolean isAccountNonExpired()
  {
    return true;
  }

  @Override
  public boolean isAccountNonLocked()
  {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired()
  {
    return true;
  }

  @Override
  public boolean isEnabled()
  {
    return true;
  }

  @Override
  public boolean equals(Object o)
  {
    if (this == o)
    {
      return true;
    }
    if (o == null || getClass() != o.getClass())
    {
      return false;
    }
    UserDetailsModel user = (UserDetailsModel) o;
    return Objects.equals(email, user.email);
  }
}

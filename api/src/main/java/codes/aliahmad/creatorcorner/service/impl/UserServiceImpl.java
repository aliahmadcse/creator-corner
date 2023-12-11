package codes.aliahmad.creatorcorner.service.impl;

import codes.aliahmad.creatorcorner.entity.User;
import codes.aliahmad.creatorcorner.repository.UserRepository;
import codes.aliahmad.creatorcorner.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService
{
  private final UserRepository userRepository;

  @Override
  public User updateUser(User user)
  {
    return userRepository.save(user);
  }

  @Override
  public User findById(Long id)
  {
//    TODO: exception handling
    return userRepository.findById(id).get();
  }
}

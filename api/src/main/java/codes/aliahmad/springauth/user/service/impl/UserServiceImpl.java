package codes.aliahmad.springauth.user.service.impl;

import codes.aliahmad.springauth.common.exception.BusinessException;
import codes.aliahmad.springauth.common.exception.ExceptionType;
import codes.aliahmad.springauth.user.entity.User;
import codes.aliahmad.springauth.user.repository.UserRepository;
import codes.aliahmad.springauth.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService
{
  private final UserRepository userRepository;

  @Override
  public User updateUser(User user)
  {
    return userRepository.save(user);
  }

  @Override
  public User findById(Long id, String authenticatedUserEmail)
  {
    User authenticatedUser = userRepository.findByEmail(authenticatedUserEmail)
            .orElseThrow(() -> new BusinessException(ExceptionType.USER_NOT_FOUND));
    if (!authenticatedUser.getId().equals(id)) {
      throw new BusinessException(ExceptionType.ACCESS_DENIED);
    }

    return userRepository.findById(id)
            .orElseThrow(() -> new BusinessException(ExceptionType.USER_NOT_FOUND));
  }

  @Override
  public User findByEmail(String email, String authenticatedUserEmail)
  {
    if (!authenticatedUserEmail.equals(email)) {
      throw new BusinessException(ExceptionType.ACCESS_DENIED);
    }

    return userRepository.findByEmail(email)
            .orElseThrow(() -> new BusinessException(ExceptionType.USER_NOT_FOUND));
  }

  @Override
  public boolean existByEmail(String email)
  {
    return userRepository.existsByEmail(email);
  }

  @Override
  public User save(User user)
  {
    return userRepository.save(user);
  }

  @Override
  public User findByEmail(String email)
  {
    return userRepository.findByEmail(email)
            .orElseThrow(() -> new BusinessException(ExceptionType.USER_NOT_FOUND));
  }


}

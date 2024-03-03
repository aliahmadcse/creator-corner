package codes.aliahmad.creatorcorner.user.service.impl;

import codes.aliahmad.creatorcorner.common.exception.BusinessError;
import codes.aliahmad.creatorcorner.common.exception.BusinessException;
import codes.aliahmad.creatorcorner.common.exception.ErrorType;
import codes.aliahmad.creatorcorner.common.exception.ExceptionType;
import codes.aliahmad.creatorcorner.user.entity.User;
import codes.aliahmad.creatorcorner.user.repository.UserRepository;
import codes.aliahmad.creatorcorner.user.service.UserService;
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
    try
    {
      return userRepository.save(user);
    }
    catch (Exception e)
    {
      log.error(e.getMessage(), e);
      throw new BusinessError(ErrorType.INTERNAL_SERVER_ERROR);
    }
  }

  @Override
  public User findById(Long id)
  {
    try
    {
      return userRepository.findById(id)
              .orElseThrow(() -> new BusinessException(ExceptionType.USER_NOT_FOUND));
    }
    catch (Exception e)
    {
      log.error(e.getMessage(), e);
      throw new BusinessError(ErrorType.INTERNAL_SERVER_ERROR);
    }
  }

  @Override
  public boolean existByEmail(String email)
  {
    try
    {
      return userRepository.existsByEmail(email);
    }
    catch (Exception e)
    {
      log.error(e.getMessage(), e);
      throw new BusinessError(ErrorType.INTERNAL_SERVER_ERROR);
    }
  }

  @Override
  public User save(User user)
  {
    try
    {
      return userRepository.save(user);
    }
    catch (Exception e)
    {
      log.error(e.getMessage(), e);
      throw new BusinessError(ErrorType.INTERNAL_SERVER_ERROR);
    }
  }

  @Override
  public User findByEmail(String email)
  {
    try
    {
      return userRepository.findByEmail(email)
              .orElseThrow(() -> new BusinessException(ExceptionType.USER_NOT_FOUND));
    }
    catch (Exception e)
    {
      log.error(e.getMessage(), e);
      throw new BusinessError(ErrorType.INTERNAL_SERVER_ERROR);
    }
  }


}

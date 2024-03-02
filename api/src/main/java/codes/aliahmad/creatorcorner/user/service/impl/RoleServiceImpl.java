package codes.aliahmad.creatorcorner.user.service.impl;

import codes.aliahmad.creatorcorner.common.exception.BusinessError;
import codes.aliahmad.creatorcorner.common.exception.BusinessException;
import codes.aliahmad.creatorcorner.common.exception.ErrorType;
import codes.aliahmad.creatorcorner.common.exception.ExceptionType;
import codes.aliahmad.creatorcorner.user.entity.Role;
import codes.aliahmad.creatorcorner.user.model.ERole;
import codes.aliahmad.creatorcorner.user.repository.RoleRepository;
import codes.aliahmad.creatorcorner.user.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleServiceImpl implements RoleService
{
  private final RoleRepository roleRepository;

  @Override
  public Role findByName(ERole name)
  {
    try
    {
      return roleRepository.findByName(name)
              .orElseThrow(() -> new BusinessException(ExceptionType.ROLE_NOT_FOUND));
    }
    catch (Exception e)
    {
      log.error(e.getMessage(), e);
      throw new BusinessError(ErrorType.INTERNAL_SERVER_ERROR);
    }

  }
}

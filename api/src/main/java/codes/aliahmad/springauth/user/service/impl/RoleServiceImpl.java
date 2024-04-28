package codes.aliahmad.springauth.user.service.impl;

import codes.aliahmad.springauth.common.exception.BusinessException;
import codes.aliahmad.springauth.common.exception.ExceptionType;
import codes.aliahmad.springauth.user.entity.Role;
import codes.aliahmad.springauth.user.model.ERole;
import codes.aliahmad.springauth.user.repository.RoleRepository;
import codes.aliahmad.springauth.user.service.RoleService;
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
    return roleRepository.findByName(name)
            .orElseThrow(() -> new BusinessException(ExceptionType.ROLE_NOT_FOUND));

  }
}

package codes.aliahmad.springauth.user.service;

import codes.aliahmad.springauth.user.entity.Role;
import codes.aliahmad.springauth.user.model.ERole;

public interface RoleService
{
  Role findByName(ERole name);
}

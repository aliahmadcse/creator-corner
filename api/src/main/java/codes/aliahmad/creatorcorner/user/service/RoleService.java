package codes.aliahmad.creatorcorner.user.service;

import codes.aliahmad.creatorcorner.user.entity.Role;
import codes.aliahmad.creatorcorner.user.model.ERole;

public interface RoleService
{
  Role findByName(ERole name);
}

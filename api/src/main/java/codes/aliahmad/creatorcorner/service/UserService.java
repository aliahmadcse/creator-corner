package codes.aliahmad.creatorcorner.service;

import codes.aliahmad.creatorcorner.entity.User;

public interface UserService
{
  User updateUser(User user);

  User findById(Long id);
}

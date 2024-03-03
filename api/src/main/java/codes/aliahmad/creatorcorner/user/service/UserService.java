package codes.aliahmad.creatorcorner.user.service;

import codes.aliahmad.creatorcorner.user.entity.User;

public interface UserService
{
  User updateUser(User user);

  User findById(Long id);

  boolean existByEmail(String email);
  User save(User user);

  User findByEmail(String email);
}

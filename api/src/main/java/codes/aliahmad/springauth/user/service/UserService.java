package codes.aliahmad.springauth.user.service;

import codes.aliahmad.springauth.user.entity.User;

public interface UserService
{
  User updateUser(User user);

  User findById(Long id);

  boolean existByEmail(String email);

  User save(User user);

  User findByEmail(String email);
}

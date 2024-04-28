package codes.aliahmad.springauth.user.service;

import codes.aliahmad.springauth.user.entity.Session;


public interface SessionService
{
  void saveSession(Session session);

  Session getSession(String email);
}

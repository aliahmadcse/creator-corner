package codes.aliahmad.creatorcorner.user.service;

import codes.aliahmad.creatorcorner.user.entity.Session;


public interface SessionService
{
  void saveSession(Session session);

  Session getSession(String email);
}

package codes.aliahmad.creatorcorner.user.service.impl;

import codes.aliahmad.creatorcorner.user.entity.Session;
import codes.aliahmad.creatorcorner.user.repository.SessionRepository;
import codes.aliahmad.creatorcorner.user.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class SessionServiceImpl implements SessionService
{
  private final SessionRepository sessionRepository;

  @Override
  public void saveSession(Session session)
  {
    sessionRepository.save(session);
  }

  @Override
  public Session getSession(String email)
  {
    return sessionRepository.findById(email).orElse(null);
  }
}

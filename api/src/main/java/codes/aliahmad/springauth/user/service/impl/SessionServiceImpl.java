package codes.aliahmad.springauth.user.service.impl;

import codes.aliahmad.springauth.user.entity.Session;
import codes.aliahmad.springauth.user.repository.SessionRepository;
import codes.aliahmad.springauth.user.service.SessionService;
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
    if (email == null)
    {
      return null;
    }
    return sessionRepository.findById(email).orElse(null);
  }
}

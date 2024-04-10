package codes.aliahmad.creatorcorner.user.security.middleware;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;

/**
 * @author - Ali Ahmad
 * <p>
 * This class handles unathurized requests
 * </p>
 */
@Component
@Slf4j
public class AuthEntryPoint implements AuthenticationEntryPoint
{
  private final HandlerExceptionResolver resolver;

  public AuthEntryPoint(@Qualifier("handlerExceptionResolver") HandlerExceptionResolver resolver)
  {
    this.resolver = resolver;
  }

  @Override
  public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
  {
    log.error("Unauthorized error: {}", authException.getMessage());
    resolver.resolveException(request, response, null, authException);
  }
}

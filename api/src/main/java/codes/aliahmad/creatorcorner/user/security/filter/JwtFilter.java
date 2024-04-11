package codes.aliahmad.creatorcorner.user.security.filter;

import codes.aliahmad.creatorcorner.user.entity.Session;
import codes.aliahmad.creatorcorner.user.security.model.UserDetailsModel;
import codes.aliahmad.creatorcorner.user.security.util.JwtUtil;
import codes.aliahmad.creatorcorner.user.service.SessionService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Objects;


@Component
@RequiredArgsConstructor
@Slf4j
public class JwtFilter extends OncePerRequestFilter
{
  private final SessionService sessionService;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
          throws ServletException, IOException
  {
    try
    {
      Session session = sessionService.getSession(extractJwt(request));
      if (Objects.nonNull(session) && session.active() && session.validBefore().isAfter(LocalDateTime.now()))
      {
        UserDetails userDetails = UserDetailsModel.build(session.role(), session.email());

        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities());

        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);
      }
    }
    catch (Exception e)
    {
      log.error("Cannot set user authentication: {}", e.getMessage());
    }

    filterChain.doFilter(request, response);
  }

  private String extractJwt(HttpServletRequest request)
  {
    String headerAuth = request.getHeader("Authorization");

    if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer "))
    {
      return JwtUtil.extractToken(headerAuth);
    }

    return null;
  }
}

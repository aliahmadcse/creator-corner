package codes.aliahmad.creatorcorner.user.security.helper;

import codes.aliahmad.creatorcorner.user.security.model.UserDetailsModel;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
@Slf4j
public class JwtHelper
{
  @Value("${app.jwt.secret}")
  private String jwtSecret;

  @Value("${app.jwt.expiration-sec}")
  private int JWT_EXPIRATION_SEC;

  public String generateJwtToken(Authentication authentication)
  {
    UserDetailsModel userPrincipal = (UserDetailsModel) authentication.getPrincipal();
    return generateJwt(userPrincipal.getUsername());
  }

  public String generateJwtFromUsername(String username)
  {
    return generateJwt(username);
  }

  private String generateJwt(String username)
  {
    return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + (JWT_EXPIRATION_SEC * 1000L)))
            .signWith(key(), SignatureAlgorithm.HS256)
            .compact();
  }

  private Key key()
  {
    return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
  }

  public String getUserNameFromJwtToken(String token)
  {
    return Jwts.parserBuilder().setSigningKey(key()).build()
            .parseClaimsJws(token).getBody().getSubject();
  }

  public String getUserNameFromExpiredJwt(String token)
  {
    try
    {
      return Jwts.parserBuilder().setSigningKey(key()).build()
              .parseClaimsJws(token).getBody().getSubject();
    }
    catch (ExpiredJwtException e)
    {
      return e.getClaims().getSubject();
    }
  }

  public boolean validateJwtTokenForRefresh(String token)
  {
    try
    {
      Jwts.parserBuilder().setSigningKey(key()).build().parse(token);
      return true;
    }
    catch (ExpiredJwtException e)
    {
      log.error("JWT token is expired: {}", e.getMessage());
      return true;
    }
    catch (Exception e)
    {
      return false;
    }
  }

  public boolean validateJwtToken(String authToken)
  {
    try
    {
      Jwts.parserBuilder().setSigningKey(key()).build().parse(authToken);
      return true;
    }
    catch (MalformedJwtException e)
    {
      log.error("Invalid JWT token: {}", e.getMessage());
    }
    catch (ExpiredJwtException e)
    {
      log.error("JWT token is expired: {}", e.getMessage());
    }
    catch (UnsupportedJwtException e)
    {
      log.error("JWT token is unsupported: {}", e.getMessage());
    }
    catch (IllegalArgumentException e)
    {
      log.error("JWT claims string is empty: {}", e.getMessage());
    }

    return false;
  }
}

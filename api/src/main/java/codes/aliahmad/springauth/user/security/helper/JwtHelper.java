package codes.aliahmad.springauth.user.security.helper;

import codes.aliahmad.springauth.user.security.model.UserDetailsModel;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
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

  public String generateJwtToken(String username)
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

}

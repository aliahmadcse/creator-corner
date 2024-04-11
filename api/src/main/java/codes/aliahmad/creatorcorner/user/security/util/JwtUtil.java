package codes.aliahmad.creatorcorner.user.security.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class JwtUtil
{
  public static String extractToken(String token)
  {
    return token.substring(7);
  }

}

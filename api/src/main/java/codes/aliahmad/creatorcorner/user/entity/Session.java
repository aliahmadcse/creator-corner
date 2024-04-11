package codes.aliahmad.creatorcorner.user.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;

@RedisHash
public record Session(@Id String email, String token, LocalDateTime validBefore)
{
}

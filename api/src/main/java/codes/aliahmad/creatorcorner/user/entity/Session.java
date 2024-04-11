package codes.aliahmad.creatorcorner.user.entity;

import codes.aliahmad.creatorcorner.user.model.ERole;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;

@RedisHash
public record Session(@Id String token, String email, LocalDateTime validBefore, boolean active, ERole role)
{
}

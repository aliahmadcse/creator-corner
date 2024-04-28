package codes.aliahmad.springauth.user.entity;

import codes.aliahmad.springauth.user.model.ERole;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;

@RedisHash
public record Session(@Id String token, String email, LocalDateTime validBefore, boolean active, ERole role)
{
}

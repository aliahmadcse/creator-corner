package codes.aliahmad.creatorcorner.user.repository;

import codes.aliahmad.creatorcorner.user.entity.Role;
import codes.aliahmad.creatorcorner.user.model.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>
{
  Optional<Role> findByName(ERole roleName);
}

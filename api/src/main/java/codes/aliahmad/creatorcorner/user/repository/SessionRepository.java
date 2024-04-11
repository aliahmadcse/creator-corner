package codes.aliahmad.creatorcorner.user.repository;


import codes.aliahmad.creatorcorner.user.entity.Session;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends CrudRepository<Session, String>
{
}

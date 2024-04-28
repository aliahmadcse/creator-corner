package codes.aliahmad.springauth.user.repository;


import codes.aliahmad.springauth.user.entity.Session;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends CrudRepository<Session, String>
{
}

package philip.wersonig.backend.tribalages.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import philip.wersonig.backend.tribalages.model.Event;
import philip.wersonig.backend.tribalages.model.Ressources;

@Repository
public interface EventRepo extends AbstractRepo<Event>, CrudRepository<Event, Long> {
}

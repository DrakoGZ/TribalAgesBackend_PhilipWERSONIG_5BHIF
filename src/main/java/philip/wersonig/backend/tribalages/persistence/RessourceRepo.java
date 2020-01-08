package philip.wersonig.backend.tribalages.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import philip.wersonig.backend.tribalages.model.Ressource;

@Repository
public interface RessourceRepo extends AbstractRepo<Ressource>, CrudRepository<Ressource, Long> {
}


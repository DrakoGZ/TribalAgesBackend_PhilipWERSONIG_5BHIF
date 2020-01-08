package philip.wersonig.backend.tribalages.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import philip.wersonig.backend.tribalages.model.Eventanswers;
import philip.wersonig.backend.tribalages.model.Ressources;

@Repository
public interface EventAnswersRepo extends AbstractRepo<Eventanswers>, CrudRepository<Eventanswers, Long> {

}

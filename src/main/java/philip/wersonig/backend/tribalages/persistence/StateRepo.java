package philip.wersonig.backend.tribalages.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import philip.wersonig.backend.tribalages.model.Ressources;
import philip.wersonig.backend.tribalages.model.State;

@Repository
public interface StateRepo extends AbstractRepo<State>, CrudRepository<State, Long> {

}

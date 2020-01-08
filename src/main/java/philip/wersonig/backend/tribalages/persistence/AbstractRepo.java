package philip.wersonig.backend.tribalages.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import philip.wersonig.backend.tribalages.model.AbstractModel;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
public interface AbstractRepo<T extends AbstractModel> {

    Optional<T> findByIdentifier(String identifier);

    List<T> findAll();

    void deleteByIdentifier(String identifier);

}

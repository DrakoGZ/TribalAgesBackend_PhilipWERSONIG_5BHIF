package philip.wersonig.backend.tribalages.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import philip.wersonig.backend.tribalages.model.AbstractModel;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
public interface AbstractRepo<T extends AbstractModel> {

    /**
     * finds an Object by it's given identifier
     *
     * @param identifier
     * @return
     */
    Optional<T> findByIdentifier(String identifier);

    /**
     * returns all objects of a table
     *
     * @return
     */
    List<T> findAll();


    /**
     * deletes an objects based on the given identifier
     *
     * @param identifier
     */
    void deleteByIdentifier(String identifier);

}

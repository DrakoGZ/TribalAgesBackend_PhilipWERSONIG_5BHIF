package philip.wersonig.backend.tribalages.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import philip.wersonig.backend.tribalages.dto.AbstractModelDto;
import philip.wersonig.backend.tribalages.model.AbstractModel;
import philip.wersonig.backend.tribalages.model.State;
import philip.wersonig.backend.tribalages.persistence.AbstractRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public abstract class AbstractService
        <D extends AbstractModelDto, M extends AbstractModel> {

    /**
     * Returns a List of all Objects in a table
     * @return
     */
    public List<D> findAll(){
        return findall()
                .stream()
                .map(item -> convertModelIntoDTO(item))
                .collect(Collectors.toList());
    }

    /**
     * Saves a given object to the database and returns it afterwards
     *
     * @param dto
     * @return
     */
    public Optional<D> save(Optional<D> dto) {
        M model = dto.map(d -> convertDTOIntoModel(d)).get();
        return Optional.of(saveRep(model))
                .map(m -> convertModelIntoDTO(m));

    }

    /**
     * Updates a given object to the database and returns it afterwards
     *
     * @param dto
     * @return
     */
    public Optional<D> update (Optional<D> dto) {
        Optional<M> old = findByIdentifier(dto.get().getIdentifier());
        if(old.isEmpty())
        {
            return Optional.empty();
        }
        M model = dto.map(d -> convertDTOIntoModel(d)).get();
        model.setId(old.get().getId());
        return Optional.of(saveRep(model))
                .map(m -> convertModelIntoDTO(m));
    }

    /**
     * Returns a searched for object by the given identifier
     *
     * @param identifier
     * @return
     */
    public Optional<D> findModelByIdentifier(String identifier) {
        return findByIdentifier(identifier)
                .map(m -> convertModelIntoDTO(m));
    }

    /**
     * Deletes and returns a given object afterwards
     *
     * @param identifier
     * @return
     */
    public boolean deleteModelByIdentifier(String identifier) {
        deleteByIdentifier(identifier);
        return findModelByIdentifier(identifier).isEmpty();
    }

    /**
     * Convert a given Model into a respective DTO
     * @param model
     * @return
     */
    abstract D convertModelIntoDTO(M model);

    /**
     * Convert a given DTO into a respective Model
     * @param dto
     * @return
     */
    abstract M convertDTOIntoModel(D dto);

    /**
     * Calls the find all method of the respective repo
     * @return
     */
    abstract List<M> findall();

    /**
     * Calls the save method of the respective repo
     * @return
     */
    abstract M saveRep(M model);

    /**
     * Calls the find by Identifier method of the respective repo
     * @return
     */
    abstract Optional<M> findByIdentifier(String identifier);

    /**
     * Calls the delete by identifier method of the respective repo
     * @return
     */
    abstract void deleteByIdentifier(String identifier);
}

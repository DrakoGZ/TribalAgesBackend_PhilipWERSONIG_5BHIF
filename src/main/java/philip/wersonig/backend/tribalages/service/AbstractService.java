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

    public List<D> findAll(){
        return findall()
                .stream()
                .map(item -> convertModelIntoDTO(item))
                .collect(Collectors.toList());
    }

    public Optional<D> save(Optional<D> dto) {
        M model = dto.map(d -> convertDTOIntoModel(d)).get();
        return Optional.of(saveRep(model))
                .map(m -> convertModelIntoDTO(m));

    }
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

    public Optional<D> findModelByIdentifier(String identifier) {
        return findByIdentifier(identifier)
                .map(m -> convertModelIntoDTO(m));
    }

    public boolean deleteModelByIdentifier(String identifier) {
        deleteByIdentifier(identifier);
        return findModelByIdentifier(identifier).isEmpty();
    }

    abstract D convertModelIntoDTO(M model);
    abstract M convertDTOIntoModel(D dto);
    abstract List<M> findall();
    abstract M saveRep(M model);
    abstract Optional<M> findByIdentifier(String identifier);
    abstract void deleteByIdentifier(String identifier);
}

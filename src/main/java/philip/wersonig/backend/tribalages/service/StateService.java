package philip.wersonig.backend.tribalages.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import philip.wersonig.backend.tribalages.dto.StateDto;
import philip.wersonig.backend.tribalages.model.State;
import philip.wersonig.backend.tribalages.persistence.StateRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class StateService
        extends AbstractService<StateDto, State>{

    private final StateRepo stateRepo;

    /**
     * Convert a given Model into a respective DTO
     * @param model
     * @return
     */
    @Override
    StateDto convertModelIntoDTO(State model) {
        return new StateDto(model);
    }

    /**
     * Convert a given DTO into a respective Model
     * @param dto
     * @return
     */
    @Override
    State convertDTOIntoModel(StateDto dto) {
        return new State(dto);
    }

    /**
     * Calls the find all method of the respective repo
     * @return
     */
    @Override
    List<State> findall() {
        return stateRepo.findAll();
    }

    /**
     * Calls the save method of the respective repo
     * @return
     */
    @Override
    State saveRep(State model) {
        return stateRepo.save(model);
    }

    /**
     * Calls the find by Identifier method of the respective repo
     * @return
     */
    @Override
    Optional<State> findByIdentifier(String identifier) {
        return stateRepo.findByIdentifier(identifier);
    }

    /**
     * Calls the delete by identifier method of the respective repo
     * @return
     */
    @Override
    void deleteByIdentifier(String identifier) {
        stateRepo.deleteByIdentifier(identifier);
    }


    /**
     * Calls the delete all method of the respective repo
     * @return
     */
    public void deleteAll() {
        stateRepo.deleteAll();
    }

}

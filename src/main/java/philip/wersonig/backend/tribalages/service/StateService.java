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

    @Override
    StateDto convertModelIntoDTO(State model) {
        return new StateDto(model);
    }

    @Override
    State convertDTOIntoModel(StateDto dto) {
        return new State(dto);
    }

    @Override
    List<State> findall() {
        return stateRepo.findAll();
    }

    @Override
    State saveRep(State model) {
        return stateRepo.save(model);
    }

    @Override
    Optional<State> findByIdentifier(String identifier) {
        return stateRepo.findByIdentifier(identifier);
    }

    @Override
    void deleteByIdentifier(String identifier) {
        stateRepo.deleteByIdentifier(identifier);
    }


    public void deleteAll() {
        stateRepo.deleteAll();
    }

}

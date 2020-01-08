package philip.wersonig.backend.tribalages.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import philip.wersonig.backend.tribalages.dto.EventAnswersDto;
import philip.wersonig.backend.tribalages.model.Eventanswers;
import philip.wersonig.backend.tribalages.persistence.EventAnswersRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class EventAnswersService
        extends AbstractService<EventAnswersDto, Eventanswers>{

    private final EventAnswersRepo eventAnswersRepo;

    @Override
    EventAnswersDto convertModelIntoDTO(Eventanswers model) {
        return new EventAnswersDto(model);
    }

    @Override
    Eventanswers convertDTOIntoModel(EventAnswersDto dto) {
        return new Eventanswers(dto);
    }

    @Override
    List<Eventanswers> findall() {
        return eventAnswersRepo.findAll();
    }

    @Override
    Eventanswers saveRep(Eventanswers model) {
        return eventAnswersRepo.save(model);
    }

    @Override
    Optional<Eventanswers> findByIdentifier(String identifier) {
        return eventAnswersRepo.findByIdentifier(identifier);
    }

    @Override
    void deleteByIdentifier(String identifier) {
        eventAnswersRepo.deleteByIdentifier(identifier);
    }
}

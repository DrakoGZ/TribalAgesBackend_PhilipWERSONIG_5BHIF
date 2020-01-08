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

    /**
     * Convert a given Model into a respective DTO
     * @param model
     * @return
     */
    @Override
    EventAnswersDto convertModelIntoDTO(Eventanswers model) {
        return new EventAnswersDto(model);
    }

    /**
     * Convert a given DTO into a respective Model
     * @param dto
     * @return
     */
    @Override
    Eventanswers convertDTOIntoModel(EventAnswersDto dto) {
        return new Eventanswers(dto);
    }

    /**
     * Calls the find all method of the respective repo
     * @return
     */
    @Override
    List<Eventanswers> findall() {
        return eventAnswersRepo.findAll();
    }

    /**
     * Calls the save method of the respective repo
     * @return
     */
    @Override
    Eventanswers saveRep(Eventanswers model) {
        return eventAnswersRepo.save(model);
    }

    /**
     * Calls the find by Identifier method of the respective repo
     * @return
     */
    @Override
    Optional<Eventanswers> findByIdentifier(String identifier) {
        return eventAnswersRepo.findByIdentifier(identifier);
    }

    /**
     * Calls the delete by identifier method of the respective repo
     * @return
     */
    @Override
    void deleteByIdentifier(String identifier) {
        eventAnswersRepo.deleteByIdentifier(identifier);
    }
}

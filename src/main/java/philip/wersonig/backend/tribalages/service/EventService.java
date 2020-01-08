package philip.wersonig.backend.tribalages.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import philip.wersonig.backend.tribalages.dto.EventDto;
import philip.wersonig.backend.tribalages.model.Event;
import philip.wersonig.backend.tribalages.persistence.EventRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class EventService
        extends AbstractService<EventDto, Event>{

    private final EventRepo eventRepo;

    /**
     * Convert a given Model into a respective DTO
     * @param model
     * @return
     */
    @Override
    EventDto convertModelIntoDTO(Event model) {
        return new EventDto(model);
    }

    /**
     * Convert a given DTO into a respective Model
     * @param dto
     * @return
     */
    @Override
    Event convertDTOIntoModel(EventDto dto) {
        return new Event(dto);
    }

    /**
     * Calls the find all method of the respective repo
     * @return
     */
    @Override
    List<Event> findall() {
        return eventRepo.findAll();
    }

    /**
     * Calls the save method of the respective repo
     * @return
     */
    @Override
    Event saveRep(Event model) {
        return eventRepo.save(model);
    }

    /**
     * Calls the find by Identifier method of the respective repo
     * @return
     */
    @Override
    Optional<Event> findByIdentifier(String identifier) {
        return eventRepo.findByIdentifier(identifier);
    }

    /**
     * Calls the delete by identifier method of the respective repo
     * @return
     */
    @Override
    void deleteByIdentifier(String identifier) {
        eventRepo.deleteByIdentifier(identifier);
    }
}

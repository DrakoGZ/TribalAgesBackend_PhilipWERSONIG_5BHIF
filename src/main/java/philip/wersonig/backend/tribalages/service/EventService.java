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

    @Override
    EventDto convertModelIntoDTO(Event model) {
        return new EventDto(model);
    }

    @Override
    Event convertDTOIntoModel(EventDto dto) {
        return new Event(dto);
    }

    @Override
    List<Event> findall() {
        return eventRepo.findAll();
    }

    @Override
    Event saveRep(Event model) {
        return eventRepo.save(model);
    }

    @Override
    Optional<Event> findByIdentifier(String identifier) {
        return eventRepo.findByIdentifier(identifier);
    }

    @Override
    void deleteByIdentifier(String identifier) {
        eventRepo.deleteByIdentifier(identifier);
    }
}

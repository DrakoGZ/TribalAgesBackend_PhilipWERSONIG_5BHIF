package philip.wersonig.backend.tribalages.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import philip.wersonig.backend.tribalages.dto.EventAnswersDto;
import philip.wersonig.backend.tribalages.dto.EventDto;
import philip.wersonig.backend.tribalages.service.EventAnswersService;
import philip.wersonig.backend.tribalages.service.EventService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@RequestMapping(path = "/event")
public class EventController extends AbstractController<EventDto>{
    private final EventService service;

    /**
     * calls the find all method of the appropriate service
     *
     * @return
     */
    @Override
    List<EventDto> findAllDTO() {
        return service.findAll();
    }

    /**
     * calls the findbyIdentifier method of the appropriate service
     *
     * @return
     */
    @Override
    Optional<EventDto> findByIdentifierDTO(String identifier) {
        return service.findModelByIdentifier(identifier);
    }

    /**
     * calls the save method of the appropriate service
     *
     * @return
     */
    @Override
    Optional<EventDto> saveDTO(Optional<EventDto> optionaldto) {
        return service.save(optionaldto);
    }

    /**
     * calls the update method of the appropriate service
     *
     * @return
     */
    @Override
    Optional<EventDto> updateDTO(Optional<EventDto> optionaldto) {
        return service.update(optionaldto);
    }

    /**
     * calls the deleteByIdentifier method of the appropriate service
     *
     * @return
     */
    @Override
    Optional<EventDto> deleteByIdentifierDTO(String identifier) {
        Optional<EventDto> optionaldto = service.findModelByIdentifier(identifier);
        service.deleteModelByIdentifier(identifier);
        return optionaldto;
    }
}

package philip.wersonig.backend.tribalages.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import philip.wersonig.backend.tribalages.dto.EventAnswersDto;
import philip.wersonig.backend.tribalages.service.EventAnswersService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@RequestMapping(path = "/eventAnswers")
public class EventAnswersController extends AbstractController<EventAnswersDto>{

    private final EventAnswersService service;

    /**
     * calls the find all method of the appropriate service
     *
     * @return
     */
    @Override
    List<EventAnswersDto> findAllDTO() {
        return service.findAll();
    }

    /**
     * calls the findbyIdentifier method of the appropriate service
     *
     * @return
     */
    @Override
    Optional<EventAnswersDto> findByIdentifierDTO(String identifier) {
        return service.findModelByIdentifier(identifier);
    }

    /**
     * calls the save method of the appropriate service
     *
     * @return
     */
    @Override
    Optional<EventAnswersDto> saveDTO(Optional<EventAnswersDto> optionaldto) {
        return service.save(optionaldto);
    }

    /**
     * calls the update method of the appropriate service
     *
     * @return
     */
    @Override
    Optional<EventAnswersDto> updateDTO(Optional<EventAnswersDto> optionaldto) {
        return service.update(optionaldto);
    }

    /**
     * calls the deleteByIdentifier method of the appropriate service
     *
     * @return
     */
    @Override
    Optional<EventAnswersDto> deleteByIdentifierDTO(String identifier) {
        Optional<EventAnswersDto> optionaldto = service.findModelByIdentifier(identifier);
        service.deleteModelByIdentifier(identifier);
        return optionaldto;
    }
}

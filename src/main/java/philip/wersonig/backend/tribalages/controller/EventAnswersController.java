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

    @Override
    List<EventAnswersDto> findAllDTO() {
        return service.findAll();
    }

    @Override
    Optional<EventAnswersDto> findByIdentifierDTO(String identifier) {
        return service.findModelByIdentifier(identifier);
    }

    @Override
    Optional<EventAnswersDto> saveDTO(Optional<EventAnswersDto> optionaldto) {
        return service.save(optionaldto);
    }

    @Override
    Optional<EventAnswersDto> updateDTO(Optional<EventAnswersDto> optionaldto) {
        return service.update(optionaldto);
    }

    @Override
    Optional<EventAnswersDto> deleteByIdentifierDTO(String identifier) {
        Optional<EventAnswersDto> optionaldto = service.findModelByIdentifier(identifier);
        service.deleteModelByIdentifier(identifier);
        return optionaldto;
    }
}

package philip.wersonig.backend.tribalages.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import philip.wersonig.backend.tribalages.dto.EventAnswersDto;
import philip.wersonig.backend.tribalages.dto.RessourceDto;
import philip.wersonig.backend.tribalages.service.EventAnswersService;
import philip.wersonig.backend.tribalages.service.RessourceService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@RequestMapping(path = "/ressource")
public class RessourceController extends AbstractController<RessourceDto>{

    private final RessourceService service;

    /**
     * calls the find all method of the appropriate service
     *
     * @return
     */
    @Override
    List<RessourceDto> findAllDTO() {
        return service.findAll();
    }

    /**
     * calls the findbyIdentifier method of the appropriate service
     *
     * @return
     */
    @Override
    Optional<RessourceDto> findByIdentifierDTO(String identifier) {
        return service.findModelByIdentifier(identifier);
    }

    /**
     * calls the save method of the appropriate service
     *
     * @return
     */
    @Override
    Optional<RessourceDto> saveDTO(Optional<RessourceDto> optionaldto) {
        return service.save(optionaldto);
    }

    /**
     * calls the update method of the appropriate service
     *
     * @return
     */
    @Override
    Optional<RessourceDto> updateDTO(Optional<RessourceDto> optionaldto) {
        return service.update(optionaldto);
    }

    /**
     * calls the deleteByIdentifier method of the appropriate service
     *
     * @return
     */
    @Override
    Optional<RessourceDto> deleteByIdentifierDTO(String identifier) {
        Optional<RessourceDto> optionaldto = service.findModelByIdentifier(identifier);
        service.deleteModelByIdentifier(identifier);
        return optionaldto;
    }
}

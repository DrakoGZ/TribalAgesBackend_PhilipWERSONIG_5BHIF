package philip.wersonig.backend.tribalages.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import philip.wersonig.backend.tribalages.dto.EventAnswersDto;
import philip.wersonig.backend.tribalages.dto.RessourcesDto;
import philip.wersonig.backend.tribalages.service.RessourcesService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@RequestMapping(path = "/ressources")
public class RessourcesController extends AbstractController<RessourcesDto>{

    private final RessourcesService service;


    /**
     * calls the find all method of the appropriate service
     *
     * @return
     */
    @Override
    List<RessourcesDto> findAllDTO() {
        return service.findAll();
    }

    /**
     * calls the findbyIdentifier method of the appropriate service
     *
     * @return
     */
    @Override
    Optional<RessourcesDto> findByIdentifierDTO(String identifier) {
        return service.findModelByIdentifier(identifier);
    }

    /**
     * calls the save method of the appropriate service
     *
     * @return
     */
    @Override
    Optional<RessourcesDto> saveDTO(Optional<RessourcesDto> optionaldto) {
        return service.save(optionaldto);
    }

    /**
     * calls the update method of the appropriate service
     *
     * @return
     */
    @Override
    Optional<RessourcesDto> updateDTO(Optional<RessourcesDto> optionaldto) {
        return service.update(optionaldto);
    }

    /**
     * calls the deleteByIdentifier method of the appropriate service
     *
     * @return
     */
    @Override
    Optional<RessourcesDto> deleteByIdentifierDTO(String identifier) {
        Optional<RessourcesDto> optionaldto = service.findModelByIdentifier(identifier);
        service.deleteModelByIdentifier(identifier);
        return optionaldto;
    }
}

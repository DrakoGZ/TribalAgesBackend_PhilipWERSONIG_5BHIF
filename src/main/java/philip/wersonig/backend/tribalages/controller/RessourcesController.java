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


    @Override
    List<RessourcesDto> findAllDTO() {
        return service.findAll();
    }

    @Override
    Optional<RessourcesDto> findByIdentifierDTO(String identifier) {
        return service.findModelByIdentifier(identifier);
    }

    @Override
    Optional<RessourcesDto> saveDTO(Optional<RessourcesDto> optionaldto) {
        return service.save(optionaldto);
    }

    @Override
    Optional<RessourcesDto> updateDTO(Optional<RessourcesDto> optionaldto) {
        return service.update(optionaldto);
    }

    @Override
    Optional<RessourcesDto> deleteByIdentifierDTO(String identifier) {
        Optional<RessourcesDto> optionaldto = service.findModelByIdentifier(identifier);
        service.deleteModelByIdentifier(identifier);
        return optionaldto;
    }
}

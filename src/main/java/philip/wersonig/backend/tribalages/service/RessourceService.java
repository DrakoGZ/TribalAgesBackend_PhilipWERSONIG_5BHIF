package philip.wersonig.backend.tribalages.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import philip.wersonig.backend.tribalages.dto.RessourceDto;
import philip.wersonig.backend.tribalages.model.Ressource;
import philip.wersonig.backend.tribalages.persistence.RessourceRepo;
import philip.wersonig.backend.tribalages.persistence.RessourcesRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class RessourceService
        extends AbstractService<RessourceDto, Ressource>{

    private final RessourceRepo ressourceRepo;

    @Override
    RessourceDto convertModelIntoDTO(Ressource model) {
        return new RessourceDto(model);
    }

    @Override
    Ressource convertDTOIntoModel(RessourceDto dto) {
        return new Ressource(dto);
    }

    @Override
    List<Ressource> findall() {
        return ressourceRepo.findAll();
    }

    @Override
    Ressource saveRep(Ressource model) {
        return ressourceRepo.save(model);
    }

    @Override
    Optional<Ressource> findByIdentifier(String identifier) {
        return ressourceRepo.findByIdentifier(identifier);
    }

    @Override
    void deleteByIdentifier(String identifier) {
        ressourceRepo.deleteByIdentifier(identifier);
    }
}

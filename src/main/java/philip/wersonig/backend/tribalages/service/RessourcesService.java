package philip.wersonig.backend.tribalages.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import philip.wersonig.backend.tribalages.dto.RessourcesDto;
import philip.wersonig.backend.tribalages.dto.StateDto;
import philip.wersonig.backend.tribalages.model.Ressources;
import philip.wersonig.backend.tribalages.model.State;
import philip.wersonig.backend.tribalages.persistence.RessourceRepo;
import philip.wersonig.backend.tribalages.persistence.RessourcesRepo;
import philip.wersonig.backend.tribalages.persistence.StateRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class RessourcesService
        extends AbstractService<RessourcesDto, Ressources>{

    private final RessourcesRepo ressourcesRepo;

    @Override
    RessourcesDto convertModelIntoDTO(Ressources model) {
        return new RessourcesDto(model);
    }

    @Override
    Ressources convertDTOIntoModel(RessourcesDto dto) {
        return new Ressources(dto);
    }

    @Override
    List<Ressources> findall() {
        return ressourcesRepo.findAll();
    }

    @Override
    Ressources saveRep(Ressources model) {
        return ressourcesRepo.save(model);
    }

    @Override
    Optional<Ressources> findByIdentifier(String identifier) {
        return ressourcesRepo.findByIdentifier(identifier);
    }

    @Override
    void deleteByIdentifier(String identifier) {
        ressourcesRepo.deleteByIdentifier(identifier);
    }
}

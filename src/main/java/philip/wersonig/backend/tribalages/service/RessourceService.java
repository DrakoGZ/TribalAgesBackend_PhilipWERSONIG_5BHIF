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

    /**
     * Convert a given Model into a respective DTO
     * @param model
     * @return
     */
    @Override
    RessourceDto convertModelIntoDTO(Ressource model) {
        return new RessourceDto(model);
    }

    /**
     * Convert a given DTO into a respective Model
     * @param dto
     * @return
     */
    @Override
    Ressource convertDTOIntoModel(RessourceDto dto) {
        return new Ressource(dto);
    }

    /**
     * Calls the find all method of the respective repo
     * @return
     */
    @Override
    List<Ressource> findall() {
        return ressourceRepo.findAll();
    }

    /**
     * Calls the save method of the respective repo
     * @return
     */
    @Override
    Ressource saveRep(Ressource model) {
        return ressourceRepo.save(model);
    }

    /**
     * Calls the find by Identifier method of the respective repo
     * @return
     */
    @Override
    Optional<Ressource> findByIdentifier(String identifier) {
        return ressourceRepo.findByIdentifier(identifier);
    }

    /**
     * Calls the delete by identifier method of the respective repo
     * @return
     */
    @Override
    void deleteByIdentifier(String identifier) {
        ressourceRepo.deleteByIdentifier(identifier);
    }
}

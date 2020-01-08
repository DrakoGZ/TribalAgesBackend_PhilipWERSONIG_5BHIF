package philip.wersonig.backend.tribalages.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import philip.wersonig.backend.tribalages.dto.EventAnswersDto;
import philip.wersonig.backend.tribalages.dto.RessourceDto;
import philip.wersonig.backend.tribalages.dto.RessourcesDto;
import philip.wersonig.backend.tribalages.dto.StateDto;
import philip.wersonig.backend.tribalages.model.Ressource;
import philip.wersonig.backend.tribalages.model.Ressources;
import philip.wersonig.backend.tribalages.model.State;
import philip.wersonig.backend.tribalages.service.EventAnswersService;
import philip.wersonig.backend.tribalages.service.StateService;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@RequestMapping(path = "/state")
public class StateController extends AbstractController<StateDto>{

    private final StateService service;

    @Override
    List<StateDto> findAllDTO() {
        return service.findAll();
    }

    @Override
    Optional<StateDto> findByIdentifierDTO(String identifier) {
        return service.findModelByIdentifier(identifier);
    }

    @Override
    Optional<StateDto> saveDTO(Optional<StateDto> optionaldto) {
        return service.save(optionaldto);
    }

    @Override
    Optional<StateDto> updateDTO(Optional<StateDto> optionaldto) {
        return service.update(optionaldto);
    }

    @Override
    Optional<StateDto> deleteByIdentifierDTO(String identifier) {
        Optional<StateDto> optionaldto = service.findModelByIdentifier(identifier);
        service.deleteModelByIdentifier(identifier);
        return optionaldto;
    }

    @PostMapping(path="/saveState", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<StateDto> update(
            @RequestBody StateDto dto) {

        if(dto.getIdentifier().equals("abcdWonderfullIdentifier123")) {
            dto.setIdentifier(UUID.randomUUID().toString());
            service.deleteAll();
            return ResponseEntity.ok(
                    saveDTO(Optional.of(dto))
                            .map(this::addSelfLink)
                            .orElseThrow(IllegalArgumentException::new)
            );
        } else {
            var updated = updateDTO(Optional.of(dto));
            if(updated.isEmpty())
            {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
            return ResponseEntity.ok(
                    updated.map(this::addSelfLink)
                            .orElseThrow(IllegalArgumentException::new)
            );
        }
    }

    @GetMapping(path="/getSavedState")
    public ResponseEntity<StateDto> getSavedState()
    {
        if(findAllDTO().size()==0){
            List<StateDto> list = new ArrayList<>();
            list.add(generateNewState());

            return ResponseEntity.ok(
                list
                    .stream()
                    .map(this::addSelfLink)
                    .collect(Collectors.toList())
                    .get(0)
            );
        }
        return ResponseEntity.ok(
            findAllDTO()
                    .stream()
                    .map(this::addSelfLink)
                    .collect(Collectors.toList())
                    .get(0)
        );
    }

    @GetMapping(path="/getStartState")
    public ResponseEntity<StateDto> getStartState()
    {

        List<StateDto> list = new ArrayList<>();
        list.add(generateNewState());

        return ResponseEntity.ok(
            list
                .stream()
                .map(this::addSelfLink)
                .collect(Collectors.toList())
                .get(0)
        );
    }

    private StateDto generateNewState(){
        ArrayList<RessourceDto> al = new ArrayList<RessourceDto>();
        al.add(
            new RessourceDto("R1","Food","Casual Food Crops",100,50,50)
        );
        al.add(
            new RessourceDto("R2","WorkForce","How much our Population can put into Building Production",0,50,10)
        );

        return new StateDto("abcdWonderfullIdentifier123",
                "NewAutoGenState",
                new RessourceDto("P1","People","normal people",1000,10,0),
                1,0,0,0,
                new RessourcesDto("S1", al, 1));
    }
}

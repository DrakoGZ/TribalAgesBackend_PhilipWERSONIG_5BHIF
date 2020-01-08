package philip.wersonig.backend.tribalages.controller;

import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import philip.wersonig.backend.tribalages.dto.AbstractModelDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class AbstractController<D extends AbstractModelDto> {

    /**
     * Get route to return all Objects of a table
     *
     * @return
     */
    @GetMapping
    public ResponseEntity<CollectionModel<D>> findAll() {
        return ResponseEntity.ok(
                new CollectionModel<>(
                        findAllDTO()
                                .stream()
                                .map(this::addSelfLink)
                                .collect(Collectors.toList())
                )
        );
    }


    /**
     * Get route to return a single object by it'S identifier
     *
     * @param identifier
     * @return
     */
    @GetMapping(params = "identifier")
    public ResponseEntity<D> findByIdentifier(
            @RequestParam String identifier
    )
    {
        Optional<D> find = findByIdentifierDTO(identifier);
        if(find.isEmpty())
        {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.of(
                findByIdentifierDTO(identifier)
                        .map(this::addSelfLink)
        );
    }

    /**
     * Post route to create a new object based on the given object
     *
     * @param dto
     * @return
     */
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<D> create(
            @RequestBody D dto) {
        dto.setIdentifier(null);
        return ResponseEntity.ok(
                saveDTO(Optional.of(dto))
                        .map(this::addSelfLink)
                        .orElseThrow(IllegalArgumentException::new)
        );
    }


    /**
     * Put route to update a new object based on the given object
     *
     * @param dto
     * @return
     */
    @PutMapping(consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<D> update(
            @RequestBody D dto) {
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

    /**
     * Delete route to udelete an object based on the given identifier
     *
     * @param identifier
     * @return
     */
    @DeleteMapping(params = "identifier")
    public Optional<D> delete(@RequestParam String identifier)
    {
        return deleteByIdentifierDTO(identifier);
    }

    D addSelfLink(D dto) {
        /*dto.add(
                linkTo(
                        ControllerLinkBuilder.methodOn(this.getClass())
                                .findByIdentifier(dto.getIdentifier())
                ).withSelfRel()
        );*/

        return dto;
    }

    /**
     * calls the find all method of the appropriate service
     *
     * @return
     */
    abstract List<D> findAllDTO();

    /**
     * calls the findbyIdentifier method of the appropriate service
     *
     * @return
     */
    abstract Optional<D> findByIdentifierDTO(String identifier);

    /**
     * calls the save method of the appropriate service
     *
     * @return
     */
    abstract Optional<D> saveDTO(Optional<D> optionaldto);

    /**
     * calls the update method of the appropriate service
     *
     * @return
     */
    abstract Optional<D> updateDTO(Optional<D> optionaldto);

    /**
     * calls the deleteByIdentifier method of the appropriate service
     *
     * @return
     */
    abstract Optional<D> deleteByIdentifierDTO(String identifier);
}

package philip.wersonig.backend.tribalages.model;

import lombok.*;
import philip.wersonig.backend.tribalages.dto.StateDto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import java.util.Optional;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class State extends AbstractModel {
    private String name;

    @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER)
    private Ressource population;

    private int speedmultiplier;
    private int dateDay;
    private int dateMonth;
    private int dateYear;

    @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER)
    private Ressources storage;

    public State(StateDto stateDto) {
        this.identifier = Optional.ofNullable(stateDto.getIdentifier())
                .orElse(UUID.randomUUID().toString());
        this.name = stateDto.getName();
        this.population = new Ressource(stateDto.getPopulation());
        this.speedmultiplier = stateDto.getSpeedmultiplier();
        this.dateDay = stateDto.getDateDay();
        this.dateMonth = stateDto.getDateMonth();
        this.dateYear = stateDto.getDateYear();
        this.storage = new Ressources(stateDto.getStorage());

    }
}

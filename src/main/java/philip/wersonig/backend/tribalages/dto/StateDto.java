package philip.wersonig.backend.tribalages.dto;

import lombok.*;
import philip.wersonig.backend.tribalages.model.Event;
import philip.wersonig.backend.tribalages.model.Ressource;
import philip.wersonig.backend.tribalages.model.Ressources;
import philip.wersonig.backend.tribalages.model.State;

import javax.persistence.OneToOne;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StateDto extends AbstractModelDto{
    private String name;
    private RessourceDto population;

    private int speedmultiplier;
    private int dateDay;
    private int dateMonth;
    private int dateYear;

    private RessourcesDto storage;


    @Builder
    public StateDto(String identifier, String name, RessourceDto population, int speedmultiplier, int dateDay,
                    int dateMonth, int dateYear, RessourcesDto storage){
        super(identifier);
        this.name = name;
        this.population = population;
        this.speedmultiplier = speedmultiplier;
        this.dateDay = dateDay;
        this.dateMonth = dateMonth;
        this.dateYear = dateYear;
        this.storage = storage;
    }

    public StateDto(State state){
        this.setIdentifier(state.getIdentifier());
        this.name = state.getName();
        this.population = new RessourceDto(state.getPopulation());
        this.speedmultiplier = state.getSpeedmultiplier();
        this.dateDay = state.getDateDay();
        this.dateMonth = state.getDateMonth();
        this.dateYear = state.getDateYear();
        this.storage = new RessourcesDto(state.getStorage());
    }
}

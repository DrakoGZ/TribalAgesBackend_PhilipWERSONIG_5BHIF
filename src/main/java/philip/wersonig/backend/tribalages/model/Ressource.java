package philip.wersonig.backend.tribalages.model;

import lombok.*;
import philip.wersonig.backend.tribalages.dto.EventDto;
import philip.wersonig.backend.tribalages.dto.RessourceDto;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Optional;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ressource extends AbstractModel{
    private String name;
    private String description;
    private float amount;
    private float growthFocus;
    private float savedPercentage;


    public Ressource(RessourceDto ressourceDto){
        this.identifier = Optional.ofNullable(ressourceDto.getIdentifier())
                .orElse(UUID.randomUUID().toString());
        this.name = ressourceDto.getName();
        this.description = ressourceDto.getDescription();
        this.amount = ressourceDto.getAmount();
        this.growthFocus = ressourceDto.getGrowthFocus();
        this.savedPercentage = ressourceDto.getSavedPercentage();
    }
}

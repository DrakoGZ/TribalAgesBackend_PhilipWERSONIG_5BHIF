package philip.wersonig.backend.tribalages.dto;

import lombok.*;
import philip.wersonig.backend.tribalages.model.Event;
import philip.wersonig.backend.tribalages.model.Ressource;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RessourceDto extends AbstractModelDto{
    private String name;
    private String description;
    private float amount;
    private float growthFocus;
    private float savedPercentage;

    @Builder
    public RessourceDto(String identifier, String name, String description, float amount, float growthFocus, float savedPercentage) {
        super(identifier);
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.growthFocus = growthFocus;
        this.savedPercentage = savedPercentage;
    }

    public RessourceDto(Ressource ressource){
        super(ressource.getIdentifier());
        this.name = ressource.getName();
        this.description = ressource.getDescription();
        this.amount = ressource.getAmount();
        this.growthFocus = ressource.getGrowthFocus();
        this.savedPercentage = ressource.getSavedPercentage();
    }
}

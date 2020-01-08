package philip.wersonig.backend.tribalages.dto;

import lombok.*;
import philip.wersonig.backend.tribalages.model.Ressource;
import philip.wersonig.backend.tribalages.model.Ressources;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.stream.Collectors;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RessourcesDto extends AbstractModelDto{
    private List<RessourceDto> ressources;
    private int lastMonth;

    @Builder
    public RessourcesDto(String identifier, List<RessourceDto> ressources, int lastMonth) {
        super(identifier);
        this.ressources = ressources;
        this.lastMonth = lastMonth;
    }

    public RessourcesDto(Ressources ressources){
        super(ressources.getIdentifier());
        this.ressources = ressources.getRessourceList()
                .stream().map(element -> new RessourceDto(element))
                .collect(Collectors.toList());
        this.lastMonth = ressources.getLastMonth();
    }
}

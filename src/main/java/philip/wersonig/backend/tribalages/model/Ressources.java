package philip.wersonig.backend.tribalages.model;

import lombok.*;
import philip.wersonig.backend.tribalages.dto.RessourcesDto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ressources extends AbstractModel{
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Ressource> ressourceList;
    private int lastMonth;

    public Ressources(RessourcesDto ressourcesDto){
        this.identifier = Optional.ofNullable(ressourcesDto.getIdentifier())
                .orElse(UUID.randomUUID().toString());
        this.ressourceList = ressourcesDto.getRessources()
                .stream().map(element -> new Ressource(element))
                .collect(Collectors.toList());
        this.lastMonth = ressourcesDto.getLastMonth();

    }
}

package philip.wersonig.backend.tribalages.model;

import lombok.*;
import philip.wersonig.backend.tribalages.dto.EventAnswersDto;
import philip.wersonig.backend.tribalages.dto.EventDto;

import javax.persistence.Entity;
import java.util.Optional;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Eventanswers extends AbstractModel{
    private String text;
    private String ressource;
    private float amount;

    public Eventanswers(EventAnswersDto eventAnswersDto){
        this.identifier = Optional.ofNullable(eventAnswersDto.getIdentifier())
                .orElse(UUID.randomUUID().toString());
        this.text = eventAnswersDto.getText();
        this.ressource = eventAnswersDto.getRessource();
        this.amount = eventAnswersDto.getAmount();

    }
}

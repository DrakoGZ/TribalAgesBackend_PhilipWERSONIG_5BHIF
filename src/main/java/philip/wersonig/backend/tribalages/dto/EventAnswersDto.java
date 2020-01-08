package philip.wersonig.backend.tribalages.dto;

import lombok.*;
import philip.wersonig.backend.tribalages.model.Eventanswers;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventAnswersDto extends AbstractModelDto{
    private String text;
    private String ressource;
    private float amount;

    public EventAnswersDto(Eventanswers model) {
        super(model.getIdentifier());
        this.text = model.getText();
        this.ressource = model.getRessource();
        this.amount = model.getAmount();
    }
}

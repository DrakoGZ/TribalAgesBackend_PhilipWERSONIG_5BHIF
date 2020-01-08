package philip.wersonig.backend.tribalages.dto;

import lombok.*;
import philip.wersonig.backend.tribalages.model.Event;
import philip.wersonig.backend.tribalages.model.Eventanswers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventDto extends AbstractModelDto{

    private String title;
    private String text;

    private int dateDayEarliest;
    private int dateMonthEarliest;
    private int dateYearEarliest;

    private int dateDayLatest;
    private int dateMonthLatest;
    private int dateYearLatest;

    private List<EventAnswersDto> answers;

    public EventDto(Event event){
        super(event.getIdentifier());
        this.title = event.getTitle();
        this.text = event.getText();
        this.dateDayEarliest = event.getDateDayEarliest();
        this.dateMonthEarliest = event.getDateMonthEarliest();
        this.dateYearEarliest = event.getDateDayEarliest();
        this.dateDayLatest = event.getDateDayLatest();
        this.dateMonthLatest = event.getDateMonthLatest();
        this.dateYearLatest = event.getDateYearLatest();
        this.answers = event.getAnswers()
                .stream().map(element -> new EventAnswersDto(element))
                .collect(Collectors.toList());
    }
}

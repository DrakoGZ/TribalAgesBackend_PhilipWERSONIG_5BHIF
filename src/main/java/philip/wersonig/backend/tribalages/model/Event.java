package philip.wersonig.backend.tribalages.model;

import lombok.*;
import philip.wersonig.backend.tribalages.dto.EventAnswersDto;
import philip.wersonig.backend.tribalages.dto.EventDto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
public class Event extends AbstractModel{
    private String title;
    private String text;

    private int dateDayEarliest;
    private int dateMonthEarliest;
    private int dateYearEarliest;

    private int dateDayLatest;
    private int dateMonthLatest;
    private int dateYearLatest;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Eventanswers> answers;

    public Event(EventDto eventDto){
        this.identifier = Optional.ofNullable(eventDto.getIdentifier())
                .orElse(UUID.randomUUID().toString());
        this.title = eventDto.getTitle();
        this.text = eventDto.getTitle();
        this.dateDayEarliest = eventDto.getDateDayEarliest();
        this.dateMonthEarliest = eventDto.getDateMonthEarliest();
        this.dateYearEarliest = eventDto.getDateDayEarliest();
        this.dateDayLatest = eventDto.getDateDayLatest();
        this.dateMonthLatest = eventDto.getDateMonthLatest();
        this.dateYearLatest = eventDto.getDateYearLatest();
        this.answers = eventDto.getAnswers()
                .stream().map(element -> new Eventanswers(element))
                .collect(Collectors.toList());
    }
}

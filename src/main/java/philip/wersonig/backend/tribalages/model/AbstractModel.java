package philip.wersonig.backend.tribalages.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@MappedSuperclass
@Getter
public abstract class AbstractModel {
    @Id
    @GeneratedValue
    @Setter
    private Long id;

    @NotNull
    protected String identifier;

}

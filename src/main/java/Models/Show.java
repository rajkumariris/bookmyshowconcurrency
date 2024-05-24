package Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Show extends BaseModel{
    @ManyToOne
    private Movie movie;
    private Date startTime;
    private Date endTime;
    @ManyToOne
    private Screen screen;

    //for list along with enumbrted we give @elementcollection
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;
}

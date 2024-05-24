package Models;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShowSeat extends BaseModel{
    @ManyToOne
    private Show show;
    @ManyToOne
    private Seat seat;
    //@enumareted creates table of enum in db ordinal tries to give numbers of each value in enum
    @Enumerated(EnumType.ORDINAL)
    private ShowSeatStatus showSeatStatus;
}

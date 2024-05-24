package Models;

import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShowSeatType extends BaseModel {
    @ManyToOne
    private Show show;
    private SeatType seatType;
    private int price;
}

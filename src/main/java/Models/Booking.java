package Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Getter
@Setter
public class Booking extends BaseModel{
    //ticket
    @ManyToOne
    private User user;
    @ManyToMany //what if ticket get cnacelled
    private List<ShowSeat> showSeats;
    private int amount;
    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;
    private Date bookedDate;
    @OneToMany
    private List<Payment> payments;

}

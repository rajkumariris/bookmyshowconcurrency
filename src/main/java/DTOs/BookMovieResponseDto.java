package DTOs;

import Models.BookingResponseStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookMovieResponseDto {
    private  Long BookingId;
    private BookingResponseStatus bookingresponsestatus;
    private int amount;
}

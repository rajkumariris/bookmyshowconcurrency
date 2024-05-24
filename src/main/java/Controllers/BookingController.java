package Controllers;

import DTOs.BookMovieRequestDto;
import DTOs.BookMovieResponseDto;
import Models.Booking;
import Models.BookingResponseStatus;
import Services.BookingService;

import java.util.List;

public class BookingController {
    //getting bookingservice to use its method
    BookingService bookingService;


    //contrustor to use bookingservice
   public BookingController(BookingService bookingService){
        this.bookingService= bookingService;
    }

    public BookMovieResponseDto booking(BookMovieRequestDto bookMovieRequestDto){
        BookMovieResponseDto bookMovieResponseDto = new BookMovieResponseDto();
        // we put this in try block bcoz inside service we are throwing some exceptions
        // like userexception, showseatnotavailable and so on..
      try {
          //calling that method and getting booking resposnee
          Booking booking = bookingService.bookMovie(bookMovieRequestDto.getUserid(),
                  bookMovieRequestDto.getShowid(), bookMovieRequestDto.getShowseatId());


          // from that booking object taking whatever needed and put it in bookresponse dto

          bookMovieResponseDto.setBookingId(booking.getId());
          bookMovieResponseDto.setAmount(booking.getAmount());
          bookMovieResponseDto.setBookingresponsestatus(BookingResponseStatus.CONFIRMED);
      }
      catch(Exception exception){

          bookMovieResponseDto.setBookingresponsestatus(BookingResponseStatus.FAILED);

      }

       return bookMovieResponseDto;
    }
}

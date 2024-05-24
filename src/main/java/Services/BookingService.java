package Services;

import Exceptions.InvalidShowException;
import Exceptions.ShowSeatNotAvailable;
import Exceptions.UserException;
import Models.*;
import Repositories.ShowRepository;
import Repositories.ShowSeatRepository;
import Repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.transaction.annotation.Isolation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class BookingService {

    UserRepository userRepository;
    ShowRepository showRepository;
    ShowSeatRepository showSeatRepository;

    PriceCalculatorService priceCalculatorService;

    public BookingService(UserRepository userRepository,
                          ShowRepository showRepository,
                          ShowSeatRepository showSeatRepository,
                          PriceCalculatorService priceCalculatorService
    ){
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.priceCalculatorService = priceCalculatorService;
    }

    //here type is booking bcoz this service can be called
    // by many controller so we shouldnt tight couple
    //@Transactional(isolation= Isolation.SERIALIZABLE)
    public Booking bookMovie(Long userId, Long ShowId, List<Long> showseatId){
        User bookedBy;
        //optional bcoz user might not present in db
      Optional<User> optionalUser =   userRepository.findById(userId);
        if(optionalUser.isEmpty()){
            throw new UserException("invaid user");
        }
        else{
             bookedBy = optionalUser.get();

        }

        Optional<Show> optionalShow = showRepository.findById(ShowId);
        if(optionalShow.isEmpty()){
            throw new InvalidShowException("Invalid show");
        }

           Show bookedShow =  optionalShow.get();



        //get the list of showseats from shwoseats\
        List<ShowSeat> showSeats = showSeatRepository.findAllById(showseatId);

        // cgecking all the seats available or not
        for(ShowSeat showseat : showSeats){
            if(!showseat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new ShowSeatNotAvailable("showSeat "+ showseat.getId()+" Not Available");
            }
        }

        for(ShowSeat showSeat : showSeats){
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
          showSeatRepository.save(showSeat);
        }

        Booking booking = new Booking();
        booking.setBookingStatus(BookingStatus.IN_PROGRESS);
        booking.setUser(bookedBy);
        booking.setPayments(new ArrayList<>());
        booking.setBookedDate(new Date());
        booking.setCreatedAt(new Date());
        booking.setShowSeats(showSeats);
        booking.setAmount(priceCalculatorService.calculateprice(showSeats, bookedShow));

        return booking;
    }
}

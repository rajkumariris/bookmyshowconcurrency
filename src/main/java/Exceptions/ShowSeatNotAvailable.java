package Exceptions;

public class ShowSeatNotAvailable extends RuntimeException{

    public ShowSeatNotAvailable(String seatStatus){
        super(seatStatus);
    }
}

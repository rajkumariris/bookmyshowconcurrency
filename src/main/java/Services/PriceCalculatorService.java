package Services;

import Models.Show;
import Models.ShowSeat;
import Models.ShowSeatType;
import Repositories.ShowSeatTypeRepository;

import java.util.List;

public class PriceCalculatorService {
int amount;
    ShowSeatTypeRepository showSeatTypeRepository;

    public PriceCalculatorService(ShowSeatTypeRepository showSeatTypeRepository){
        this.showSeatTypeRepository = showSeatTypeRepository;
    }
    public int calculateprice(List<ShowSeat> showSeats, Show show){

      List<ShowSeatType> showSeatTypes =  showSeatTypeRepository.findAllByShow(show);
     for(ShowSeat showSeat : showSeats){
         for(ShowSeatType showSeatType : showSeatTypes){
             if(showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType())){
                 amount = amount+showSeatType.getPrice();
                 break;
             }
         }
     }
     return amount;
    }
}

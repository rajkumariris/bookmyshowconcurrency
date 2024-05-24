package Repositories;

import Models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {


    @Override
    List<ShowSeat> findAllById(Iterable<Long> longs);


    // save does insert or update if exits update not exisit insert
    @Override
    ShowSeat save(ShowSeat showSeat);
}

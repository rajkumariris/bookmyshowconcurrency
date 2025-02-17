package Repositories;

import Models.Show;
import Models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType, Long> {


    List<ShowSeatType> findAllByShow(Show show);
}

package lk.sliit.hotel.dao.retaurantDAO.counterTableReservationDAO;

import lk.sliit.hotel.entity.restaurant.counterTableReservation.CounterTableReservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface CounterTableReservationDAO extends CrudRepository<CounterTableReservation,Integer> {


    @Query(value = "from CounterTableReservation t where (t.startTime between :endTime and :startTimes) or (t.endTime between :endTime and :startTimes) or (t.endTime >= :startTimes and t.startTime <= :endTime) and t.date = :date")
    Iterable<CounterTableReservation> getAllBetweenDates(@Param("startTimes") Date startTimes, @Param("endTime")Date endTime, @Param("date")Date date);

    Iterable<CounterTableReservation> findCounterTableReservationByDateEquals(Date date);

    CounterTableReservation findTopByOrderByCounterTableReserveIdDesc();


    Iterable<CounterTableReservation> findAllByTableStateEquals(String State);
}

package lk.sliit.hotel.dao.retaurantDAO.counterTableReservationDAO;

import lk.sliit.hotel.entity.restaurant.counterTableReservation.CounterTableReservation;
import lk.sliit.hotel.entity.restaurant.counterTableReservation.CounterTableReservationDetails;
import org.springframework.data.repository.CrudRepository;

public interface CounterTableReservationDetailsDAO extends CrudRepository<CounterTableReservationDetails,Integer> {
    Iterable<CounterTableReservationDetails> findAllByCounterTableReservationEquals(CounterTableReservation item);
}

package lk.sliit.hotel.dao.reservationDAO;

import lk.sliit.hotel.entity.reservation.ReservationDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ReservationDetailsDAO extends CrudRepository<ReservationDetails,Integer> {


    @Query(value = "from ReservationDetails t where (t.arrivalDate between :checkOut and :checkIn) or (t.departureDate between :checkOut and :checkIn) or (t.departureDate >= :checkIn and t.arrivalDate <= :checkOut)")
    Iterable<ReservationDetails> find(@Param("checkIn") java.util.Date checkIn, @Param("checkOut") java.util.Date checkOut);

    @Query(value = "from ReservationDetails t where (t.arrivalDate between :checkOut and :checkIn) or (t.departureDate between :checkOut and :checkIn) or (t.departureDate >= :checkIn and t.arrivalDate <= :checkOut) and t.roomId.roomType = :condition")
    Iterable<ReservationDetails> findd(@Param("checkIn") java.util.Date checkIn, @Param("checkOut") java.util.Date checkOut, @Param("condition") String condition);
}

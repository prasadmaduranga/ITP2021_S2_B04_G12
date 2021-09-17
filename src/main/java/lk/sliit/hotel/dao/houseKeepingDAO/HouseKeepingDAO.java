package lk.sliit.hotel.dao.houseKeepingDAO;

import lk.sliit.hotel.entity.houseKeeping.HotelRoom;
import org.springframework.data.repository.CrudRepository;

public interface HouseKeepingDAO extends CrudRepository<HotelRoom,Integer> {
    HotelRoom findTopByOrderByRoomIdDesc();


    Iterable<HotelRoom>  findAllByStatusEquals(String restaurant);


}

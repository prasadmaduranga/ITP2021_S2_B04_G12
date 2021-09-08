package lk.sliit.hotel.service.custom;

import lk.sliit.hotel.dto.houseKeeping.GetDateHouseKeepingDTO;
import lk.sliit.hotel.dto.houseKeeping.HotelRoomDTO;
import lk.sliit.hotel.dto.houseKeeping.LaundryDTO;
import lk.sliit.hotel.dto.reservation.CustomerDTO;
import lk.sliit.hotel.dto.reservation.ReservationDTO;
import lk.sliit.hotel.service.SuperBO;

import java.util.List;

public interface HouseKeepingBO extends SuperBO {

    void saveRoomDetails(HotelRoomDTO hotelRoomDTO);

    HotelRoomDTO findHighestRoomId();

    List<HotelRoomDTO> findRooms();


    void deleteRoomDetails(int roomId);

    HotelRoomDTO findRoomIdByID(int roomId);

    List<HotelRoomDTO> findDirtyRooms(String notCleaned);

    LaundryDTO findHighestId();
 
    LaundryDTO findLaundryOrderById(int laundryId);

    void saveLaundry(LaundryDTO laundryDTO);

    List<CustomerDTO> findCustomers();

    List<LaundryDTO> findLaundryData();

    void deleteLaundryOrder(int id);

    List<LaundryDTO> findProcessingLaundryData();

    void changeState(int id);

    List<ReservationDTO> findBill(GetDateHouseKeepingDTO getDateHouseKeepingDTO);

    void changeStateToFinished(int id);

    List<LaundryDTO> findFinishedLaundryData();

    List<ReservationDTO> findAllTodayBill();
}

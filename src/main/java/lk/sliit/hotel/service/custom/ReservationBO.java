package lk.sliit.hotel.service.custom;

import lk.sliit.hotel.dto.houseKeeping.HotelRoomDTO;
import lk.sliit.hotel.dto.reservation.CustomerDTO;
import lk.sliit.hotel.dto.reservation.FindAvailabilityDTO;
import lk.sliit.hotel.dto.reservation.ReservationDTO;
import lk.sliit.hotel.service.SuperBO;

import java.util.List;

public interface ReservationBO extends SuperBO {

    void savecustomer(CustomerDTO customerDTO);

    List<CustomerDTO> findAll();

    void deleteCustomer(int customerId);


    List<HotelRoomDTO> findAvilability(FindAvailabilityDTO findAvailabilityDTO);


    CustomerDTO findHighestOnlineCustomerId();

    void saveOnlineCustomer(CustomerDTO customerDTO);

    CustomerDTO findByUserNameAndPassword(String id, String password);

    CustomerDTO findId(int customerId);

    boolean findEmail(String email);


    ReservationDTO findTopByReservationId();

    void saveReservaation(ReservationDTO reservationDTO);

    CustomerDTO findCustomerByEmail(String email);

    void saveReservaationCounter(ReservationDTO reservationDTO);
}

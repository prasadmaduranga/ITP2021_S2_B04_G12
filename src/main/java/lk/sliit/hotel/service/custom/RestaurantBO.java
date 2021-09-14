package lk.sliit.hotel.service.custom;

import lk.sliit.hotel.dto.kitchen.FoodItemDTO;
import lk.sliit.hotel.dto.restaurant.CounterOrder.RestaurantCounterOrderDTO;
import lk.sliit.hotel.dto.restaurant.CounterTableReservation.CounterTableReservationDTO;
import lk.sliit.hotel.dto.restaurant.ResTableReservationDTO;
import lk.sliit.hotel.dto.restaurant.RestaurantTableDTO;
import lk.sliit.hotel.dto.restaurant.restaurantOnlineOrder.RestaurantOnlineOrderDTO;
//import lk.sliit.hotelManagement.dto.kitchen.FoodItemDTO;
//import lk.sliit.hotelManagement.dto.restaurant.RestaurantTableDTO;
//import lk.sliit.hotelManagement.dto.restaurant.restaurantCounterOrder.RestaurantCounterOrderDTO;
//import lk.sliit.hotelManagement.dto.restaurant.restaurantCounterTable.CounterTableReservationDTO;
//import lk.sliit.hotelManagement.dto.restaurant.restaurantOnlineOrder.RestaurantOnlineOrderDTO;
//import lk.sliit.hotelManagement.dto.restaurant.restaurantOnlineTable.OnlineTableReservationDTO;

import java.util.Date;
import java.util.List;

public interface RestaurantBO {

    RestaurantCounterOrderDTO findTopByOrderByRestIdDesc();

    void saveRestaurantOrder(RestaurantCounterOrderDTO restaurantCounterOrderDTO);

    List<FoodItemDTO> findAllFoodItems(String restaurant);



    List<RestaurantTableDTO> findAllTable();


    List<RestaurantTableDTO> getAviTables(Date date, Date startTime, Date endTime);

    RestaurantTableDTO findHighestTableId();

    void saveTable(RestaurantTableDTO restaurantTableDTO);

    void deleteTable(int tableId);

    RestaurantTableDTO findTableById(int tableId);

    CounterTableReservationDTO findHighestCounterTableId();

    List<CounterTableReservationDTO> getBookedTables();

    void saveCounterTableId(CounterTableReservationDTO onlineOrderDTO);



    RestaurantOnlineOrderDTO findHighestOnlineOrderId();

    void saveOnlineOrder(RestaurantOnlineOrderDTO onlineOrderDTO);

    List<RestaurantOnlineOrderDTO> findOrderOnline();



// OnlineTableReservationDTO findHighestOnlineTableId();

//    void saveOnlineTableId(OnlineTableReservationDTO onlineOrderDTO);
//

//    List<OnlineTableReservationDTO> findTablesOnline();







    List<ResTableReservationDTO> getCounterTableReservationByDate(Date date);

    boolean taketableRese(ResTableReservationDTO order);

    void confirmtableRese(ResTableReservationDTO orderDTO);

    List<ResTableReservationDTO> findReportData(Date date);

}

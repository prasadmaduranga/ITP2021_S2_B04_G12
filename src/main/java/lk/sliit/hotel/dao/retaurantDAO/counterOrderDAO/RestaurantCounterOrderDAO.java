package lk.sliit.hotel.dao.retaurantDAO.counterOrderDAO;

import lk.sliit.hotel.entity.restaurant.counterOrder.RestaurantCounterOrder;
//import lk.sliit.hotelManagement.entity.restaurant.counterOrder.RestaurantCounterOrder;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;

public interface RestaurantCounterOrderDAO extends CrudRepository<RestaurantCounterOrder,Integer> {


    RestaurantCounterOrder findTopByOrderByOrderIdDesc();


    Iterable<RestaurantCounterOrder> findAllByOrderIdEquals(int orderId);

    Iterable<RestaurantCounterOrder> findAllByDateEquals(Date date);

    Iterable<RestaurantCounterOrder> findAllByOrderStateEquals(String state);

}

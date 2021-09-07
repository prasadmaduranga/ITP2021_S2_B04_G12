package lk.sliit.hotel.dao.retaurantDAO.counterOrderDAO;

import lk.sliit.hotel.entity.restaurant.counterOrder.RestaurantCounterOrder;
import lk.sliit.hotel.entity.restaurant.counterOrder.RestaurantCounterOrderDetail;
//import lk.sliit.hotelManagement.entity.restaurant.counterOrder.RestaurantCounterOrder;
//import lk.sliit.hotelManagement.entity.restaurant.counterOrder.RestaurantCounterOrderDetail;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantCounterOrderDetailDAO extends CrudRepository<RestaurantCounterOrderDetail,Integer> {

    Iterable<RestaurantCounterOrderDetail> findAllByRestaurantCounterOrderEquals(RestaurantCounterOrder item);
}

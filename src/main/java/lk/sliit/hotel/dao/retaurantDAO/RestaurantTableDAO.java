package lk.sliit.hotel.dao.retaurantDAO;

import lk.sliit.hotel.entity.restaurant.RestaurantTable;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantTableDAO extends CrudRepository<RestaurantTable,Integer> {

    RestaurantTable findTopByOrderByTableIdDesc();
}

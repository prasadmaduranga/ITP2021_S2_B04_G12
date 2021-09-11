package lk.sliit.hotel.dao.barDAO;

import lk.sliit.hotel.entity.bar.BarOrders;
import org.springframework.data.repository.CrudRepository;

public interface BarOrdersDAO extends CrudRepository<BarOrders,Integer> {
    BarOrders findTopByOrderByOrderIdDesc();

}

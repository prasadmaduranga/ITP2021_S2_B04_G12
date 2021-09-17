package lk.sliit.hotel.dao.houseKeepingDAO;

import lk.sliit.hotel.entity.houseKeeping.LaundryOrders;
import org.springframework.data.repository.CrudRepository;

public interface LaundryOrderDAO extends CrudRepository<LaundryOrders,Integer> {

    LaundryOrders findTopByOrderByLaundryIdDesc();

    Iterable<LaundryOrders> findAllByStateEquals(String accept);
}

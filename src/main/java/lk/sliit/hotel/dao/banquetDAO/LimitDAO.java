package lk.sliit.hotel.dao.banquetDAO;

import lk.sliit.hotel.entity.banquet.OrderLimit;
import org.springframework.data.repository.CrudRepository;

public interface LimitDAO extends CrudRepository<OrderLimit,Integer> {

}

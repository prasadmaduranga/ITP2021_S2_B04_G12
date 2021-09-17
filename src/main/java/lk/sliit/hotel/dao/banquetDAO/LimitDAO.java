package lk.sliit.hotel.dao.banquetDAO;

import lk.sliit.hotel.entity.banquet.OrderLimit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface LimitDAO extends CrudRepository<OrderLimit,Integer> {
    @Query(value = "select MAX(limitId) from OrderLimit")
    Integer findMaxLimitId();

    OrderLimit findOrderLimitByOrderLimitEquals(double orderLimit);

    OrderLimit findOrderLimitByLimitNameEquals(String limitName);

}

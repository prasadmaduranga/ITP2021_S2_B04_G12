package lk.sliit.hotel.dao.banquetDAO;

import lk.sliit.hotel.entity.banquet.BanquetCustomer;
import org.springframework.data.repository.CrudRepository;

public interface BanquetCustomerDAO extends CrudRepository<BanquetCustomer, Integer> {

    BanquetCustomer findTopByOrderByCustomerIdDesc();

}

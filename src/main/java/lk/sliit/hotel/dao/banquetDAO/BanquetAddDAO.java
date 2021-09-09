package lk.sliit.hotel.dao.banquetDAO;

import lk.sliit.hotel.entity.banquet.BanquetOrder;
import org.springframework.data.repository.CrudRepository;

public interface BanquetAddDAO extends CrudRepository<BanquetOrder,Integer>{


    BanquetOrder findTopByOrderByOrderIdDesc();

}


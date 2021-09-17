package lk.sliit.hotel.dao.banquetDAO;

import lk.sliit.hotel.entity.banquet.BanquetOrder;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;

public interface BanquetOrderDAO extends CrudRepository<BanquetOrder, Integer> {

    BanquetOrder findTopByOrderByOrderIdDesc();

    int countBanquetOrderByDateEquals(Date date);

    int countBanquetOrderByDateEqualsAndHallIdEquals(Date date, String hallNo);
}

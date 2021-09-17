package lk.sliit.hotel.dao.barDAO;

import lk.sliit.hotel.entity.bar.BarOrderDetails;
import org.springframework.data.repository.CrudRepository;

public interface BarOrdersDetailsDAO extends CrudRepository<BarOrderDetails,Integer> {
}

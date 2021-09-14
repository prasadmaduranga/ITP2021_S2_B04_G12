package lk.sliit.hotel.dao.inventoryDAO;

import lk.sliit.hotel.entity.inventory.InventoryOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface InventoryOrderDAO extends CrudRepository<InventoryOrder,Integer> {

    InventoryOrder findTopByOrderByOrderIdDesc();


    Iterable<InventoryOrder> findAllByDateEquals(Date date );
    Iterable<InventoryOrder> findAllByDateBetween(Date date , Date date2);
}

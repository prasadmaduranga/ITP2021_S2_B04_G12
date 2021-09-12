package lk.sliit.hotel.dao.inventoryDAO;

import lk.sliit.hotelManagement.entity.inventory.ItemType;
import org.springframework.data.repository.CrudRepository;

public interface ItemTypeDAO extends CrudRepository<ItemType,Integer> {
    ItemType findTopByOrderByIdDesc();
}

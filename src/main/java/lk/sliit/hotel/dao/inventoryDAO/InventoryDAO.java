package lk.sliit.hotel.dao.inventoryDAO;


import lk.sliit.hotel.entity.inventory.Inventory;
import org.springframework.data.repository.CrudRepository;

public interface InventoryDAO extends CrudRepository<Inventory,Integer> {
    Iterable<Inventory> findAllByTypeEquals(String name);

    Inventory findTopByOrderByInventoryIdDesc();


}

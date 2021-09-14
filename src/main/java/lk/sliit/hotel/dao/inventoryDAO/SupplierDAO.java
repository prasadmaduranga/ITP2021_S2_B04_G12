package lk.sliit.hotel.dao.inventoryDAO;

import lk.sliit.hotel.entity.inventory.Supplier;
import org.springframework.data.repository.CrudRepository;

public interface SupplierDAO extends CrudRepository<Supplier,Integer> {
    Supplier findTopByOrderByIdDesc();
}

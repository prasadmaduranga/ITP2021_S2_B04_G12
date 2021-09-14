package lk.sliit.hotel.dao.inventoryDAO;
<<<<<<< HEAD

import lk.sliit.hotel.entity.inventory.Supplier;
=======


>>>>>>> b0b28eb4af433e6942fd01fd7d048cb0e872effc
import org.springframework.data.repository.CrudRepository;

import java.util.function.Supplier;

public interface SupplierDAO extends CrudRepository<Supplier,Integer> {
    Supplier findTopByOrderByIdDesc();
}

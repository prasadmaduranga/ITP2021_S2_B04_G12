package lk.sliit.hotel.dao.inventoryDAO;


import org.springframework.data.repository.CrudRepository;

import java.util.function.Supplier;

public interface SupplierDAO extends CrudRepository<Supplier,Integer> {
    Supplier findTopByOrderByIdDesc();
}

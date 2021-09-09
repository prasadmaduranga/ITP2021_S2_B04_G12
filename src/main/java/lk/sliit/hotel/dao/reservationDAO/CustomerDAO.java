package lk.sliit.hotel.dao.reservationDAO;

import lk.sliit.hotel.entity.reservation.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerDAO extends CrudRepository<Customer,Integer> {
    Customer findTopByOrderByCustomerIdDesc();

    Iterable<Customer> findAllByStateEquals(String state);

    Customer findByEmailAndPassword(String email, String password);

    Customer findCustomerByEmailEquals(String email);
}

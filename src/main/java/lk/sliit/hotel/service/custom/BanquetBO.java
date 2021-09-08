package lk.sliit.hotel.service.custom;

import lk.sliit.hotel.dto.banquet.BanquetOrderDTO;
import lk.sliit.hotel.dto.reservation.CustomerDTO;

import java.util.List;

public interface BanquetBO {


    BanquetOrderDTO findTopBanquetId();

    List<CustomerDTO> findAllCustomer();

    // CustomerDTO findTopCustomerId();
}

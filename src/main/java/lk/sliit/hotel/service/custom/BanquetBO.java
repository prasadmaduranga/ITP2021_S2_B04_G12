package lk.sliit.hotel.service.custom;

import lk.sliit.hotel.dto.banquet.BanquetAddDTO;
import lk.sliit.hotel.dto.banquet.BanquetOrderDTO;
import lk.sliit.hotel.dto.reservation.CustomerDTO;

import java.util.List;

public interface BanquetBO {


    BanquetOrderDTO findTopBanquetId();

    List<CustomerDTO> findAllCustomer();

    List<BanquetAddDTO> findBanquetBill();

    // CustomerDTO findTopCustomerId();
}

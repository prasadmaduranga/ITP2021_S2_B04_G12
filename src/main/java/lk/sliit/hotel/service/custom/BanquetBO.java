package lk.sliit.hotel.service.custom;

import lk.sliit.hotel.dto.banquet.BanquetAddDTO;
import lk.sliit.hotel.dto.banquet.BanquetCustomerDTO;
import lk.sliit.hotel.dto.banquet.BanquetOrderDTO;

import lk.sliit.hotel.service.SuperBO;

import java.util.List;

public interface BanquetBO extends SuperBO {


    BanquetOrderDTO findTopBanquetId();

    List<BanquetAddDTO> findBanquetBill();

    BanquetCustomerDTO findTopBanquetCustomerId();
}

package lk.sliit.hotel.service.custom;

import lk.sliit.hotel.dto.banquet.BanquetAddDTO;
import lk.sliit.hotel.dto.banquet.BanquetBillDTO;
import lk.sliit.hotel.dto.banquet.BanquetCustomerDTO;
import lk.sliit.hotel.dto.banquet.BanquetOrderDTO;

import lk.sliit.hotel.service.SuperBO;

import java.sql.Date;
import java.util.List;

public interface BanquetBO extends SuperBO {

    BanquetOrderDTO findTopBanquetId();

    BanquetCustomerDTO findTopCustomerId();

    void saveBanquet(BanquetAddDTO banquetAddDTO);


    int checkAvailability(Date date);

    int checkHallOneAvailability(Date date);

    int checkHallTwoAvailabilityCheck(Date date);

    List<BanquetAddDTO> findBanquetBill();
}

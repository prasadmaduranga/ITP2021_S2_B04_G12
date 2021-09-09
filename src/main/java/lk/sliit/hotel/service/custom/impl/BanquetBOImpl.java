package lk.sliit.hotel.service.custom.impl;

import lk.sliit.hotel.dao.banquetDAO.BanquetAddDAO;
import lk.sliit.hotel.dto.banquet.BanquetAddDTO;
import lk.sliit.hotel.dto.banquet.BanquetOrderDTO;
import lk.sliit.hotel.dto.reservation.CustomerDTO;
import lk.sliit.hotel.entity.banquet.BanquetOrder;
import lk.sliit.hotel.service.custom.BanquetBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BanquetBOImpl implements BanquetBO {

    @Autowired
    BanquetAddDAO banquetOrderDAO; // Inject the BanquetOrderDAO

    @Autowired
   // CustomerDao customerDao; //Inject the CustomerDao


    @Override
    public BanquetOrderDTO findTopBanquetId() {
        BanquetOrder banquetOrder = banquetOrderDAO.findTopByOrderByOrderIdDesc();
        return new BanquetOrderDTO(
                banquetOrder.getOrderId()
        );
    }

    @Override
    public List<CustomerDTO> findAllCustomer() {
        return null;
    }

    @Override
    public List<BanquetAddDTO> findBanquetBill() {
        return null;
    }

//    @Override
//    public CustomerDTO findTopCustomerId() {
//
//
//
//    }
//
}

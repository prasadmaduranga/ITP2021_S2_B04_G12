package lk.sliit.hotel.service.custom.impl;

import lk.sliit.hotel.dao.banquetDAO.BanquetBillDAO;
import lk.sliit.hotel.dao.banquetDAO.BanquetCustomerDAO;
import lk.sliit.hotel.dao.banquetDAO.BanquetOrderDAO;
import lk.sliit.hotel.dto.banquet.BanquetAddDTO;
import lk.sliit.hotel.dto.banquet.BanquetCustomerDTO;
import lk.sliit.hotel.dto.banquet.BanquetOrderDTO;
import lk.sliit.hotel.entity.banquet.BanquetCustomer;
import lk.sliit.hotel.entity.banquet.BanquetOrder;
import lk.sliit.hotel.service.custom.BanquetBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BanquetBOImpl implements BanquetBO {

    @Autowired
    BanquetOrderDAO banquetOrderDAO;

    @Autowired
    BanquetCustomerDAO banquetCustomerDAO;

//    @Autowired
//    MenuDAO menuDAO;

    @Autowired
    BanquetBillDAO banquetBillDAO;


    //Find top banquet Id
    @Override
    public BanquetOrderDTO findTopBanquetId() {

        BanquetOrder banquetOrder = banquetOrderDAO.findTopByOrderByOrderIdDesc();
        return new BanquetOrderDTO(
                banquetOrder.getOrderId()
        );
    }

    //Find top customer Id
    @Override
    public BanquetCustomerDTO findTopCustomerId() {
        BanquetCustomer banquetCustomer = banquetCustomerDAO.findTopByOrderByCustomerIdDesc();
        return new BanquetCustomerDTO(
                banquetCustomer.getCustomerId()
        );
    }

    //Banquet detail save
    @Override
    public void saveBanquet(BanquetAddDTO banquetAddDTO) {

        //setting the pending status
        String status= "Pending";
        banquetAddDTO.setOrderState(status);

        //setting the submitted name
        String name = "Janani Madushika";
        banquetAddDTO.setSubmittedBy(name);

        //save banquet orders
        banquetOrderDAO.save(new BanquetOrder(
                banquetAddDTO.getOrderId(),
                banquetAddDTO.getHallId(),
                banquetAddDTO.getOrderState(),
                banquetAddDTO.getNoOfPlates(),
                banquetAddDTO.getDate(),
                banquetAddDTO.getSubmittedBy(),
                banquetCustomerDAO.findOne(banquetAddDTO.getCustomerId()),
                menuDAO.findOne(banquetAddDTO.getMenuId()),
                banquetBillDAO.findOne(banquetAddDTO.getBanquetBillId())

        ));

        //save customer detail
        banquetCustomerDAO.save(new BanquetCustomer(
                banquetAddDTO.getCustomerId(),
                banquetAddDTO.getEmail(),
                banquetAddDTO.getName(),
                banquetAddDTO.getAddress(),
                banquetAddDTO.getContactNumber()
        ));

    }

}

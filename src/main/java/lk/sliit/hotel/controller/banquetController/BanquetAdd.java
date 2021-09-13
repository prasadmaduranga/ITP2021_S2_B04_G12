package lk.sliit.hotel.controller.banquetController;


import lk.sliit.hotel.controller.SuperController;
import lk.sliit.hotel.dto.banquet.BanquetAddDTO;
import lk.sliit.hotel.dto.banquet.BanquetCustomerDTO;
import lk.sliit.hotel.dto.banquet.BanquetOrderDTO;
import lk.sliit.hotel.dto.reservation.CustomerDTO;
import lk.sliit.hotel.service.custom.BanquetBO;
import lk.sliit.hotel.service.custom.IndexLoginBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BanquetAdd {

    @Autowired
    private BanquetBO banquetBO;

    @Autowired
    private IndexLoginBO indexLoginBO;


    @GetMapping("banquetAdd")
    public ModelAndView loginPage(Model model){
        ModelAndView mv = new ModelAndView("banquetAdd");
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        try {
            BanquetOrderDTO banquetOrderDTO = banquetBO.findTopBanquetId();
            int topBanquet = (banquetOrderDTO.getOrderId()) + 1;
            model.addAttribute("topBanquetId", topBanquet);
        } catch (NullPointerException e){
            model.addAttribute("topBanquetId", 1);
        }

        try{
            BanquetCustomerDTO banquetCustomerDTO = banquetBO.findTopBanquetCustomerId();
            int topCustomer =(banquetCustomerDTO.getBanquetCustomerId() +1);
            model.addAttribute("topCustomerId",topCustomer);
        }catch(NullPointerException e){
            model.addAttribute("topCustomerId", 1);
        }

        return mv;
    }

}

package lk.sliit.hotel.controller.banquetController;


import lk.sliit.hotel.controller.SuperController;
import lk.sliit.hotel.dto.banquet.BanquetAddDTO;
import lk.sliit.hotel.dto.banquet.BanquetBillDTO;
import lk.sliit.hotel.dto.banquet.BanquetCustomerDTO;
import lk.sliit.hotel.dto.banquet.BanquetOrderDTO;
import lk.sliit.hotel.dto.reservation.CustomerDTO;
import lk.sliit.hotel.service.custom.BanquetBO;
import lk.sliit.hotel.service.custom.IndexLoginBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class BanquetAdd {
    @Autowired
    IndexLoginBO indexLoginBO;

    @Autowired
    BanquetBO banquetBO;


    @GetMapping("banquetAdd")
    public String loginPage (Model model){
        ModelAndView mv = new ModelAndView("banquetAdd"); //display banquetAdd page
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        try{
            BanquetOrderDTO banquetOrderDTO = banquetBO.findTopBanquetId();
            int topBanquet= (banquetOrderDTO.getOrderId())+1;
            model.addAttribute("topBanquetId",topBanquet);
        }catch (NullPointerException e){
            model.addAttribute("topBanquetId",1);
        }

        try{
            BanquetCustomerDTO banquetCustomerDTO = banquetBO.findTopCustomerId();
            int topCustomer = (banquetCustomerDTO.getCustomerId())+1;
            model.addAttribute("topBanquetCustomerId",topCustomer);
        }catch (NullPointerException e){
            model.addAttribute("topBanquetCustomerId",1);
        }

        return "banquetAdd";
    }

    @RequestMapping("saveBanquet")
    public ModelAndView saveForm(@ModelAttribute BanquetAddDTO banquetAddDTO , HttpServletRequest request, Model model){
        //  ModelAndView mv = new ModelAndView("saveBanquet");

        banquetBO.saveBanquet(banquetAddDTO);

        ModelAndView mv = new ModelAndView("banquetAdd"); //display banquetAdd page

        try{
            BanquetOrderDTO banquetOrderDTO = banquetBO.findTopBanquetId();
            int topBanquet= (banquetOrderDTO.getOrderId())+1;
            model.addAttribute("topBanquetId",topBanquet);
        }catch (NullPointerException e){
            model.addAttribute("topBanquetId",1);
        }

        try{
            BanquetCustomerDTO banquetCustomerDTO = banquetBO.findTopCustomerId();
            int topCustomer = (banquetCustomerDTO.getCustomerId())+1;
            model.addAttribute("topBanquetCustomerId",topCustomer);
        }catch (NullPointerException e){
            model.addAttribute("topBanquetCustomerId",1);
        }


        return mv;


    }
}



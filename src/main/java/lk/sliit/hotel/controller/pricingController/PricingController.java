package lk.sliit.hotel.controller.pricingController;

import lk.sliit.hotel.controller.SuperController;
import lk.sliit.hotel.service.custom.IndexLoginBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PricingController {
    @Autowired
    IndexLoginBO indexLoginBO;
    @GetMapping("/pricing")
    public String loginPage(Model model){
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        return "pricing";
    }
}

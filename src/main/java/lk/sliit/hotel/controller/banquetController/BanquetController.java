package lk.sliit.hotel.controller.banquetController;

import lk.sliit.hotel.controller.SuperController;
import lk.sliit.hotel.service.custom.IndexLoginBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BanquetController {
    @Autowired
    IndexLoginBO indexLoginBO;

    //Display Banquet dash board
    @GetMapping("banquet")
    public String LoginPage(Model model){
        ModelAndView mv = new ModelAndView("banquet");
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        return "banquet";
    }
}

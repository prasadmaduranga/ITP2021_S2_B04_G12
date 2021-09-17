package lk.sliit.hotel.controller.InventoryController;

import lk.sliit.hotel.controller.SuperController;
import lk.sliit.hotel.dto.inventory.GetDateInventoryDTO;
import lk.sliit.hotel.dto.inventory.InventoryOrderDTO;
import lk.sliit.hotel.service.custom.HumanResourceBO;
import lk.sliit.hotel.service.custom.IndexLoginBO;
import lk.sliit.hotel.service.custom.InventoryBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ReportsController {
    @Autowired
    IndexLoginBO indexLoginBO;
    @Autowired
    InventoryBO inventoryBO;
    @Autowired
    HumanResourceBO humanResourceBO;

    @GetMapping("/inventoryMainReport")//Main Report
    public String loginPage(Model model){
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        return "inventoryMainReport";
    }

    @PostMapping("/inventoryMainReport")//Find by date
    public ModelAndView houseKeepingReports(@ModelAttribute GetDateInventoryDTO getDateInventoryDTO, Model model ){
        ModelAndView modelAndView = new ModelAndView("inventoryMainReport");
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        List<InventoryOrderDTO> inventoryBill  =  inventoryBO.findInventoryBill(getDateInventoryDTO);
        model.addAttribute("loadInventoryBills", inventoryBill);

        return modelAndView;
    }
}


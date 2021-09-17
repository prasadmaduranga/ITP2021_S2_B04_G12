package lk.sliit.hotel.controller.InventoryController;

import lk.sliit.hotel.controller.SuperController;
import lk.sliit.hotel.dto.inventory.InventoryDTO;
import lk.sliit.hotel.dto.inventory.InventoryNoticeDTO;
import lk.sliit.hotel.dto.inventory.InventoryOrderDTO;
import lk.sliit.hotel.service.custom.IndexLoginBO;
import lk.sliit.hotel.service.custom.InventoryBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BeverageStock {
    @Autowired
    InventoryBO inventoryBO;
    @Autowired
    IndexLoginBO indexLoginBO;
    @GetMapping("/beverageStock")
    public String kitchenStock(Model model){//Load Beverage Stock Page
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        List<InventoryDTO> p3 = inventoryBO.findStockData("Beverage");//Find all stock Data
        model.addAttribute("listAllBeverageStock", p3);
        List<InventoryNoticeDTO> p = inventoryBO.stockOrderNotices("Beverage");//Stock order notice notice (1week)
        model.addAttribute("listBeverageNotice", p);
        List<InventoryOrderDTO> p1 = inventoryBO.loadInventoryOrders();// order data (1week)
        model.addAttribute("listTodayOrders", p1);
        return "beverageStock";
    }
}

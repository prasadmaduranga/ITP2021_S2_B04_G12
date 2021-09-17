package lk.sliit.hotel.controller.RestaurantController;

import lk.sliit.hotel.dto.kitchen.FoodItemDTO;
import lk.sliit.hotel.service.custom.KitchenBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class RestaurantOnlineOrder {

    @Autowired
    KitchenBO kitchenBO;

    @GetMapping("/onlineOrder")//Load Online Order Page
    public String loadForm_validationSaveMode(Model model, HttpSession session, HttpServletRequest request) {

        try {//Load Data when customer Sign In
           // int onlineCustomerId = Integer.parseInt(session.getAttribute("userId").toString());
           // model.addAttribute("loggerId", onlineCustomerBO.findOne(onlineCustomerId));
//            Load All Food
            List<FoodItemDTO> p1 = kitchenBO.findFoodItems();
            if(p1.isEmpty()){
                request.setAttribute("loginError","Not Any Item Fond Under Restaurant " +
                        "Type Please Add Data Under Restaurant Type" );
            }

            model.addAttribute("loadAllFoods", p1);
        } catch (Exception d) {
            return "onlineOrder";
        }
        return "onlineOrder";

    }
}

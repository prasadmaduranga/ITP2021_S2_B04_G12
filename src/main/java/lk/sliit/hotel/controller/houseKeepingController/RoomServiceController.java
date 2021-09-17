package lk.sliit.hotel.controller.houseKeepingController;

import lk.sliit.hotel.controller.SuperController;
import lk.sliit.hotel.dto.houseKeeping.LaundryDTO;
import lk.sliit.hotel.service.custom.HouseKeepingBO;
import lk.sliit.hotel.service.custom.HumanResourceBO;
import lk.sliit.hotel.service.custom.IndexLoginBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class RoomServiceController {

    @Autowired
    IndexLoginBO indexLoginBO;
    @Autowired
    HouseKeepingBO houseKeepingBO;
    @Autowired
    HumanResourceBO humanResourceBO;

//*************************************** Room Service Dashboard *************************************
    //Load Room Crud Page
    @GetMapping("/roomService")
    public String roomService(Model model){
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        List<LaundryDTO> laundryDTOS = houseKeepingBO.findLaundryData();
        model.addAttribute("viewAcceptedOrders", laundryDTOS);
        //Processing data
        List<LaundryDTO> viewProcessing = houseKeepingBO.findProcessingLaundryData();
        model.addAttribute("viewProcessing", viewProcessing);
        return "roomService";
    }
    //Change State In Laundry Orders
    @GetMapping(value = "processLaundryOrder2/{laundryId}")
    public void processLaundryOrder(@PathVariable("laundryId") int id,HttpServletResponse response) throws IOException {

        houseKeepingBO.changeState(id);
        response.sendRedirect("/roomService");

    }
    //Change State In Laundry Orders
    @GetMapping(value = "changeFinished/{laundryId}")
    public void changeFinished(@PathVariable("laundryId") int id,HttpServletResponse response) throws IOException {

        houseKeepingBO.changeStateToFinished(id);
        response.sendRedirect("/roomService");

    }


    //Delete Accept Orders
    @GetMapping(value = "deleteLaundryOrder2/{laundryId}")
    public void deleteLaundry(@PathVariable("laundryId") int id,HttpServletResponse response) throws IOException {

        houseKeepingBO.deleteLaundryOrder(id);
        response.sendRedirect("/roomService");

    }


}

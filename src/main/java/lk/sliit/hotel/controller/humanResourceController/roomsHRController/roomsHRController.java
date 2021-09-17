package lk.sliit.hotel.controller.humanResourceController.roomsHRController;

import lk.sliit.hotel.controller.SuperController;
import lk.sliit.hotel.dto.houseKeeping.HotelRoomDTO;
import lk.sliit.hotel.service.custom.HouseKeepingBO;
import lk.sliit.hotel.service.custom.HumanResourceBO;
import lk.sliit.hotel.service.custom.IndexLoginBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class roomsHRController {
    // automate the object creation and connect with the relevant interfaces
    @Autowired
    IndexLoginBO indexLoginBO;
    @Autowired
    HouseKeepingBO houseKeepingBO;
    @Autowired
    HumanResourceBO humanResourceBO;


    @GetMapping("/roomsHR") // load the rooms prices page with data
    public String roomsHR(Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        List<HotelRoomDTO> hotelRoomDTOList = houseKeepingBO.findRooms();
        model.addAttribute("loadRoomTable", hotelRoomDTOList);
        return "roomsHR";
    }

    @PostMapping("/updateRoomHR") // update rooms prices
    public String updateRoomHR(@ModelAttribute HotelRoomDTO hotelRoomDTO, Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        hotelRoomDTO.setHolder(SuperController.idNo); // get hotel room id
        HotelRoomDTO hotelRoomDTO1 = null;
        try { // get room details
            hotelRoomDTO1 = houseKeepingBO.findRoomIdByID(hotelRoomDTO.getRoomId2());
            hotelRoomDTO.setDate(hotelRoomDTO1.getDate());
            hotelRoomDTO.setStatus(hotelRoomDTO1.getStatus());
            hotelRoomDTO.setRoomType(hotelRoomDTO1.getType());
        }catch (NullPointerException d){
            return "redirect:/roomsHR";
        }
        humanResourceBO.updateRoomHR(hotelRoomDTO);
        return "redirect:/roomsHR";
    }
}

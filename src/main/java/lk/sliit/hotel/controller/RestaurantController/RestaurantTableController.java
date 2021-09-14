package lk.sliit.hotel.controller.RestaurantController;

import lk.sliit.hotel.controller.SuperController;
import lk.sliit.hotel.dto.restaurant.CounterTableReservation.CounterTableReservationDTO;
import lk.sliit.hotel.dto.restaurant.ResTableDTO;
import lk.sliit.hotel.dto.restaurant.ResTableReservationDTO;
import lk.sliit.hotel.dto.restaurant.RestaurantTableDTO;
import lk.sliit.hotel.service.custom.IndexLoginBO;
import lk.sliit.hotel.service.custom.RestaurantBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RestaurantTableController {

    @Autowired
    IndexLoginBO indexLoginBO;

    @Autowired
    RestaurantBO restaurantBO;

    String alertMsg=null;

    //get all tables
    @GetMapping("/restaurantTable")
    public String loginPage(Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        List<RestaurantTableDTO> tableList = restaurantBO.findAllTable();
        model.addAttribute("loadAllTablesTable", tableList);
        return "restaurantTable";
    }

    //save tables
    @PostMapping("/saveTable")
    public String addNewTable(Model model, @ModelAttribute RestaurantTableDTO restaurantTableDTO) {
        try {
            RestaurantTableDTO tableDTO1 = restaurantBO.findHighestTableId();//Find highest Id
            RestaurantTableDTO tableDTO2 = null;
            try {
                tableDTO2 = restaurantBO.findTableById(restaurantTableDTO.getTableId());//find One
            } catch (NullPointerException d) {
                int maxId = (tableDTO1.getTableId());
                if (restaurantTableDTO.getTableId() == (maxId)) {//Update
                    restaurantTableDTO.setTableId((maxId));
                } else {//New Table
                    maxId++;
                    restaurantTableDTO.setTableId((maxId));
                }
            }

        } catch (NullPointerException e) {//Initial Round
            restaurantTableDTO.setTableId(1);
        }

        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        restaurantBO.saveTable(restaurantTableDTO);//Save Table
        return "redirect:/restaurantTable";
    }

    //delete tables
    @GetMapping(value = "deleteTable/{tableId}")
    public void deleteTable(@PathVariable("tableId") int tableId, HttpServletResponse response) {
        restaurantBO.deleteTable(tableId);
        try {
            response.sendRedirect("/restaurantTable");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //get todays all reservations
    @GetMapping("/restaurantTableIndex")
    public String restaurantTableIndex(Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        List<CounterTableReservationDTO> p2 = restaurantBO.getBookedTables();
        model.addAttribute("todayBookedTables", p2);
        return "restaurantTableIndex";
    }

    //load reservation form jsp
    @GetMapping("/restaurantTableReservation")
    public String restaurantTableReservation(Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        return "restaurantTableReservation";
    }

    //get all not booking tables
    @GetMapping("/counterTableDetails")//Find Available Tables
    public String checkTimeForTable(@ModelAttribute CounterTableReservationDTO counterTableReservationDTO,
                                    Model model) {
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        Time a = Time.valueOf(counterTableReservationDTO.getvStatT()+":00");//convert time to Time type
        Time a2 = Time.valueOf(counterTableReservationDTO.getvEndT()+":00");
        counterTableReservationDTO.setStartTime(a);//Time set to dto
        counterTableReservationDTO.setEndTime(a2);
        Date date = Date.valueOf(counterTableReservationDTO.getvDate());//Set Date
        counterTableReservationDTO.setDate(date);
        model.addAttribute("reservedDate", (counterTableReservationDTO.getDate()));//Set Values to next Page
        model.addAttribute("timeIn", (counterTableReservationDTO.getStartTime()));
        model.addAttribute("timeOut", (counterTableReservationDTO.getEndTime()));
        List<RestaurantTableDTO> p2 =restaurantBO.getAviTables(counterTableReservationDTO.getDate(),//Find available
                counterTableReservationDTO.getStartTime(),counterTableReservationDTO.getEndTime());
        model.addAttribute("loadAllTable", p2);
        return "counterTableDetails";
    }

//save reservation
    @PostMapping("/saveCounterTable")
    public String saveOnlineTable(@ModelAttribute CounterTableReservationDTO onlineOrderDTO, HttpSession session) {

        try {
            Time a = Time.valueOf(onlineOrderDTO.getvStatT());//Get time and
            Time a2 = Time.valueOf(onlineOrderDTO.getvEndT());
            onlineOrderDTO.setStartTime(a);// set time to time type
            onlineOrderDTO.setEndTime(a2);
            Date date = Date.valueOf(onlineOrderDTO.getvDate());
            onlineOrderDTO.setDate(date);
        }catch (IllegalArgumentException s){}
        try {
            //find highest Id
            CounterTableReservationDTO top = restaurantBO.findHighestCounterTableId();
            int x = (top.getCounterTableReserveId()) + 1;
            onlineOrderDTO.setCounterTableReserveId((x));
        } catch (NullPointerException e) {//If not found any Id

            onlineOrderDTO.setCounterTableReserveId((1));
        }
        try {
            restaurantBO.saveCounterTableId(onlineOrderDTO);//SAve
        } catch (NullPointerException d) {
            return "redirect:/restaurantTableReservation";
        }
        return "redirect:/restaurantTableReservation";
    }

    //load resTabManage.jsp to control the state of the reserving
    @GetMapping("/tableManage")
    public String restaurantTableIndexk(Model model) {
        model = gettableModel(model);
        return "restaurantTableManage";
    }

    //create model to store reservation details
    public Model gettableModel(Model model) {
        List<ResTableReservationDTO> counterOrders =restaurantBO.getCounterTableReservationByDate(new java.util.Date());
        // List<ResTableReservationDTO> couterOrders = kitchenBO.getCounterRestaurantFoodOrdersByDate(new java.util.Date());

        //set order table data
        //model.addAttribute("onlineOrders", onlineOrders);
        // model.addAttribute("pendingOnline", onlineOrders.size());
        model.addAttribute("counterOrders",counterOrders );
        model.addAttribute("pendingCounter", counterOrders.size());
        // model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

//        if (onlineOrders.size() == 0 && couterOrders.size() == 0){
//            alertMsg = "Pending restaurant order list is empty";
//            model.addAttribute(KitchenUtil.alertMessageName, alertMsg);
//            alertMsg = null;
//        }
//
        return model;
    }

    //when click button type input this method will execute
    @PostMapping("/confirmTable")
    public String confirmOrder(Model model, @ModelAttribute ResTableReservationDTO orderDTO) {

        // model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        //check button
        if (orderDTO.getButton().equals(TableUtil.accept)){
            //check state
            if (orderDTO.getState().equals(TableUtil.pendingState)) {
                //take order
                if (!restaurantBO.taketableRese(orderDTO)) {
                    alertMsg = "Reservation is already released";
                }
            }
        } else if (orderDTO.getButton().equals(TableUtil.confirm)){
            restaurantBO.confirmtableRese(orderDTO);
            alertMsg = "Reservation id: "+orderDTO.getReseId()+" Released";

        } else if (!orderDTO.getButton().equals(TableUtil.confirm)
                && !orderDTO.getButton().equals(TableUtil.accept)){
            alertMsg = "Please select the first reservation.";
        }

        model = gettableModel(model);

        if (alertMsg != null){
            model.addAttribute(TableUtil.alertMessageName, alertMsg);
        }

        return "restaurantTableManage";
    }

    //restaurant table reservation report
    @GetMapping("/RestaurantReport")
    public String loadKitchenReport(Model model) {
        alertMsg = null;
        model.addAttribute("alert", alertMsg);
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        List<ResTableReservationDTO> allFinishedOrders = restaurantBO.findReportData(new java.util.Date());
        List<ResTableDTO> onlineItems = new ArrayList<>();
        List<ResTableDTO> counterItems = new ArrayList<>();
        List<ResTableDTO> finalList = new ArrayList<>();

        //model variables for calculations
        int totaltableItemsSold = 0;
        int totalOnlinetableItemsSold = 0;
        int totalCountertableItemsSold = 0;
        double totalOnlinetableIncome = 0;
        double totalCountertableIncome = 0;
        double totalIncome = 0;

        if (!allFinishedOrders.isEmpty()){
            for (ResTableReservationDTO order: allFinishedOrders){

                System.out.println("======================================================\n\n");
                System.out.println(order.getType()+"\n");
                for (ResTableDTO item: order.getTables()){
                    System.out.println("ID: "+item.getTableId());
                    //System.out.println("Name: "+item.getFoodName());
                    System.out.println("Quantity: "+item.getQuantity());
                    System.out.println("Price"+item.getPrice());
                    System.out.println("Total price: "+item.getTotalPrice());

                }

                System.out.println("======================================================\n\n");


                //////////////////////////////////////////////


//                if (order.getType().equals(KitchenUtil.counterType)){
//
//                    onlineItems = order.getTables();
//
//                    //calc total item sold
//                    if (!onlineItems.isEmpty()){
//
//                        for (RestaurantFoodItemDTO itemDTO : onlineItems){
//                            totalOnlineItemsSold += itemDTO.getQuantity();
//                            totalOnlineIncome += itemDTO.getTotalPrice();
//                        }
//
//                        //set selling rates
//                        for (RestaurantFoodItemDTO itemDTO : onlineItems){
//                            itemDTO.setSellingRateOnline(Math.round(((itemDTO.getQuantity() / totalOnlineItemsSold) * 100)));
//                        }
//
//                    }
//

                if (order.getType().equals(TableUtil.counterType)){

                    counterItems = order.getTables();

                    //calc total item sold
                    if (!counterItems.isEmpty()){

                        for (ResTableDTO itemDTO : counterItems){
                            totalCountertableItemsSold += itemDTO.getQuantity();
                            totalCountertableIncome += itemDTO.getTotalPrice();
                        }

                        //set selling rates
                        for (ResTableDTO itemDTO : counterItems){
                            itemDTO.setSellingRateCounter(Math.round((itemDTO.getQuantity() / totalCountertableItemsSold) * 100));
                        }
                    }
                }
            }

            totalIncome = totalCountertableIncome + totalOnlinetableIncome;
            totaltableItemsSold = totalCountertableItemsSold + totalOnlinetableItemsSold;

            if (!onlineItems.isEmpty()){
                finalList.addAll(onlineItems);

                if (!counterItems.isEmpty()){
                    for (ResTableDTO counterItem: counterItems){
                        for (ResTableDTO list:finalList){
                            if (counterItem.getTableId() == list.getTableId()){
                                list.setSellingRateCounter(counterItem.getSellingRateCounter());
                                list.setQuantity(list.getQuantity() + counterItem.getQuantity());
                            }
                        }
                    }
                } else {
                    for (ResTableDTO itemDTO:finalList){
                        itemDTO.setSellingRateCounter(0);
                    }
                }
            } else {
                finalList.addAll(counterItems);

                for (ResTableDTO itemDTO:finalList){
                    itemDTO.setSellingRateOnline(0);
                }
            }

        }



        model.addAttribute("table", finalList);
        model.addAttribute("totaltableItemsSold",totaltableItemsSold);
        model.addAttribute("totaltableOnline", totalOnlinetableItemsSold);
        model.addAttribute("totaltableCounter", totalCountertableItemsSold);
        model.addAttribute("totalCountertableIncome", totalCountertableIncome);
        model.addAttribute("totalOnlinetableIncome", totalOnlinetableIncome);
        model.addAttribute("totalIncome", totalIncome);

        return "restaurantTableResReport";
    }


}

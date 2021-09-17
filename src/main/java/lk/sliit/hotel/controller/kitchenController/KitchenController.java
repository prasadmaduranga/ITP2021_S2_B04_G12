package lk.sliit.hotel.controller.kitchenController;

import lk.sliit.hotel.controller.SuperController;
import lk.sliit.hotel.dto.banquet.LimitDTO;
import lk.sliit.hotel.dto.inventory.InventoryDTO;
import lk.sliit.hotel.dto.inventory.InventoryNoticeDTO;
import lk.sliit.hotel.dto.kitchen.*;
import lk.sliit.hotel.service.custom.IndexLoginBO;
import lk.sliit.hotel.service.custom.InventoryBO;
import lk.sliit.hotel.service.custom.KitchenBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Controller
public class KitchenController {
    @Autowired
    IndexLoginBO indexLoginBO;

    @Autowired
    KitchenBO kitchenBO;

    @Autowired
    InventoryBO inventoryBO;
    String alertMsg = null;

    @GetMapping("/kitchen")
    public String loginPage(Model model) {

        model = getKitchenModel(model);
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        model.addAttribute(KitchenUtil.alertMessageName, alertMsg);
        alertMsg = null;
        return "kitchen";
    }

    @GetMapping("/kitchenNoAlert")
    public String backToKitchenNoAlerts(Model model){
        model = getKitchenModel(model);
        model.addAttribute(KitchenUtil.alertMessageName,null);
        return "kitchen";
    }

    @PostMapping("/kitchen")
    public void addDailyKitchenFoodOrder(Model model, @ModelAttribute KitchenFoodOrderDTO kitchenFoodOrderDTO, HttpServletResponse response) {
        alertMsg = null;
        model.addAttribute(KitchenUtil.alertMessageName, alertMsg);
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        // validate date
        if (chckOldDate(kitchenFoodOrderDTO.getExpectedDate())) {

            //check amount
            if (kitchenFoodOrderDTO.getAmount() > 0){

                //create inventory notice object
                InventoryNoticeDTO inventoryNoticeDTO = new InventoryNoticeDTO();
                KitchenInventoryNoticeDTO kitchenNotice;

                //set values to Inventory notice
                inventoryNoticeDTO.setDepartment(KitchenUtil.department);
                inventoryNoticeDTO.setDate(getTodaySql());
                inventoryNoticeDTO.setExpDate(kitchenFoodOrderDTO.getExpectedDate());
                inventoryNoticeDTO.setOrderHolder(SuperController.idNo);
                inventoryNoticeDTO.setState(false);
                inventoryNoticeDTO.setInventory(kitchenFoodOrderDTO.getFoodItemId());
                inventoryNoticeDTO.setOrderQty(0);

                //save data
                int noticeId = kitchenBO.saveInventoryNotice(inventoryNoticeDTO);
                inventoryNoticeDTO.setNoticeId(noticeId);

                //set kitchenFoodOrder description
                kitchenFoodOrderDTO.setDescription(kitchenFoodOrderDTO.getDescription() + KitchenUtil.stringSeperator + noticeId);

                try {

                    KitchenInventoryNoticeDTO existingNotice = kitchenBO.findInventoryNotice(
                            inventoryNoticeDTO.getExpDate(),
                            inventoryNoticeDTO.getInventoryId(),
                            inventoryNoticeDTO.isState()
                    );

                    try {
                        //search existing order
                        KitchenFoodOrderDTO old = kitchenBO.getExistingKitchenFoodOrder(
                                kitchenFoodOrderDTO.getFoodItemId(),
                                kitchenFoodOrderDTO.getExpectedDate(),
                                kitchenFoodOrderDTO.getDescription());

                        kitchenFoodOrderDTO.setOrderId(old.getOrderId());

                        //set amount in KitchenInventoryNotice
                        inventoryNoticeDTO.setOrderQty(kitchenFoodOrderDTO.getAmount() - old.getAmount());

                    } catch (NullPointerException e) {
                        kitchenFoodOrderDTO.setOrderId(KitchenUtil.defaultID);
                        inventoryNoticeDTO.setOrderQty(kitchenFoodOrderDTO.getAmount());
                    }

                } catch (NullPointerException e) {

                    try {
                        //search existing order
                        KitchenFoodOrderDTO old = kitchenBO.getExistingKitchenFoodOrder(
                                kitchenFoodOrderDTO.getFoodItemId(),
                                kitchenFoodOrderDTO.getExpectedDate(),
                                kitchenFoodOrderDTO.getDescription());

                        kitchenFoodOrderDTO.setOrderId(old.getOrderId());

                        //set amount in KitchenInventoryNotice
                        inventoryNoticeDTO.setOrderQty(kitchenFoodOrderDTO.getAmount());

                    } catch (NullPointerException e2) {
                        kitchenFoodOrderDTO.setOrderId(KitchenUtil.defaultID);
                        inventoryNoticeDTO.setOrderQty(kitchenFoodOrderDTO.getAmount());
                    }

                }

                kitchenBO.saveInventoryNotice(inventoryNoticeDTO);
                kitchenBO.saveKitchenFoodOrder(kitchenFoodOrderDTO);

            } else {
                alertMsg = "Order quantity should be a positive value";
            }


        } else {
            //error alert
            alertMsg = "Invalid date! Please enter again.";
        }

        model = getKitchenModel(model);
        model.addAttribute(KitchenUtil.alertMessageName, alertMsg);

        try {
            response.sendRedirect("/kitchen");
        } catch (Exception e){}

    }

    @PostMapping("/deleteDailyOrder")
    public void deleteDailyFoodOrder(Model model, @ModelAttribute KitchenFoodOrderDTO kitchenFoodOrderDTO, HttpServletResponse response) {
        alertMsg = null;
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        model.addAttribute("alert", alertMsg);
        //get inventory
        try {
            KitchenInventoryNoticeDTO kitchenNotice = kitchenBO.findInventoryNotice(
                    kitchenFoodOrderDTO.getExpectedDate(),
                    kitchenFoodOrderDTO.getFoodItemId(),
                    false
            );

            //delete kitchen order
            kitchenBO.deleteKitchenFoodOrder(kitchenFoodOrderDTO.getOrderId());
            //delete inventory item
            if (kitchenNotice.getOrderQty() > kitchenFoodOrderDTO.getAmount()) {
                //update quantity
                kitchenNotice.setOrderQty(0 - kitchenFoodOrderDTO.getAmount());

                //save notice
                kitchenBO.saveInventoryNotice(new InventoryNoticeDTO(
                        kitchenNotice.getNoticeId(),
                        kitchenNotice.getDepartment(),
                        kitchenNotice.getOrderQty(),
                        kitchenNotice.getDate(),
                        kitchenNotice.getExpDate(),
                        SuperController.idNo,
                        kitchenNotice.isState(),
                        kitchenNotice.getInventory().getInventoryId()
                ));
            } else if (kitchenNotice.getOrderQty() == kitchenFoodOrderDTO.getAmount()) {
                //delete notice
                kitchenBO.deleteInventoryNoticeById(kitchenNotice.getNoticeId());
            }

            alertMsg = "Order deleted successfully.";

        } catch (NullPointerException e) {
            //alert intem not found
            alertMsg = "Delete order failed";
        } finally {
            model = getKitchenModel(model);
            model.addAttribute(KitchenUtil.alertMessageName,alertMsg);
            alertMsg = null;
        }

        try {
            response.sendRedirect("/kitchen");
        } catch (Exception e){}

    }

    @GetMapping("/kitchenReport")
    public String loadKitchenReport(Model model) {
        alertMsg = null;
        model.addAttribute("alert", alertMsg);
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        List<RestaurantFoodOrderDTO> allFinishedOrders = kitchenBO.findReportData(new java.util.Date());
        List<RestaurantFoodItemDTO> onlineItems = new ArrayList<>();
        List<RestaurantFoodItemDTO> counterItems = new ArrayList<>();
        List<RestaurantFoodItemDTO> finalList = new ArrayList<>();

        //model variables for calculations
        int totalItemsSold = 0;
        int totalOnlineItemsSold = 0;
        int totalCounterItemsSold = 0;
        double totalOnlineIncome = 0;
        double totalCounterIncome = 0;
        double totalIncome = 0;

        if (!allFinishedOrders.isEmpty()){
            for (RestaurantFoodOrderDTO order: allFinishedOrders){

                System.out.println("======================================================\n\n");
                System.out.println(order.getType()+"\n");
                for (RestaurantFoodItemDTO item: order.getFoodItems()){
                    System.out.println("ID: "+item.getFoodItemId());
                    System.out.println("Name: "+item.getFoodName());
                    System.out.println("Quantity: "+item.getQuantity());
                    System.out.println("Price"+item.getPrice());
                    System.out.println("Total price: "+item.getTotalPrice());

                }

                System.out.println("======================================================\n\n");


                //////////////////////////////////////////////


                if (order.getType().equals(KitchenUtil.onlineType)){

                    onlineItems = order.getFoodItems();

                    //calc total item sold
                    if (!onlineItems.isEmpty()){

                        for (RestaurantFoodItemDTO itemDTO : onlineItems){
                            totalOnlineItemsSold += itemDTO.getQuantity();
                            totalOnlineIncome += itemDTO.getTotalPrice();
                        }

                        //set selling rates
                        for (RestaurantFoodItemDTO itemDTO : onlineItems){
                            itemDTO.setSellingRateOnline(Math.round(((itemDTO.getQuantity() / totalOnlineItemsSold) * 100)));
                        }

                    }


                } else if (order.getType().equals(KitchenUtil.counterType)){

                    counterItems = order.getFoodItems();

                    //calc total item sold
                    if (!counterItems.isEmpty()){

                        for (RestaurantFoodItemDTO itemDTO : counterItems){
                            totalCounterItemsSold += itemDTO.getQuantity();
                            totalCounterIncome += itemDTO.getTotalPrice();
                        }

                        //set selling rates
                        for (RestaurantFoodItemDTO itemDTO : counterItems){
                            itemDTO.setSellingRateCounter(Math.round((itemDTO.getQuantity() / totalCounterItemsSold) * 100));
                        }
                    }
                }
            }

            totalIncome = totalCounterIncome + totalOnlineIncome;
            totalItemsSold = totalCounterItemsSold + totalOnlineItemsSold;

            if (!onlineItems.isEmpty()){
                finalList.addAll(onlineItems);

                if (!counterItems.isEmpty()){
                    for (RestaurantFoodItemDTO counterItem: counterItems){
                        for (RestaurantFoodItemDTO list:finalList){
                            if (counterItem.getFoodItemId() == list.getFoodItemId()){
                                list.setSellingRateCounter(counterItem.getSellingRateCounter());
                                list.setQuantity(list.getQuantity() + counterItem.getQuantity());
                            }
                        }
                    }
                } else {
                    for (RestaurantFoodItemDTO itemDTO:finalList){
                        itemDTO.setSellingRateCounter(0);
                    }
                }
            } else {
                finalList.addAll(counterItems);

                for (RestaurantFoodItemDTO itemDTO:finalList){
                    itemDTO.setSellingRateOnline(0);
                }
            }

        }



        model.addAttribute("table", finalList);
        model.addAttribute("totalItemsSold",totalItemsSold);
        model.addAttribute("totalOnline", totalOnlineItemsSold);
        model.addAttribute("totalCounter", totalCounterItemsSold);
        model.addAttribute("totalCounterIncome", totalCounterIncome);
        model.addAttribute("totalOnlineIncome", totalOnlineIncome);
        model.addAttribute("totalIncome", totalIncome);

        return "kitchenReport";
    }

    @GetMapping("/restaurantOrders")
    public String loadRestaurantOrders(Model model) {
        alertMsg = null;
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        model = getRestaurantModel(model);
        return "kitchenRestaurantOrderList";
    }

    @PostMapping("/confirmOrder")
    public String confirmOrder(Model model, @ModelAttribute RestaurantFoodOrderDTO orderDTO) {
        alertMsg = null;
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        //check button
        if (orderDTO.getButton().equals(KitchenUtil.accept)){
            //check state
            if (orderDTO.getState().equals(KitchenUtil.pendingState)) {
                //take order
                if (!kitchenBO.takeRestaurantOrder(orderDTO)) {
                    alertMsg = "Order is already cancelled";
                }
            }
        } else if (orderDTO.getButton().equals(KitchenUtil.confirm)){
            kitchenBO.confirmRestaurantOrder(orderDTO);
            alertMsg = "Order id: "+orderDTO.getOrderId()+" Confirmed";

        } else if (!orderDTO.getButton().equals(KitchenUtil.confirm)
                && !orderDTO.getButton().equals(KitchenUtil.accept)){
            alertMsg = "Please select the first order.";
        }

        model = getRestaurantModel(model);

        if (alertMsg != null){
            model.addAttribute(KitchenUtil.alertMessageName, alertMsg);
        }

        return "kitchenRestaurantOrderList";
    }

    public Date getTodaySql() {
        long time = System.currentTimeMillis();
        Date today = new Date(time);
        return today;
    }

    public boolean compareDateWithToday(Date date) {
        Date today = Date.valueOf(getDateTodayString());
        if (date.compareTo(today) < 0) {
            return true;
        }
        return false;
    }


    private String getDateTodayString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = new java.util.Date();
        String today = dateFormat.format(date);
        return today;
    }

    public List<FoodItemDTO> getMenuFoodItems(MenuDTO menu) {

        List<MenuDetailsDTO> menuDetails;
        List<FoodItemDTO> foodItems = new ArrayList<>();
        FoodItemDTO defaultFoodItem;
        if (menu.getMenuId() != KitchenUtil.defaultID) {
            menuDetails = kitchenBO.findFoodItemsDetails(menu.getMenuId());

            for (MenuDetailsDTO item : menuDetails) {
                foodItems.add(kitchenBO.findFoodItemById(item.getFoodItemID()));
            }
        } else {
            defaultFoodItem = new FoodItemDTO();
            defaultFoodItem.setItemName(KitchenUtil.emptyItemList);
            foodItems.add(defaultFoodItem);
        }

        return foodItems;
    }

    public MenuDTO getNextItem(List<MenuDTO> menuDTOS, MenuDTO key) {
        MenuDTO returnItem = key;
        MenuDTO save = key;
        Queue<MenuDTO> queue = new LinkedList<>();
        int index = 0;

        //create list
        if (!menuDTOS.isEmpty()) {
            for (MenuDTO item : menuDTOS) {
                if (item.getType().equals(key.getType())) {
                    queue.add(item);
                }
            }
        }


        //remove unwanted
        if (key.getMenuId() != KitchenUtil.defaultID && !queue.isEmpty()) {

            while (!queue.isEmpty()) {

                returnItem = queue.remove();

                index++;
                if (index == 1) {
                    save = returnItem;

                }

                if (returnItem.getMenuId() == key.getMenuId()) {
                    //get next item
                    if (!queue.isEmpty()) {
                        returnItem = queue.remove();
                    } else {
                        returnItem = save;
                    }
                    break;
                }

            }

        } else if (key.getMenuId() == KitchenUtil.defaultID && !queue.isEmpty()) {
            returnItem = queue.remove();
        } else if (queue.isEmpty()) {
            returnItem = key;
        }

        return returnItem;
    }

    public FoodItemDTO getDefaultFoodItem() {
        FoodItemDTO defaultFoodItem = new FoodItemDTO();
        defaultFoodItem.setItemId(KitchenUtil.defaultID);
        defaultFoodItem.setItemName(KitchenUtil.emptyFoodItem);
        return defaultFoodItem;
    }

    public MenuDTO getDefultMenu() {
        MenuDTO defaultMenu = new MenuDTO();
        defaultMenu.setMenuId(KitchenUtil.defaultID);
        defaultMenu.setName(KitchenUtil.emptyMenuName);
        return defaultMenu;
    }

    public Model getKitchenModel(Model model) {

        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        model.addAttribute("alert", alertMsg);

        List<InventoryDTO> inventoryItems = kitchenBO.findKitchenInventory(KitchenUtil.department);
        List<InventoryDTO> selectedItems = new ArrayList<>();
        List<KitchenFoodOrderDTO> kitchenFoodOrderDTOS = kitchenBO.loadKitchenFoodOrderBydateAndDescription(getTodaySql(), KitchenUtil.dailyFoodOrderType);
        List<FoodItemDTO> breakfastFoodItems, lunchFoodItems, dinnerFoodItems;
        List<MenuDTO> menuDTOS = kitchenBO.findMenuItems();
        MenuDTO breakfast, lunch, dinner;
        LimitDTO limitDTO = new LimitDTO();

        //load not selected orders
        if (!kitchenFoodOrderDTOS.isEmpty()) {

            //select inventory items
            for (KitchenFoodOrderDTO item : kitchenFoodOrderDTOS) {
                for (InventoryDTO inventory : inventoryItems) {
                    if (item.getFoodItemId() == inventory.getInventoryId()) {
                        item.setItemName(inventory.getText());
                        selectedItems.add(inventory);
                    }
                }
            }

            //not selected list generate
            for (InventoryDTO selected : selectedItems) {
                if (inventoryItems.contains(selected))
                    inventoryItems.remove(selected);
            }

        }

        limitDTO.setLimit(KitchenUtil.kitchenMenuDate);

        //set default MenuDTO objects
        breakfast = getDefultMenu();
        breakfast.setType(KitchenUtil.daily_B_MenuType);
        lunch = getDefultMenu();
        lunch.setType(KitchenUtil.daily_L_MenuType);
        dinner = getDefultMenu();
        dinner.setType(KitchenUtil.daily_D_MenuType);


        //load daily menus block
        try {
            //Get saved
            String[] menudateArr = kitchenBO.findMenuDate().getLimitName().split(KitchenUtil.stringSeperator);
            String oldMenuDate = menudateArr[1];

            //compare today and saved date
            if (compareDateWithToday(Date.valueOf(oldMenuDate))) {
                //new date
                limitDTO.setLimitName(KitchenUtil.department + KitchenUtil.stringSeperator + getDateTodayString());
                kitchenBO.saveMenuDate(limitDTO);

                try {
                    List<MenuDTO> oldMenus = kitchenBO.getDailyMenuByType();
                    breakfast = oldMenus.get(0);
                    lunch = oldMenus.get(1);
                    dinner = oldMenus.get(2);
                } catch (NullPointerException e) {
                }

                //get next items
                breakfast = getNextItem(menuDTOS, breakfast);
                lunch = getNextItem(menuDTOS, lunch);
                dinner = getNextItem(menuDTOS, dinner);


                //generate key string
                String menusKey = breakfast.getMenuId() + KitchenUtil.stringSeperator + lunch.getMenuId() + KitchenUtil.stringSeperator + dinner.getMenuId();
                //save new daily menus
                kitchenBO.saveDailyMenuId(menusKey);

            } else {
                //get saved menus
                List<MenuDTO> menus = kitchenBO.getDailyMenuByType();
                breakfast = menus.get(0);
                lunch = menus.get(1);
                dinner = menus.get(2);
            }
        } catch (NullPointerException e) {
            //saved date not found
            //save today
            limitDTO.setLimitName(KitchenUtil.department + KitchenUtil.stringSeperator + getDateTodayString());
            kitchenBO.saveMenuDate(limitDTO);

            try {
                List<MenuDTO> oldMenus = kitchenBO.getDailyMenuByType();
                breakfast = oldMenus.get(0);
                lunch = oldMenus.get(1);
                dinner = oldMenus.get(2);
            } catch (NullPointerException e2) {
                breakfast = getNextItem(menuDTOS, breakfast);
                lunch = getNextItem(menuDTOS, lunch);
                dinner = getNextItem(menuDTOS, dinner);
            }

            //generate key string
            String menusKey = breakfast.getMenuId() + KitchenUtil.stringSeperator + lunch.getMenuId() + KitchenUtil.stringSeperator + dinner.getMenuId();
            //save new daily menus
            kitchenBO.saveDailyMenuId(menusKey);

        }

        breakfastFoodItems = getMenuFoodItems(breakfast);
        lunchFoodItems = getMenuFoodItems(lunch);
        dinnerFoodItems = getMenuFoodItems(dinner);


        // set model attributes

        model.addAttribute("loadFoodItemTable", inventoryItems);
        model.addAttribute("loadOrderTable", kitchenFoodOrderDTOS);
        model.addAttribute("breakfast", breakfast);
        model.addAttribute("breakfastTable", breakfastFoodItems);
        model.addAttribute("lunch", lunch);
        model.addAttribute("lunchTable", lunchFoodItems);
        model.addAttribute("dinner", dinner);
        model.addAttribute("dinnerTable", dinnerFoodItems);
        model.addAttribute("dailyOrderType", KitchenUtil.dailyFoodOrderType);


        return model;
    }

    public Model getRestaurantModel(Model model) {

        List<RestaurantFoodOrderDTO> onlineOrders = kitchenBO.getOnlineRestaurantFoodOrdersByDate(new java.util.Date());
        List<RestaurantFoodOrderDTO> couterOrders = kitchenBO.getCounterRestaurantFoodOrdersByDate(new java.util.Date());

        //set order table data
        model.addAttribute("onlineOrders", onlineOrders);
        model.addAttribute("pendingOnline", onlineOrders.size());
        model.addAttribute("counterOrders", couterOrders);
        model.addAttribute("pendingCounter", couterOrders.size());
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));

        if (onlineOrders.size() == 0 && couterOrders.size() == 0){
            alertMsg = "Pending restaurant order list is empty";
            model.addAttribute(KitchenUtil.alertMessageName, alertMsg);
            alertMsg = null;
        }

        return model;
    }

    public boolean chckOldDate(Date date){
        Date today = Date.valueOf(getDateTodayString());
        if (date.compareTo(today) >= 0){
            return true;
        }
        return false;
    }

    public RestaurantFoodItemDTO checkFoodItemExist(List<RestaurantFoodItemDTO> list, int id){
        int index = 0;

        if (!list.isEmpty()){
            for (int i = 0; i < list.size(); i++){
                if (list.get(i).getFoodItemId() == id){

                    return list.get(i);
                }
            }
        }

        RestaurantFoodItemDTO failed = new RestaurantFoodItemDTO();
        failed.setFoodItemId(KitchenUtil.defaultID);
        return failed;
    }

}

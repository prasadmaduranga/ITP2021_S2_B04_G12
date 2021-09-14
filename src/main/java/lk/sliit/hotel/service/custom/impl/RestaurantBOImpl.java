package lk.sliit.hotel.service.custom.impl;

import lk.sliit.hotel.controller.RestaurantController.TableUtil;
import lk.sliit.hotel.dao.inventoryDAO.InventoryDAO;
import lk.sliit.hotel.dao.kitchenDAO.KitchenDAO;
import lk.sliit.hotel.dao.retaurantDAO.OnlineCustomerDAO;
import lk.sliit.hotel.dao.retaurantDAO.RestaurantTableDAO;
import lk.sliit.hotel.dao.retaurantDAO.counterOrderDAO.RestaurantCounterOrderDAO;
import lk.sliit.hotel.dao.retaurantDAO.counterOrderDAO.RestaurantCounterOrderDetailDAO;
import lk.sliit.hotel.dao.retaurantDAO.counterTableReservationDAO.CounterTableReservationDAO;
import lk.sliit.hotel.dao.retaurantDAO.counterTableReservationDAO.CounterTableReservationDetailsDAO;
import lk.sliit.hotel.dao.retaurantDAO.onlineOrderDAO.RestaurantOnlineOrderDAO;
import lk.sliit.hotel.dao.retaurantDAO.onlineOrderDAO.RestaurantOnlineOrderDetailsDAO;
import lk.sliit.hotel.dto.kitchen.FoodItemDTO;
import lk.sliit.hotel.dto.restaurant.CounterOrder.RestaurantCounterOrderDTO;
import lk.sliit.hotel.dto.restaurant.CounterOrder.RestaurantCounterOrderDetailDTO;
import lk.sliit.hotel.dto.restaurant.CounterTableReservation.CounterTableReservationDTO;
import lk.sliit.hotel.dto.restaurant.CounterTableReservation.CounterTableReservationDetailsDTO;
import lk.sliit.hotel.dto.restaurant.ResTableDTO;
import lk.sliit.hotel.dto.restaurant.ResTableReservationDTO;
import lk.sliit.hotel.dto.restaurant.RestaurantTableDTO;
import lk.sliit.hotel.dto.restaurant.restaurantOnlineOrder.RestaurantOnlineOrderDTO;
import lk.sliit.hotel.dto.restaurant.restaurantOnlineOrder.RestaurantOnlineOrderDetailsDTO;
import lk.sliit.hotel.entity.kitchen.FoodItem;
import lk.sliit.hotel.entity.restaurant.RestaurantTable;
import lk.sliit.hotel.entity.restaurant.counterOrder.RestaurantCounterOrder;
import lk.sliit.hotel.entity.restaurant.counterOrder.RestaurantCounterOrderDetail;
import lk.sliit.hotel.entity.restaurant.counterTableReservation.CounterTableReservation;
import lk.sliit.hotel.entity.restaurant.counterTableReservation.CounterTableReservationDetails;
import lk.sliit.hotel.entity.restaurant.onlineOrder.RestaurantOnlineOrder;
import lk.sliit.hotel.entity.restaurant.onlineOrder.RestaurantOnlineOrderDetails;
import lk.sliit.hotel.service.custom.RestaurantBO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class RestaurantBOImpl implements RestaurantBO {

    @Autowired
    KitchenDAO foodItem;
    @Autowired
    RestaurantCounterOrderDAO restaurantCounterOrderDAO;
    @Autowired
    RestaurantCounterOrderDetailDAO restaurantCounterOrderDetail;


    @Autowired
    RestaurantOnlineOrderDetailsDAO onlineOrderDetailsDAO;
    @Autowired
    RestaurantOnlineOrderDAO onlineOrderDAO;
    @Autowired
    OnlineCustomerDAO onlineCustomerDAO;


    @Autowired
    RestaurantTableDAO restaurantTableDAO;
    @Autowired
    CounterTableReservationDAO counterTableReservationDAO;
    @Autowired
    CounterTableReservationDetailsDAO counterTableReservationDetailsDAO;

//    @Autowired
//    OnlineTableReservationDetailsDAO onlineTableReservationDetailsDAO;
//    @Autowired
//    OnlineTableReservationDAO onlineTableReservationDAO;

/*------------------------------------------------------------counter order------------------------------------------------*/
    //find highest id to save
    @Override
    public RestaurantCounterOrderDTO findTopByOrderByRestIdDesc() {

        RestaurantCounterOrder orders = null;
        try {
            orders = restaurantCounterOrderDAO.findTopByOrderByOrderIdDesc();
        } catch (Exception e) {

        }
        return new RestaurantCounterOrderDTO(
                orders.getOrderId()
        );
    }


    //SAve Counter Order
    @Transactional
    @Override
    public void saveRestaurantOrder(RestaurantCounterOrderDTO restaurantCounterOrderDTO) {
        List<RestaurantCounterOrderDetailDTO> list = new ArrayList<>();
        String arr = restaurantCounterOrderDTO.getDataValue();
        String yo[] = arr.split(" ");
        int count = 0;
        RestaurantCounterOrderDetailDTO itm = new RestaurantCounterOrderDetailDTO();
        for (String str : yo) {
            if (count == 0) {
                itm = new RestaurantCounterOrderDetailDTO();
                itm.setFoodItem(Integer.parseInt(str));
                count++;

            } else if (count == 1) {
                itm.setUnitePrice(Double.parseDouble(str));
                count++;

            } else if (count == 2) {
                itm.setQuantity(Double.parseDouble(str));
                list.add(itm);
                count = 0;
            }
        }
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 0);
        java.util.Date today = cal.getTime();
        restaurantCounterOrderDTO.setDate(today);
        restaurantCounterOrderDAO.save(new RestaurantCounterOrder(//Save Data in restaurantCounterOrderDAO table
                restaurantCounterOrderDTO.getOrderId(),
                restaurantCounterOrderDTO.getOrderState(),
                restaurantCounterOrderDTO.getQuantity(),
                restaurantCounterOrderDTO.getDate(),
                restaurantCounterOrderDTO.getOrderHolder()));

        for (RestaurantCounterOrderDetailDTO orderDetail : list) {//Save Data in restaurantCounterOrderDetail table
            restaurantCounterOrderDetail.save(new RestaurantCounterOrderDetail(
                    restaurantCounterOrderDTO.getOrderId(),
                    orderDetail.getFoodItem(),
                    orderDetail.getQuantity(),
                    orderDetail.getUnitePrice()));

        }
    }

//get all food items
    @Override
    public List<FoodItemDTO> findAllFoodItems(String restaurant) {
        Iterable<FoodItem> all = foodItem.findAllByCategoryEquals(restaurant);
        List<FoodItemDTO> dtos = new ArrayList<>();
        for (FoodItem a : all) {
            dtos.add(new FoodItemDTO(
                    a.getItemId(),
                    a.getName(),
                    a.getUnitePrice(),
                    a.getCategory(),
                    a.getSrc()
             ));
        }
        return dtos;
    }

/*--------------------------------------------------------online order--------------------------------------------------------*/

    //find highest online orderid to save
    @Override
    public RestaurantOnlineOrderDTO findHighestOnlineOrderId() {
        RestaurantOnlineOrder orders = null;
        try {
            orders = onlineOrderDAO.findTopByOrderByOrderIdDesc();
        } catch (Exception e) {

        }
        return new RestaurantOnlineOrderDTO(
                orders.getOrderId()
        );
    }

    //save online order
    @Override
    public void saveOnlineOrder(RestaurantOnlineOrderDTO onlineOrderDTO) {
        java.util.List<RestaurantOnlineOrderDetailsDTO> list = new ArrayList<>();
        String arr = onlineOrderDTO.getOrderData();

        String yo[] = arr.split(" ");
        int count = 0;
        RestaurantOnlineOrderDetailsDTO itm = new RestaurantOnlineOrderDetailsDTO();
        for (String str : yo) {//Read string array
            if (count == 0) {
                itm = new RestaurantOnlineOrderDetailsDTO();
                itm.setFoodItem(Integer.parseInt(str));
                count++;

            } else if (count == 1) {
                itm.setUnitePrice(Double.parseDouble(str));
                count++;

            } else if (count == 2) {
                itm.setQuantity(Double.parseDouble(str));
                list.add(itm);
                count = 0;
            }
        }
        Calendar cal = Calendar.getInstance();//calculate date
        cal.add(Calendar.DATE, 0);
        java.util.Date today = cal.getTime();
        onlineOrderDTO.setDate(today);
        onlineOrderDAO.save(new RestaurantOnlineOrder(//Save Order
                onlineOrderDTO.getOrderId(),
                onlineOrderDTO.getOrderState(),
                onlineOrderDTO.getDate(),
                onlineCustomerDAO.findOne(onlineOrderDTO.getCustomer())));

        for (RestaurantOnlineOrderDetailsDTO orderDetail : list) {//Save Order detail
            onlineOrderDetailsDAO.save(new RestaurantOnlineOrderDetails(
                    onlineOrderDTO.getOrderId(),
                    orderDetail.getFoodItem(),
                    orderDetail.getQuantity(),
                    orderDetail.getUnitePrice()));

        }
    }

    //order report
    @Override
    public List<RestaurantOnlineOrderDTO> findOrderOnline() {
        java.util.Date todaydate = new java.util.Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        java.util.Date dt = cal.getTime();
        Iterable<RestaurantOnlineOrder> all4 = onlineOrderDAO.findAllByDateBetween(dt, todaydate);//Find all Date Between(before 1 month)
        List<RestaurantOnlineOrderDTO> orderDTOList = new ArrayList<>();
        for (RestaurantOnlineOrder item : all4) {
            orderDTOList.add(new RestaurantOnlineOrderDTO(
                    item.getOrderId(),
                    item.getOrderState(),
                    item.getDate(),
                    item.getCustomer().getOnlineCustomerId(),
                    item.getOrderDetails()
            ));
        }
        return orderDTOList;
    }



    /*-------------------------------------------------counter table reservation----------------------------------------------*/
    //get list of tables
    @Override
    public List<RestaurantTableDTO> findAllTable() {
        Iterable<RestaurantTable> all = restaurantTableDAO.findAll();
        List<RestaurantTableDTO> dtos = new ArrayList<>();
        for (RestaurantTable a : all) {
            dtos.add(new RestaurantTableDTO(
                    a.getTableId(),
                    a.getType(),
                    a.getPlace()
            ));
        }
        return dtos;
    }
    //find tables
    @Override
    public RestaurantTableDTO findTableById(int tableId) {
        RestaurantTable table = restaurantTableDAO.findOne(tableId);
        return new RestaurantTableDTO(
                table.getTableId(),
                table.getType(),
                table.getPlace()
        );
    }

    //find highest id to save
    @Override
    public RestaurantTableDTO findHighestTableId() {
        RestaurantTable lastItem = null;
        try {
            lastItem = restaurantTableDAO.findTopByOrderByTableIdDesc();
        } catch (Exception e) {
        }
        return new RestaurantTableDTO(lastItem.getTableId());
    }

    //save tables
    @Override
    public void saveTable(RestaurantTableDTO restaurantTableDTO) {
        restaurantTableDAO.save(new RestaurantTable(
                restaurantTableDTO.getTableId(),
                restaurantTableDTO.getType(),
                restaurantTableDTO.getPlace()));
    }

    //delete table
    @Override
    public void deleteTable(int tableId) {
        restaurantTableDAO.delete(tableId);
    }

    //get booked tables for today
    @Override
    public List<CounterTableReservationDTO> getBookedTables() {
        java.util.Date date = new java.util.Date();
        List<CounterTableReservationDTO> list = new ArrayList<>();
        //List<OnlineTableReservationDetails> list4 = new ArrayList<>();
        List<CounterTableReservationDetails> list5 = new ArrayList<>();
        //Iterable<OnlineTableReservation> onlineTableReservations = null;
        Iterable<CounterTableReservation> counterTableReservations = null;
        try {
//Find Online Booked Tables
            //onlineTableReservations = onlineTableReservationDAO.findOnlineTableReservationByReservedDateEquals(date);
            //Find Counter Booked Tables
            counterTableReservations = counterTableReservationDAO.findCounterTableReservationByDateEquals(date);
        } catch (NullPointerException e) {
        }

        //Add data
//        for (OnlineTableReservation d2 : onlineTableReservations) {
//            list4 = d2.getOrderDetails();//Get data from Detail Table
//            for (OnlineTableReservationDetails a : list4) {
//
//                list.add(new CounterTableReservationDTO(
//                        d2.getOnlineTableReservationId(),
//                        d2.getStartTime(),
//                        d2.getEndTime(),
//                        a.getTableId().getType()
//                ));
//            }
//        }
        for (CounterTableReservation d2 : counterTableReservations) {
            list5 = d2.getOrderDetails();//Get data from Detail Table
            for (CounterTableReservationDetails a : list5) {

                list.add(new CounterTableReservationDTO(
                        d2.getCounterTableReserveId(),
                        d2.getStartTime(),
                        d2.getEndTime(),
                        a.getTableId().getType(),
                        a.getTableId().getPlace()
                ));
            }

        }

        return list;
    }

    //get only not booking tables
    @Override
    public List<RestaurantTableDTO> getAviTables(Date date, Date startTime, Date endTime) {
        //Find Book Table in online table reservation
       // Iterable<OnlineTableReservation> all4 = onlineTableReservationDAO.getAllBetweenDates(endTime, startTime, date);
//Find Book Table in counter table reservation
        Iterable<CounterTableReservation> all5 = counterTableReservationDAO.getAllBetweenDates(endTime, startTime, date);
        //Find All Table
        Iterable<RestaurantTable> allTable = restaurantTableDAO.findAll();
        Iterable<CounterTableReservationDetails> al5;
        List<RestaurantTable> list = new ArrayList<>();
        List<RestaurantTable> list22 = new ArrayList<>();
        List<RestaurantTable> list2 = new ArrayList<>();


//        for (RestaurantTable d : allTable) {//Find available tables by comparing in online reservation
//            for (OnlineTableReservation d2 : all4) {
//                al4 = d2.getOrderDetails();
//                for (OnlineTableReservationDetails d3 : al4) {
//                    if (d.getTableId() != d3.getTableId().getTableId()) {
//                        if (!list.contains(d3.getTableId())) {
//                            list.add(d3.getTableId());
//                        }
//                    }
//                }
//            }
//        }
        for (RestaurantTable d : allTable) {//Find available tables by comparing in counter reservation
            for (CounterTableReservation d2 : all5) {
                al5 = d2.getOrderDetails();
                for (CounterTableReservationDetails d3 : al5) {
                    if (d.getTableId() != d3.getTableId().getTableId()) {
                        if (!list22.contains(d3.getTableId())) {
                            list22.add(d3.getTableId());
                        }
                    }
                }
            }
        }

        for (RestaurantTable b : allTable) {//Find available tables
            if (!list22.contains(b)) {//!list.contains(b)
                list2.add(b);
            }
        }
        List<RestaurantTableDTO> dtoList = new ArrayList<>();//Add to dto Array List
        for (RestaurantTable a : list2) {
            dtoList.add(new RestaurantTableDTO(
                    a.getTableId(),
                    a.getType(),
                    a.getPlace()
            ));
        }
        return dtoList;
    }

    //find highest reservation id
    @Override
    public CounterTableReservationDTO findHighestCounterTableId() {
        CounterTableReservation lastItem = null;
        try {
            lastItem = counterTableReservationDAO.findTopByOrderByCounterTableReserveIdDesc();
        } catch (Exception e) {

        }
        return new CounterTableReservationDTO(lastItem.getCounterTableReserveId());
    }

    //save reservation
    @Override
    public void saveCounterTableId(CounterTableReservationDTO onlineOrderDTO) {
        java.util.List<CounterTableReservationDetailsDTO> list = new ArrayList<>();
        String arr = onlineOrderDTO.getOrderData();
        String yo[] = arr.split(" "); // Add booked table String to array
        int count = 0;
        CounterTableReservationDetailsDTO itm = new CounterTableReservationDetailsDTO();
        for (String str : yo) {//read array
            if (count == 0) {
                itm = new CounterTableReservationDetailsDTO();
                itm.setTableId(Integer.parseInt(str));
                list.add(itm);//Add List
                count = 0;
            }
        }
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 0);
        java.util.Date today = cal.getTime();
        onlineOrderDTO.setDate(today);
        counterTableReservationDAO.save(new CounterTableReservation(//Save In counter table

                onlineOrderDTO.getCounterTableReserveId(),
                Time.valueOf(onlineOrderDTO.getvStatT()),
                Time.valueOf(onlineOrderDTO.getvEndT()),
                list.size(),//Set table quantity
                java.sql.Date.valueOf(onlineOrderDTO.getvDate())
        ));

        for (CounterTableReservationDetailsDTO orderDetail : list) {//Save Table Details
            counterTableReservationDetailsDAO.save(new CounterTableReservationDetails(
                    onlineOrderDTO.getCounterTableReserveId(),
                    orderDetail.getTableId()
                    ,500,list.size()
            ));

        }
    }



    //manage table reserving state
    @Override
    public List<ResTableReservationDTO> getCounterTableReservationByDate(Date date) {
        List<ResTableReservationDTO> returnList = new ArrayList<>();
        List<ResTableDTO> tableDTOS;
        Iterable<CounterTableReservation> counterOrders;
        int index = 0;
        //get counter orders
        try {
            counterOrders = counterTableReservationDAO.findAll();

            for (CounterTableReservation item : counterOrders) {

                java.util.Date comp = item.getDate();
                if (date.getYear() == comp.getYear()
                        && date.getMonth() == comp.getMonth()
                        && date.getDate() == comp.getDate()) {
                    if (item.getTableState()== null
                            || item.getTableState().equals(TableUtil.processingState)) {
                        //set state and button
                        String button = TableUtil.processingState;

                        if (index == 0) {
                            button = TableUtil.confirm;
                        }

                        if (item.getTableState() == null) {
                            item.setTableState(TableUtil.processingState);
                        }

                        if (item.getTableState().equals(TableUtil.processingState)) {
                            button = TableUtil.confirm;
                        }


                        Iterable<CounterTableReservationDetails> counterOrderDetails = counterTableReservationDetailsDAO.findAllByCounterTableReservationEquals(item);

                        //create table item list
                        tableDTOS = new ArrayList<>();

                        for (CounterTableReservationDetails detail : counterOrderDetails) {
                            //set table items list
                            tableDTOS.add(new ResTableDTO(
                                    detail.getTableId().getTableId(),
                                    item.getCounterTableReserveId(),
                                    detail.getQuantity(),
                                    detail.getUnitePrice()
                            ));
                        }

                        //complete restaurant table reservations
                        returnList.add(new ResTableReservationDTO(
                                item.getCounterTableReserveId(),
                                TableUtil.counterType,
                                item.getTableState(),
                                button,
                                tableDTOS,
                                index
                        ));

                        index++;

                    }

                }

            }
        } catch (NullPointerException e) {

        }

        return returnList;
    }




    //manage the table reservation state
    @Override
    public boolean taketableRese(ResTableReservationDTO order) {
        //check order type
//        if (order.getType().equals(KitchenUtil.onlineType)) {
//            RestaurantOnlineOrder onlineOrder = onlineOrderDAO.findOne(order.getOrderId());
//
//            //check state
//            if (!onlineOrder.getOrderState().equals(KitchenUtil.canceledState)
//                    || !onlineOrder.getOrderState().equals(KitchenUtil.finishedState)) {
//                onlineOrder.setOrderState(KitchenUtil.processingState);
//                onlineOrderDAO.save(onlineOrder);
//                return true;
//            }

        if (order.getType().equals(TableUtil.counterType)) {
            CounterTableReservation counterOrder = counterTableReservationDAO.findOne(order.getReseId());

            //check state
            if (!counterOrder.getTableState().equals(TableUtil.canceledState)
                    || !counterOrder.getTableState().equals(TableUtil.finishedState)) {
                counterOrder.setTableState(TableUtil.processingState);
                counterTableReservationDAO.save(counterOrder);

                return true;
            }
        }
        return false;
    }



    //manage released state
    @Override
    public void confirmtableRese(ResTableReservationDTO orderDTO) {
//        if (orderDTO.getType().equals(KitchenUtil.onlineType)) {
//            RestaurantOnlineOrder onlineOrder = onlineOrderDAO.findOne(orderDTO.getOrderId());
//            onlineOrder.setOrderState(KitchenUtil.finishedState);
//            onlineOrderDAO.save(onlineOrder);

        if (orderDTO.getType().equals(TableUtil.counterType)) {
            CounterTableReservation counterOrder = counterTableReservationDAO.findOne(orderDTO.getReseId());
            counterOrder.setTableState(TableUtil.finishedState);
            counterTableReservationDAO.save(counterOrder);
        }


    }

    //table report
    @Override
    public List<ResTableReservationDTO> findReportData(Date date) {
        List<ResTableReservationDTO> returnlist = new ArrayList<>();
        List<ResTableDTO> tableDTOS, selectedtableList;
        ResTableReservationDTO order;

        try {
            Iterable<CounterTableReservation> coubterOrders = counterTableReservationDAO.findAllByTableStateEquals(TableUtil.finishedState);
            tableDTOS = new ArrayList<>();
            selectedtableList = new ArrayList<>();

            for( CounterTableReservation item:coubterOrders){

                java.util.Date comp = item.getDate();
                if (date.getYear() == comp.getYear()
                        && date.getMonth() == comp.getMonth()
                        && date.getDate() == comp.getDate()) {

                    Iterable<CounterTableReservationDetails> details = counterTableReservationDetailsDAO.findAllByCounterTableReservationEquals(item);
                    for (CounterTableReservationDetails detail : details) {

                        tableDTOS.add(new ResTableDTO(
                                detail.getTableId().getTableId(),
                                item.getCounterTableReserveId(),
                                detail.getQuantity(),
                                detail.getUnitePrice()
                        ));

                    }

                }
            }
//set table list
            if (!tableDTOS.isEmpty()){

                while (!tableDTOS.isEmpty()){
                    //select 1st item
                    ResTableDTO selectedItem = tableDTOS.remove(0);
                    List<ResTableDTO> remove = new ArrayList<>();

                    //get total tables info
                    if (!tableDTOS.isEmpty()){

                        for (ResTableDTO resitem:tableDTOS){
                            if (selectedItem.getTableId() == resitem.getTableId()){
                                selectedItem.setQuantity(resitem.getQuantity() + selectedItem.getQuantity());
                                remove.add(resitem);
                            }
                        }
                    }


                    //remove selected item from foodItemDTOS
                    if (!remove.isEmpty())
                        tableDTOS.removeAll(remove);

                    selectedtableList.add(selectedItem);

                }

                //set total price
                for (ResTableDTO tableitem:selectedtableList){
                    tableitem.setTotalPrice(tableitem.getQuantity() * tableitem.getPrice());
                }
            }

            order = new ResTableReservationDTO();
            order.setTables(selectedtableList);
            order.setType(TableUtil.counterType);
            returnlist.add(order);


        }catch(NullPointerException e){

        }
        return returnlist;
    }

}



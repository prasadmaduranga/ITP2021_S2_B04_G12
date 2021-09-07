package lk.sliit.hotel.service.custom.impl;

import lk.sliit.hotel.dao.kitchenDAO.KitchenDAO;
import lk.sliit.hotel.dao.retaurantDAO.counterOrderDAO.RestaurantCounterOrderDAO;
import lk.sliit.hotel.dao.retaurantDAO.counterOrderDAO.RestaurantCounterOrderDetailDAO;
import lk.sliit.hotel.dto.kitchen.FoodItemDTO;
import lk.sliit.hotel.dto.restaurant.restaurantCounterOrder.RestaurantCounterOrderDTO;
import lk.sliit.hotel.dto.restaurant.restaurantCounterOrder.RestaurantCounterOrderDetailDTO;
import lk.sliit.hotel.entity.kitchen.FoodItem;
import lk.sliit.hotel.entity.restaurant.counterOrder.RestaurantCounterOrder;
import lk.sliit.hotel.entity.restaurant.counterOrder.RestaurantCounterOrderDetail;
import lk.sliit.hotel.service.custom.RestaurantBO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
@Transactional
public class RestaurantBOImpl implements RestaurantBO {
    //    @Autowired
    //    InventoryDAO inventoryDAO;
    @Autowired
    KitchenDAO foodItem;
//    @Autowired
//    RestaurantTableDAO restaurantTableDAO;
//    @Autowired
//    OnlineTableReservationDetailsDAO onlineTableReservationDetailsDAO;
//    @Autowired
//    OnlineTableReservationDAO onlineTableReservationDAO;
//    @Autowired
//    CounterTableReservationDAO counterTableReservationDAO;
//    @Autowired
//    CounterTableReservationDetailsDAO counterTableReservationDetailsDAO;
    @Autowired
    RestaurantCounterOrderDAO restaurantCounterOrderDAO;
    @Autowired
    RestaurantCounterOrderDetailDAO restaurantCounterOrderDetail;

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


}
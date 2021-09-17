package lk.sliit.hotel.dto.restaurant.restaurantOnlineOrder;

import lk.sliit.hotel.entity.restaurant.onlineOrder.RestaurantOnlineOrderDetails;

import java.util.Date;
import java.util.List;

public class RestaurantOnlineOrderDTO {

    private int orderId;
    private String orderState;
    private Date date;
    private int customer;
    private  String orderData;
    List<RestaurantOnlineOrderDetails> orderDetails;

    public RestaurantOnlineOrderDTO(int orderId, String orderState, Date date, int customer) {
        this.orderId = orderId;
        this.orderState = orderState;
        this.date = date;
        this.customer = customer;
    }

    public RestaurantOnlineOrderDTO(int orderId, String orderState, Date date, int customer, String orderData) {
        this.orderId = orderId;
        this.orderState = orderState;
        this.date = date;
        this.customer = customer;
        this.orderData = orderData;
    }

    public RestaurantOnlineOrderDTO(int orderId) {
        this.orderId = orderId;
    }

    public RestaurantOnlineOrderDTO(int orderId, String orderState, Date date,int customer, List<RestaurantOnlineOrderDetails> orderDetails) {
        this.orderId = orderId;
        this.orderState = orderState;
        this.date = date;
        this.customer = customer;
        this.orderDetails= orderDetails;
    }

    public String getOrderData() {
        return orderData;
    }

    public void setOrderData(String orderData) {
        this.orderData = orderData;
    }

    public RestaurantOnlineOrderDTO() {
    }

    public List<RestaurantOnlineOrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<RestaurantOnlineOrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "RestaurantOnlineOrderDTO{" +
                "orderId='" + orderId + '\'' +
                ", orderState='" + orderState + '\'' +
                ", date=" + date +
                ", customer='" + customer + '\'' +
                '}';
    }
}

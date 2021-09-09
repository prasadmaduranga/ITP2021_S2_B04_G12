package lk.sliit.hotel.dto.banquet;

import java.util.Date;

public class BanquetAddDTO {

    private int orderId;
    private Date date;
    private String hallId;
    private int noOfPlates;
    private String orderState;
    private String SubmittedBy;
    private int banquetBill;
    private int customerId;
    private int menuId;

    public BanquetAddDTO() {

    }

    public BanquetAddDTO(int orderId, Date date, String hallId, int noOfPlates, int menuId) {
        this.orderId = orderId;
        this.date = date;
        this.hallId = hallId;
        this.noOfPlates = noOfPlates;
        this.menuId = menuId;
    }


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHallId() {
        return hallId;
    }

    public void setHallId(String hallId) {
        this.hallId = hallId;
    }

    public int getNoOfPlates() {
        return noOfPlates;
    }

    public void setNoOfPlates(int noOfPlates) {
        this.noOfPlates = noOfPlates;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public String getSubmittedBy() {
        return SubmittedBy;
    }

    public void setSubmittedBy(String submittedBy) {
        SubmittedBy = submittedBy;
    }

    public int getBanquetBill() {
        return banquetBill;
    }

    public void setBanquetBill(int banquetBill) {
        this.banquetBill = banquetBill;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }


}

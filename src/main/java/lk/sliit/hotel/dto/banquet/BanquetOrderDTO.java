package lk.sliit.hotel.dto.banquet;


import java.util.Date;

public class BanquetOrderDTO {

    private int orderId;
    private String hallId;
    private String orderState;
    private int noOfPlates;
    private Date date;
    private String submittedBy;
    private String customerId;
    private String menuId;
    private int banquetBillId;

    public BanquetOrderDTO(int orderId) {
        this.orderId= orderId;
    }


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getHallId() {
        return hallId;
    }

    public void setHallId(String hallId) {
        this.hallId = hallId;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public int getNoOfPlates() {
        return noOfPlates;
    }

    public void setNoOfPlates(int noOfPlates) {
        this.noOfPlates = noOfPlates;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(String submittedBy) {
        this.submittedBy = submittedBy;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public int getBanquetBillId() {
        return banquetBillId;
    }

    public void setBanquetBillId(int banquetBillId) {
        this.banquetBillId = banquetBillId;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    @Override
    public String toString() {
        return "BanquetOrderDTO{" +
                "orderId=" + orderId +
                ", hallId='" + hallId + '\'' +
                ", orderState='" + orderState + '\'' +
                ", noOfPlates=" + noOfPlates +
                ", date=" + date +
                ", submittedBy='" + submittedBy + '\'' +
                ", customerId='" + customerId + '\'' +
                ", menuId='" + menuId + '\'' +
                ", banquetBillId=" + banquetBillId +
                '}';
    }
}

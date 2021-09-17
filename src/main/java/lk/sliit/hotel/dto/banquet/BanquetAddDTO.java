package lk.sliit.hotel.dto.banquet;

import java.sql.Date;

public class BanquetAddDTO {
    private int orderId;
    private int customerId;
    private String email;
    private String name;
    private String address;
    private String contactNumber;
    private java.sql.Date date;
    private String hallId;
    private String orderState;
    private int noOfPlates;
    private String submittedBy;
    private int menuId;
    private int banquetBillId;
    private double advanceFee;
    private double foodPrice;
    private double otherPrice;
    private double total;
    private double unitPrise;

    public BanquetAddDTO(int orderId, Date date, String hallId, int noOfPlates, int menuId) {
        this.orderId = orderId;
        this.date = date;
        this.hallId =hallId;
        this.noOfPlates = noOfPlates;
        this.menuId = menuId;

    }

    public BanquetAddDTO(int orderId, String name, Date date, int billId, double advancePayment, double foodPrice,
                        double otherPrices, double total, double unitPrice, int noOfPlates) {
        this.orderId= orderId;
        this.name= name;
        this.date = date;
        this.banquetBillId= billId;
        this.advanceFee = advancePayment;
        this.foodPrice = foodPrice;
        this.noOfPlates = noOfPlates;
        this.unitPrise =unitPrice;
        this.total = total;
        this.otherPrice = otherPrices;



    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public java.sql.Date getDate() {
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

    public String getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(String submittedBy) {
        this.submittedBy = submittedBy;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getBanquetBillId() {
        return banquetBillId;
    }

    public void setBanquetBillId(int banquetBillId) {
        this.banquetBillId = banquetBillId;
    }

    public double getAdvanceFee() {
        return advanceFee;
    }

    public void setAdvanceFee(double advanceFee) {
        this.advanceFee = advanceFee;
    }

    public double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public double getOtherPrice() {
        return otherPrice;
    }

    public void setOtherPrice(double otherPrice) {
        this.otherPrice = otherPrice;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getUnitPrise() {
        return unitPrise;
    }

    public void setUnitPrise(double unitPrise) {
        this.unitPrise = unitPrise;
    }

    @Override
    public String toString() {
        return "BanquetAddDTO{" +
                "orderId=" + orderId +
                ", customerId=" + customerId +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", date=" + date +
                ", hallId='" + hallId + '\'' +
                ", orderState='" + orderState + '\'' +
                ", noOfPlates=" + noOfPlates +
                ", submittedBy='" + submittedBy + '\'' +
                ", menuId=" + menuId +
                ", banquetBillId=" + banquetBillId +
                ", advanceFee=" + advanceFee +
                ", foodPrice=" + foodPrice +
                ", otherPrice=" + otherPrice +
                ", total=" + total +
                ", unitPrise=" + unitPrise +
                '}';
    }
}




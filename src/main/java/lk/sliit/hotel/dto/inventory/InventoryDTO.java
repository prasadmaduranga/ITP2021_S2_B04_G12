package lk.sliit.hotel.dto.inventory;

import java.sql.Date;

public class InventoryDTO {

    private int inventoryId ;
    private String text;
    private String description;
    private double orderQty;
    private  String type;
    private String orderLimit;
    private double getPrice;
    private double sellingPrice;
    private Date date;
    //   Save Inventory Order ////////////////////////////////////
    private int supplierId;
    private int orderId;
    private int orderHolder;

    //OrderData
    private double newOrderQty;
    private double checkComplete;
    private int noticeId;



    public InventoryDTO() {
    }

    public InventoryDTO(int inventoryId, String text, String description,
                        double orderQty, String type, String orderLimit,
                        double getPrice, double sellingPrice, Date date) {
        this.inventoryId = inventoryId;
        this.text = text;
        this.description = description;
        this.orderQty = orderQty;
        this.type = type;
        this.orderLimit = orderLimit;
        this.getPrice = getPrice;
        this.sellingPrice = sellingPrice;
        this.date = date;

    }

    public InventoryDTO(int inventoryId, String text, String description, double orderQty, String type,
                        String orderLimit, double getPrice,
                        double sellingPrice, Date date, int supplierId,
                        int orderId, int orderHolder, double newOrderQty, int noticeId) {
        this.inventoryId = inventoryId;
        this.text = text;
        this.description = description;
        this.orderQty = orderQty;
        this.type = type;
        this.orderLimit = orderLimit;
        this.getPrice = getPrice;
        this.sellingPrice = sellingPrice;
        this.date = date;
        this.supplierId = supplierId;
        this.orderId = orderId;
        this.orderHolder = orderHolder;
        this.newOrderQty = newOrderQty;
        this.noticeId = noticeId;
    }

    public double getNewOrderQty() {
        return newOrderQty;
    }

    public int getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(int noticeId) {
        this.noticeId = noticeId;
    }

    public double getCheckComplete() {
        return checkComplete;
    }

    public void setCheckComplete(double checkComplete) {
        this.checkComplete = checkComplete;
    }

    public void setNewOrderQty(double newOrderQty) {
        this.newOrderQty = newOrderQty;
    }

    public InventoryDTO(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getOrderHolder() {
        return orderHolder;
    }

    public void setOrderHolder(int orderHolder) {
        this.orderHolder = orderHolder;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(double orderQty) {
        this.orderQty = orderQty;
    }

    public String getOrderLimit() {
        return orderLimit;
    }

    public void setOrderLimit(String orderLimit) {
        this.orderLimit = orderLimit;
    }

    public double getGetPrice() {
        return getPrice;
    }

    public void setGetPrice(double getPrice) {
        this.getPrice = getPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "InventoryDTO{" +
                "inventoryId=" + inventoryId +
                ", text='" + text + '\'' +
                ", description='" + description + '\'' +
                ", orderQty=" + orderQty +
                ", type='" + type + '\'' +
                ", orderLimit='" + orderLimit + '\'' +
                ", getPrice=" + getPrice +
                ", sellingPrice=" + sellingPrice +
                ", date=" + date +
                ", supplierId=" + supplierId +
                ", orderId=" + orderId +
                ", orderHolder=" + orderHolder +
                ", newOrderQty=" + newOrderQty +
                ", checkComplete=" + checkComplete +
                ", noticeId=" + noticeId +
                '}';
    }
}//End Class


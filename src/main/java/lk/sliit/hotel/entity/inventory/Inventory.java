package lk.sliit.hotel.entity.inventory;

import lk.sliit.hotel.entity.SuperEntity;
//import lk.sliit.hotel.entity.barManage.BarOrderDetails;
import lk.sliit.hotel.entity.bar.BarOrderDetails;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Inventory implements SuperEntity {
    @Id
    private int inventoryId ;
    private String text;
    private String description;
    private double orderQty;
    private String type;
    private String orderLimit;
    private double price;
    private double sellingPrice;
    private Date date;
    @OneToMany(mappedBy = "inventory",cascade = {CascadeType.REMOVE,CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    private List<InventoryNotice> attendance = new ArrayList<>( );
    @OneToMany(mappedBy = "inventory",cascade ={ CascadeType.PERSIST ,CascadeType.REFRESH, CascadeType.DETACH,CascadeType.MERGE})
    private List<BarOrderDetails> orderDetails =new ArrayList<>();
    @OneToMany(mappedBy = "inventory",cascade ={ CascadeType.PERSIST ,CascadeType.REFRESH, CascadeType.DETACH,CascadeType.MERGE})
    private List<InventoryOrder> inventoryOrderDetails =new ArrayList<>();

    public Inventory() {}

    public Inventory(int inventoryId, String text, String description,
                     double orderQty, String type, String orderLimit,
                     double getPrice, double sellingPrice, Date date) {
        this.inventoryId = inventoryId;
        this.text = text;
        this.description = description;
        this.orderQty = orderQty;
        this.type = type;
        this.orderLimit = orderLimit;
        this.price = getPrice;
        this.sellingPrice = sellingPrice;
        this.date = date;

    }


    public List<InventoryNotice> getAttendance() {
        return attendance;
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
        return price;
    }

    public void setGetPrice(double getPrice) {
        this.price = getPrice;
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


}//End Class


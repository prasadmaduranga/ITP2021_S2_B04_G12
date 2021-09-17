package lk.sliit.hotel.entity.kitchen;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Menu {
    @Id
    private int menuId;
    private String name;
    private String type;
    private String picture;
    private double unitPrice;
//    @OneToMany(mappedBy = "menu", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
//    private List<BanquetOrder> banquetOrders = new ArrayList<>();
    @OneToMany(mappedBy = "menu", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    private List<MenuDetails> orderDetails = new ArrayList<>();

    public Menu(int menuId, String name, String type, String picture, double unitPrice) {
        this.menuId = menuId;
        this.name = name;
        this.type = type;
        this.picture = picture;
        this.unitPrice = unitPrice;

    }

    public Menu() {
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

//    public List<BanquetOrder> getBanquetOrders() {
//        return banquetOrders;
//    }
//
//    public void setBanquetOrders(List<BanquetOrder> banquetOrders) {
//        this.banquetOrders = banquetOrders;
//    }

    public List<MenuDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<MenuDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }
}

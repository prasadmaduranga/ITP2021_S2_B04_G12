package lk.sliit.hotel.entity.kitchen;

import lk.sliit.hotel.entity.restaurant.Report;
import lk.sliit.hotel.entity.restaurant.counterOrder.RestaurantCounterOrderDetail;
import lk.sliit.hotel.entity.restaurant.onlineOrder.RestaurantOnlineOrderDetails;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class FoodItem implements Serializable {
    @Id
    private int itemId;
    private String name;
    private double unitePrice;
    private String src;
    private String category;

    @OneToMany(mappedBy = "foodItem",cascade ={ CascadeType.PERSIST ,CascadeType.REFRESH, CascadeType.DETACH,CascadeType.MERGE})
    private List<MenuDetails> menuDetails =new ArrayList<>();
    @OneToMany(mappedBy = "foodItem", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    private List<Report> reports = new ArrayList<>();
    @OneToMany(mappedBy = "foodItem", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    private List<RestaurantCounterOrderDetail> restaurantCounterOrderDetails = new ArrayList<>();
    @OneToMany(mappedBy = "foodItem", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    private List<RestaurantOnlineOrderDetails> restaurantOnlineOrderDetails = new ArrayList<>();


    public FoodItem(int itemId, String name, double unitePrice, String src, String category) {
        this.itemId = itemId;
        this.name = name;
        this.unitePrice = unitePrice;
        this.src = src;
        this.category = category;
    }

    public FoodItem() {
    }



    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitePrice() {
        return unitePrice;
    }

    public void setUnitePrice(double unitePrice) {
        this.unitePrice = unitePrice;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

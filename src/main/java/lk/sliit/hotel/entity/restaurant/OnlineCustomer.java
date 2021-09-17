package lk.sliit.hotel.entity.restaurant;

import lk.sliit.hotel.entity.restaurant.onlineOrder.RestaurantOnlineOrder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class OnlineCustomer {
    @Id
    private int onlineCustomerId;
    private String name;
    private String userName;
    private String address;
    private String email;
    private String password;
    private String number;
    @OneToMany(mappedBy = "customer", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    private List<RestaurantOnlineOrder> restaurantOnlineOrders = new ArrayList<>();
//    @OneToMany(mappedBy = "customer", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
//    private List<OnlineTableReservation> onlineTableReservations = new ArrayList<>();

    public OnlineCustomer(int onlineCustomerId, String name, String userName, String address, String email, String password, String number) {

        this.onlineCustomerId = onlineCustomerId;
        this.name = name;
        this.userName = userName;
        this.address = address;
        this.email = email;
        this.password = password;
        this.number = number;
    }

    public OnlineCustomer() {
    }

    public int getOnlineCustomerId() {
        return onlineCustomerId;
    }

    public void setOnlineCustomerId(int onlineCustomerId) {
        this.onlineCustomerId = onlineCustomerId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

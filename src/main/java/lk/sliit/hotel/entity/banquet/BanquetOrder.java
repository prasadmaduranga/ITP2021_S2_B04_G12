package lk.sliit.hotel.entity.banquet;


import lk.sliit.hotel.dto.banquet.BanquetAddDTO;
import lk.sliit.hotel.entity.kitchen.Menu;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class BanquetOrder {

    @Id
    int orderId;
    Date date;
    String hallId;
    int noOfPlates;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name="menu",referencedColumnName = "menuId")
    private Menu menu;
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "banquetBill", referencedColumnName = "billId")
    private BanquetBill banquetBill;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "BanquetCustomer", referencedColumnName = "customerId")
    private BanquetCustomer banquetCustomer;
    String submittedBy;
    String orderState;


    public BanquetOrder(int orderId, String hallId, String orderState, int noOfPlates, Date date, String submittedBy, BanquetCustomer one, Menu menuDAOOne, lk.sliit.hotel.controller.banquetController.BanquetBill banquetBillDAOOne) {

    }


    public BanquetOrder(int orderId, String hallId, String orderState, int noOfPlates, Date date, String submittedBy,BanquetCustomer banquetCustomer, Menu menu, BanquetBill banquetBill) {
        this.orderId = orderId;
        this.hallId = hallId;
        this.orderState = orderState;
        this.noOfPlates = noOfPlates;
        this.date = date;
        this.submittedBy = submittedBy;
        this.banquetCustomer = banquetCustomer;
        this.menu = menu;
        this.banquetBill = banquetBill;
    }

    public BanquetOrder(int orderId, String hallId, String orderState, int noOfPlates, Date date,
                        String submittedBy, BanquetCustomer banquetCustomer, Menu menu) {

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

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public BanquetBill getBanquetBill() {
        return banquetBill;
    }

    public void setBanquetBill(BanquetBill banquetBill) {
        this.banquetBill = banquetBill;
    }

    public BanquetCustomer getBanquetCustomer() {
        return banquetCustomer;
    }

    public void setBanquetCustomer(BanquetCustomer banquetCustomer) {
        this.banquetCustomer = banquetCustomer;
    }

    public String getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(String submittedBy) {
        this.submittedBy = submittedBy;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }


    public BanquetCustomer getCustomer() {
        return banquetCustomer;

    }
}

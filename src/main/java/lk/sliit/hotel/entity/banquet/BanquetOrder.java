package lk.sliit.hotel.entity.banquet;

import lk.sliit.hotel.entity.kitchen.Menu;
import lk.sliit.hotel.entity.reservation.Customer;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
public class BanquetOrder {

    @Id
    private int orderId;
    private String hallId;
    private String orderState;
    private int noOfPlates;
    private Date date;
    private String submittedBy;

    //foreign key added
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH,  CascadeType.DETACH, CascadeType.MERGE })
    @JoinColumn(name="Menu", referencedColumnName = "menuId")
    private Menu menu;
    @OneToOne(cascade ={CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name="banquetBill", referencedColumnName="billId")
    private BanquetBill banquetBill;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH,CascadeType.DETACH,CascadeType.MERGE })
    @JoinColumn(name = "banquetCustomer", referencedColumnName = "banquetCustomerId")
    private BanquetCustomer banquetCustomer;


    public BanquetOrder() {
    }

    public BanquetOrder(int orderId, String hallId, String orderState, int noOfPlates, Date date, String submittedBy,
                        Menu menu, BanquetCustomer banquetCustomer, BanquetBill banquetBill  ) {
        this.orderId = orderId;
        this.hallId = hallId;
        this.orderState = orderState;
        this.noOfPlates = noOfPlates;
        this.date = date;
        this.submittedBy = submittedBy;
        this.banquetBill = banquetBill;
        this.banquetCustomer = banquetCustomer;
        this.menu = menu;

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

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public BanquetCustomer getBanquetCustomer() {
        return banquetCustomer;
    }

    public void setBanquetCustomer(BanquetCustomer banquetCustomer) {
        this.banquetCustomer = banquetCustomer;
    }

    public BanquetBill getBanquetBill() {
        return banquetBill;
    }

    public void setBanquetBill(BanquetBill banquetBill) {
        this.banquetBill = banquetBill;
    }
}

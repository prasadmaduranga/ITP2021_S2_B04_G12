package lk.sliit.hotel.entity.banquet;

import javax.persistence.Entity;
import javax.persistence.Id;
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
    // forieign key

    public BanquetOrder() {
    }

    public BanquetOrder(int orderId, String hallId, String orderState, int noOfPlates, Date date, String submittedBy) {
        this.orderId = orderId;
        this.hallId = hallId;
        this.orderState = orderState;
        this.noOfPlates = noOfPlates;
        this.date = date;
        this.submittedBy = submittedBy;

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
}

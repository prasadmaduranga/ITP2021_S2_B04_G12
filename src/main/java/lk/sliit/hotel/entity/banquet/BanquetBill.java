package lk.sliit.hotel.entity.banquet;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BanquetBill {
    @Id
    private int billId;
    private double total;
    private double foodPrice;
    private double otherPrice;
    private double advancePayment;



    public BanquetBill(int billId, double total, double foodPrice, double otherPrice, double advancePayment) {
        this.billId = billId;
        this.total = total;
        this.foodPrice = foodPrice;
        this.otherPrice = otherPrice;
        this.advancePayment = advancePayment;
    }


    public BanquetBill() {

    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
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

    public double getAdvancePayment() {
        return advancePayment;
    }

    public void setAdvancePayment(double advancePayment) {
        this.advancePayment = advancePayment;
    }
}

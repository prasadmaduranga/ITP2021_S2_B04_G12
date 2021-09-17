package lk.sliit.hotel.entity.banquet;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BanquetBill {
    @Id
    int billId;
    double advancePayment;
    double foodPrice;
    double otherPrice;
    double total;

    public BanquetBill(int billId, double advancePayment, double foodPrice, double otherPrice, double total) {
        this.billId = billId;
        this.advancePayment = advancePayment;
        this.foodPrice = foodPrice;
        this.otherPrice = otherPrice;
        this.total = total;
    }

    public BanquetBill() {

    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public double getAdvancePayment() {
        return advancePayment;
    }

    public void setAdvancePayment(double advancePayment) {
        this.advancePayment = advancePayment;
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

    public double getOtherPrices() {
        return otherPrice;
    }
}


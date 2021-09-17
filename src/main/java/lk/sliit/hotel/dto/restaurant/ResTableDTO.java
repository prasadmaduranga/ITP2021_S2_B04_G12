package lk.sliit.hotel.dto.restaurant;

public class ResTableDTO {
    int tableId;
    int reseId;
    //String foodName;
    double quantity;
    double price;
    double totalPrice;
    double sellingRateOnline;
    double sellingRateCounter;

    public ResTableDTO() {
    }

    public ResTableDTO(int tableId, int reseId, double quantity, double price) {
        this.tableId = tableId;
        this.reseId = reseId;
        this.quantity = quantity;
        this.price = price;
    }

    public ResTableDTO(int tableId, int reseId, double quantity, double price, double totalPrice, double sellingRateOnline, double sellingRateCounter) {
        this.tableId = tableId;
        this.reseId = reseId;
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = totalPrice;
        this.sellingRateOnline = sellingRateOnline;
        this.sellingRateCounter = sellingRateCounter;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public int getReseId() {
        return reseId;
    }

    public void setReseId(int reseId) {
        this.reseId = reseId;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getSellingRateOnline() {
        return sellingRateOnline;
    }

    public void setSellingRateOnline(double sellingRateOnline) {
        this.sellingRateOnline = sellingRateOnline;
    }

    public double getSellingRateCounter() {
        return sellingRateCounter;
    }

    public void setSellingRateCounter(double sellingRateCounter) {
        this.sellingRateCounter = sellingRateCounter;
    }
}

package lk.sliit.hotel.dto.restaurant;

public class RestaurantTableDTO {
    private int tableId;
    private String type;
    private double unitPrice;
    private String place;


    public RestaurantTableDTO() {
    }

    public RestaurantTableDTO(int tableId, String type, double unitPrice) {
        this.tableId = tableId;
        this.type = type;
        this.unitPrice = unitPrice;
    }

    public RestaurantTableDTO(int tableId, String type, double unitPrice, String place) {
        this.tableId = tableId;
        this.type = type;
        this.unitPrice = unitPrice;
        this.place = place;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public RestaurantTableDTO(int tableId) {
        this.tableId = tableId;
    }

    public int getTableId() {
        return tableId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    @Override
    public String toString() {
        return "RestaurantTableDTO{" +
                "tableId='" + tableId + '\'' +
                ", type='" + type + '\'' +
                ", unitPrice=" + unitPrice +
                '}';
    }
}

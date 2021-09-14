package lk.sliit.hotel.entity.restaurant;

import lk.sliit.hotel.entity.restaurant.counterTableReservation.CounterTableReservationDetails;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class RestaurantTable {
    @Id
    private int tableId;
    private String type;
    private String place;
//    @OneToMany(mappedBy = "tableId", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
//    private List<OnlineTableReservationDetails> orderDetails = new ArrayList<>();
    @OneToMany(mappedBy = "tableId", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    private List<CounterTableReservationDetails> counterTableReservationDetails = new ArrayList<>();

    public RestaurantTable(int tableId, String type) {
        this.tableId = tableId;
        this.type = type;
    }

    public RestaurantTable(int tableId, String type,  String place) {
        this.tableId = tableId;
        this.type = type;
        this.place = place;
    }



    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public RestaurantTable(int tableId) {
        this.tableId = tableId;
    }

    public RestaurantTable() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }
}

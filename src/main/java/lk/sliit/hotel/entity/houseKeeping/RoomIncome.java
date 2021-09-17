package lk.sliit.hotel.entity.houseKeeping;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class RoomIncome {
    @Id
    private int id;
    private Date date;
    private double price;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "roomId", referencedColumnName = "roomId", insertable = false, updatable = false)
    private HotelRoom roomId;


    public RoomIncome(int id, Date date, double price, HotelRoom roomId) {
        this.id = id;
        this.date = date;
        this.price = price;
        this.roomId = roomId;
    }

    public RoomIncome() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public HotelRoom getRoomId() {
        return roomId;
    }

    public void setRoomId(HotelRoom roomId) {
        this.roomId = roomId;
    }
}

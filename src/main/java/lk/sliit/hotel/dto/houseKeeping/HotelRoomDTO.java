package lk.sliit.hotel.dto.houseKeeping;

import java.sql.Date;

public class HotelRoomDTO {
    private int roomId2;
    private String roomType;
    private String description;
    private double price;
    private String roomName;
    private Date date;
    private String status;
    private int holder;
    private String getRoomId2;



    public HotelRoomDTO() {
    }

    public HotelRoomDTO(int roomId) {
        this.roomId2 = roomId;
    }

    public HotelRoomDTO(int roomId2, String roomName, String roomType, String description,
                        String status, int holder, double price, Date date) {
        this.roomId2 = roomId2;
        this.roomName = roomName;
        this.roomType = roomType;
        this.description = description;
        this.status = status;
        this.holder = holder;
        this.price = price;
        this.date = date;
    }


    public String getGetRoomId2() {
        return getRoomId2;
    }

    public void setGetRoomId2(String getRoomId2) {
        this.getRoomId2 = getRoomId2;
    }

    public int getRoomId2() {
        return roomId2;
    }

    public void setRoomId2(int roomId2) {
        this.roomId2 = roomId2;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRoomName() { return roomName; }

    public void setRoomName(String roomName) { this.roomName = roomName; }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public int getHolder() { return holder;}

    public String getType() { return roomType; }

    public void setHolder(int holder) {
        this.holder = holder;
    }

    @Override
    public String toString() {
        return "HotelRoomDTO{" +
                "roomId2='" + roomId2 + '\'' +
                ", roomType='" + roomType + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", roomName='" + roomName + '\'' +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", holder='" + holder + '\'' +
                '}';
    }
}

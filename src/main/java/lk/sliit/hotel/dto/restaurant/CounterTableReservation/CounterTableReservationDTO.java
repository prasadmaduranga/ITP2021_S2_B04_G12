package lk.sliit.hotel.dto.restaurant.CounterTableReservation;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Time;
import java.util.Date;

public class CounterTableReservationDTO {
    private int counterTableReserveId;
    @Temporal(TemporalType.TIME)
    private Time startTime;
    @Temporal(TemporalType.TIME)
    private Time endTime;
    private int noOfTables;
    @Temporal(TemporalType.DATE)
    private Date date;
    private String vStatT;
    private String vEndT;
    private String vDate;
    private String type;
    private String orderData;
    private String place;

    public CounterTableReservationDTO(int counterTableReserveId, Time startTime, Time endTime, int noOfTables, Date date,String place) {
        this.counterTableReserveId = counterTableReserveId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.noOfTables = noOfTables;
        this.date = date;
        this.place=place;
    }



    public CounterTableReservationDTO(int onlineTableReservationId, Date startTime, Date endTime, String type,String place) {
        this.counterTableReserveId = onlineTableReservationId;
        this.startTime = (Time) startTime;
        this.endTime = (Time) endTime;
        this.type = type;
        this.place=place;
    }

    public CounterTableReservationDTO(int counterTableReserveId) {
        this.counterTableReserveId = counterTableReserveId;
    }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public CounterTableReservationDTO() {
    }

    public String getOrderData() {
        return orderData;
    }

    public void setOrderData(String orderData) {
        this.orderData = orderData;
    }

    public int getCounterTableReserveId() {
        return counterTableReserveId;
    }

    public void setCounterTableReserveId(int counterTableReserveId) {
        this.counterTableReserveId = counterTableReserveId;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public int getNoOfTables() {
        return noOfTables;
    }

    public void setNoOfTables(int noOfTables) {
        this.noOfTables = noOfTables;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getvStatT() { return vStatT; }

    public void setvStatT(String vStatT) { this.vStatT = vStatT; }


    public String getvEndT() { return vEndT; }

    public void setvEndT(String vEndT) { this.vEndT = vEndT; }

    public String getvDate() { return vDate; }

    public void setvDate(String vDate) { this.vDate = vDate; }


    @Override
    public String toString() {
        return "CounterTableReservationDTO{" +
                "counterTableReserveId='" + counterTableReserveId + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", noOfTables=" + noOfTables +
                ", date=" + date +
                ", vStatT='" + vStatT + '\'' +
                ", vEndT='" + vEndT + '\'' +
                ", vDate='" + vDate + '\'' +
                '}';
    }
}

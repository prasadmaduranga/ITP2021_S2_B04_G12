package lk.sliit.hotel.entity.banquet;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class OnlineOrder {
    @Id
    private int onlineNo;
    private int orderId;
    private int customerId;
    private Date orderDate;
    private Date bookingDate;
    private String name;
    private String email;
    private String contactNo;
}

package lk.sliit.hotel.entity.banquet;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BanquetCustomer {
    @Id
    private int banquetCustomerId;
    private String email;
    private String name;
    private String address;
    private String contactNumber;

    public int getBanquetCustomerId() {
        return banquetCustomerId;
    }

    public void setBanquetCustomerId(int banquetCustomerId) {
        this.banquetCustomerId = banquetCustomerId;
    }

    public BanquetCustomer() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "BanquetCustomer{" +
                "banquetCustomerId=" + banquetCustomerId +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }
}

package lk.sliit.hotel.dto.banquet;

public class BanquetCustomerDTO {

    private int banquetCustomerId;
    private String email;
    private String name;
    private String address;
    private String contactNumber;

    public BanquetCustomerDTO(int customerId){

    }

    public BanquetCustomerDTO(int banquetCustomerId, String email, String name, String address, String contactNumber) {
        this.banquetCustomerId = banquetCustomerId;
        this.email = email;
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
    }

    public int getBanquetCustomerId() {
        return banquetCustomerId;
    }

    public void setBanquetCustomerId(int banquetCustomerId) {
        this.banquetCustomerId = banquetCustomerId;
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
        return "BanquetCustomerDTO{" +
                "banquetCustomerId=" + banquetCustomerId +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }
}

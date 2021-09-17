package lk.sliit.hotel.entity.banquet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class BanquetCustomer{
   @Id
   int customerId;
   String name;
   String email;
   String address;

   public BanquetCustomer(int customerId, String email, String name, String address,String contactNumber) {
      this.customerId = customerId;
      this.email = email;
      this.name =name;
      this.address = address;
      this.contactNo = contactNumber;
   }

   public BanquetCustomer() {

   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   public String getContactNo() {
      return contactNo;
   }

   public void setContactNo(String contactNo) {
      this.contactNo = contactNo;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public List<BanquetOrder> getBanquetOrders() {
      return banquetOrders;
   }

   public void setBanquetOrders(List<BanquetOrder> banquetOrders) {
      this.banquetOrders = banquetOrders;
   }

   String contactNo;
//   String userName;
   String password;
   @OneToMany(mappedBy = "banquetCustomer", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
   private List<BanquetOrder> banquetOrders = new ArrayList<>();


   public int getCustomerId() {
      return customerId;
   }

   public void setCustomerId(int customerId) {
      this.customerId = customerId;
   }
}

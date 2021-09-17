package lk.sliit.hotel.entity.inventory;

import javax.persistence.*;
import java.sql.Date;


@Entity
public class InventoryOrder {
    @Id
    private int orderId;
    private Date date;
    private double price;
    private double quantity;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "supplier", referencedColumnName = "id", nullable = false)
    private Supplier supplier;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "inventory", referencedColumnName = "inventoryId", nullable = false)
    private Inventory inventory;

    public InventoryOrder(int orderId, Date date, double price, double quantity, Supplier supplier, Inventory inventory) {
        this.orderId = orderId;
        this.date = date;
        this.price = price;
        this.quantity = quantity;
        this.supplier = supplier;
        this.inventory = inventory;
    }

    public InventoryOrder() {
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }



}

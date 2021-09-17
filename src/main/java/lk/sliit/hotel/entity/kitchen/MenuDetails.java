package lk.sliit.hotel.entity.kitchen;

import javax.persistence.*;

@Entity
public class MenuDetails {
    @EmbeddedId
    private MenuDetailsPK menuDetailId;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name="foodItem",referencedColumnName = "itemId", insertable = false, updatable = false)
    private FoodItem foodItem;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name="menu",referencedColumnName = "menuId", insertable = false, updatable = false)
    private Menu menu;


    public MenuDetails() {
    }

    public MenuDetails(MenuDetailsPK menuDetailId) {
        this.menuDetailId = menuDetailId;
    }

    public MenuDetails(int menu, int foodItem) {
        this.menuDetailId = new MenuDetailsPK(menu,foodItem);

    }

    public MenuDetailsPK getMenuDetailId() {
        return menuDetailId;
    }

    public void setMenuDetailId(MenuDetailsPK menuDetailId) {
        this.menuDetailId = menuDetailId;
    }

    public FoodItem getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(FoodItem foodItem) {
        this.foodItem = foodItem;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}

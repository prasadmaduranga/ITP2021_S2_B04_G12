package lk.sliit.hotel.dao.kitchenDAO;

import lk.sliit.hotel.entity.kitchen.FoodItem;
import lk.sliit.hotel.entity.kitchen.Menu;
import lk.sliit.hotel.entity.kitchen.MenuDetails;
import org.springframework.data.repository.CrudRepository;

public interface MenuDetailsDAO extends CrudRepository<MenuDetails, Integer> {

    void deleteMenuDetailsByFoodItemEquals(FoodItem id);

    void deleteMenuDetailsByFoodItemAndMenuEquals(FoodItem foodItem, Menu menu);


    Iterable<MenuDetails> findMenuDetailsByMenu_MenuId(int menuId);
}

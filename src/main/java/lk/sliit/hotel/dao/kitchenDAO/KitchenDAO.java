package lk.sliit.hotel.dao.kitchenDAO;


import lk.sliit.hotel.entity.kitchen.FoodItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface KitchenDAO extends CrudRepository<FoodItem,Integer> {
    FoodItem findTopByOrderByItemIdDesc();

    Iterable<FoodItem> findAllByCategoryEquals(String restaurant);

    @Query(value = "from FoodItem where category=?1")
    Iterable<FoodItem> findAllIngredients(String category);
}
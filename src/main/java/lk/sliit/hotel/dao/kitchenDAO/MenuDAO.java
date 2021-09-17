package lk.sliit.hotel.dao.kitchenDAO;


import lk.sliit.hotel.entity.kitchen.Menu;
import org.springframework.data.repository.CrudRepository;

public interface MenuDAO extends CrudRepository<Menu,Integer> {
    Menu findTopByOrderByMenuIdDesc();

   /*
    //@Query (value = "from Menu where type =?1")
    Iterable<Menu> findAllByTypeEquals(String type);

    int findTopByMenuIdAndTypeEquals(String type);

    @Query (value = "select min(menuId) from Menu where type = ?1")
    int findMinMenuIdByType(String type);
   */

    Iterable<Menu> findMenuByMenuId(int menuId);
}

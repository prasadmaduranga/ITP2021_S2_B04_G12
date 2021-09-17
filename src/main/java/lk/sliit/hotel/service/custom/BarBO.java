package lk.sliit.hotel.service.custom;

import lk.sliit.hotel.dto.bar.BarOrderDTO;
import lk.sliit.hotel.dto.inventory.InventoryDTO;
import lk.sliit.hotel.service.SuperBO;

import java.util.List;

public interface BarBO extends SuperBO {
    List<InventoryDTO> findAllBeverageItems(String s);

    List<BarOrderDTO> findAllBarOrders();

    void saveBarOrder(BarOrderDTO barOrderDTO);

    BarOrderDTO findTopByOrderByBarIdDesc();

    InventoryDTO findById(int itemCode);
}

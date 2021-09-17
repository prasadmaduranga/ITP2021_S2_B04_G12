package lk.sliit.hotel.service.custom;

import lk.sliit.hotel.dto.inventory.*;
import lk.sliit.hotel.service.SuperBO;

import java.util.List;

public interface InventoryBO extends SuperBO {
    List<ItemTypeDTO> findAll();

    List<InventoryDTO> findAllInventory();

    void saveInventoryItem(InventoryDTO inventoryDTO);

// Inventory Notice Load

    List<InventoryNoticeDTO> findDayAfterTomorrowNotice();

    List<InventoryNoticeDTO> findTodayInventoryNotice();

    List<InventoryNoticeDTO> findTomorrowInventoryNotice();

    void deleteInventoryNotice(int noticeId);

    InventoryDTO findInventory(int inventoryId);

    void updateInventory(InventoryDTO inventoryDTO1);

    List<InventoryNoticeDTO> findAllInventoryNotice();

    void deleteInventoryType(int id);

    ItemTypeDTO findTopByOrderByIdDesc();

    void saveInventoryType(ItemTypeDTO inventoryDTO);

    void saveSupplier(SupplierDTO supplierDTO);

    List<SupplierDTO> findAllSuppliers();

    SupplierDTO findTopByOrderBySupplierIdDesc();

    void deleteSupplier(int userId);

    InventoryNoticeDTO findTopByBarNoticeIdDesc();

    void saveOrderNotice(InventoryNoticeDTO noticeDTO);

    InventoryDTO findTopByOrderByOrderIdDesc();

    boolean findOne(int supplierId);

    InventoryDTO findHighestId();

    InventoryDTO findFoodItemById(int inventoryId);

    List<InventoryDTO> findStockData(String  val);


    List<InventoryDTO> findAllBeverageItems();

    List<InventoryNoticeDTO> stockOrderNotices(String a);


    List<ItemTypeDTO> findInventoryDepartment();

    List<InventoryOrderDTO> loadInventoryOrders();

    List<InventoryOrderDTO> findInventoryBill(GetDateInventoryDTO getDateInventoryDTO);

    List<InventoryOrderDTO> findInventoryBillToday();
}

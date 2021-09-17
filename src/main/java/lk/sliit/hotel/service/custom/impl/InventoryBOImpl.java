package lk.sliit.hotel.service.custom.impl;

import lk.sliit.hotel.dao.inventoryDAO.*;
import lk.sliit.hotel.dto.inventory.*;
import lk.sliit.hotel.dto.reservation.ReservationDTO;
import lk.sliit.hotel.entity.inventory.*;
import lk.sliit.hotel.entity.reservation.Reservation;
import lk.sliit.hotel.service.custom.InventoryBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class InventoryBOImpl implements InventoryBO {

    @Autowired
    ItemTypeDAO itemTypeDAO;
    @Autowired
    InventoryDAO inventoryDAO;
    @Autowired
    InventoryNoticeDAO inventoryNoticeDAO;
    @Autowired
    InventoryOrderDAO inventoryOrderDAO;
    @Autowired
    SupplierDAO supplierDAO;

    @Override
    public List<ItemTypeDTO> findAll() {//find All department type
        Iterable<ItemType> all = itemTypeDAO.findAll();
        List<ItemTypeDTO> dtos = new ArrayList<>();
        for (ItemType a : all) {
            dtos.add(new ItemTypeDTO(
                    a.getId(),
                    a.getUserType(),
                    a.getSubmittedBy()
            ));
        }
        return dtos;
    }



    @Override
    public List<InventoryDTO> findAllInventory() {//Find all Inventory Items
        Iterable<Inventory> all = inventoryDAO.findAll();
        List<InventoryDTO> dtos = new ArrayList<>();
        for (Inventory a : all) {
            dtos.add(new InventoryDTO(
                    a.getInventoryId(),
                    a.getText(),
                    a.getDescription(),
                    a.getOrderQty(),
                    a.getType(),
                    a.getOrderLimit(),
                    a.getGetPrice(),
                    a.getSellingPrice(),
                    a.getDate()
            ));
        }
        return dtos;
    }

    @Override
    public void saveInventoryItem(InventoryDTO inventoryDTO) {//Save Inventory
        inventoryDAO.save(new Inventory(
                inventoryDTO.getInventoryId(),
                inventoryDTO.getText(),
                inventoryDTO.getDescription(),
                inventoryDTO.getOrderQty(),
                inventoryDTO.getType(),
                inventoryDTO.getOrderLimit(),
                inventoryDTO.getGetPrice(),
                inventoryDTO.getSellingPrice(),
                inventoryDTO.getDate()
        ));
    }

    @Override
    public List<InventoryNoticeDTO> findDayAfterTomorrowNotice() {//find All Notice DayAfterTomorrow
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 2);
        java.util.Date dayAfterTomorrow = cal.getTime();
        Iterable<InventoryNotice> allItems = inventoryNoticeDAO.findAllByExpDateAndStateEquals(dayAfterTomorrow,false);
        List<InventoryNoticeDTO> dtos = new ArrayList<>();
        for (InventoryNotice notice : allItems) {
            dtos.add(new InventoryNoticeDTO(
                    notice.getNoticeId(),
                    notice.getDepartment(),
                    notice.getOrderQty(),
                    notice.getDate(),
                    notice.getExpDate(),
                    notice.getOrderHolder(),
                    notice.isState(),
                    notice.getInventory().getInventoryId(),
                    notice.getInventory().getText(),
                    notice.getInventory().getOrderQty()
            ));
        }
        return dtos;
    }

    @Override
    public List<InventoryNoticeDTO> findTodayInventoryNotice() {//find All Notice Today
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 0);
        java.util.Date today = cal.getTime();
        Iterable<InventoryNotice> allItems = inventoryNoticeDAO.findAllByExpDateAndStateEquals(today,false);
        List<InventoryNoticeDTO> dtos = new ArrayList<>();
        for (InventoryNotice notice : allItems) {
            dtos.add(new InventoryNoticeDTO(
                    notice.getNoticeId(),
                    notice.getDepartment(),
                    notice.getOrderQty(),
                    notice.getDate(),
                    notice.getExpDate(),
                    notice.getOrderHolder(),
                    notice.isState(),
                    notice.getInventory().getInventoryId(),
                    notice.getInventory().getText(),
                    notice.getInventory().getOrderQty()
            ));
        }
        return dtos;
    }

    @Override
    public List<InventoryNoticeDTO> findTomorrowInventoryNotice() {//find All Notice Tomorrow state false(not confirmed)
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        java.util.Date tomorrow = cal.getTime();
        Iterable<InventoryNotice> allItems = inventoryNoticeDAO.findAllByExpDateAndStateEquals(tomorrow,false);
        List<InventoryNoticeDTO> dtos = new ArrayList<>();
        for (InventoryNotice notice : allItems) {
            dtos.add(new InventoryNoticeDTO(
                    notice.getNoticeId(),
                    notice.getDepartment(),
                    notice.getOrderQty(),
                    notice.getDate(),
                    notice.getExpDate(),
                    notice.getOrderHolder(),
                    notice.isState(),
                    notice.getInventory().getInventoryId(),
                    notice.getInventory().getText(),
                    notice.getInventory().getOrderQty()


            ));
        }
        return dtos;
    }

    /*@Override
    public InventoryNoticeDTO findInventoryNotice(String noticeId) {
        InventoryNotice notice = inventoryNoticeDAO.findOne (noticeId);
        return new InventoryNoticeDTO (
                notice.getNoticeId(),
                notice.getDepartment(),
                notice.getOrderQty(),
                notice.getDate(),
                notice.getExpDate(),
                notice.getOrderHolder(),
                notice.isState(),
                notice.getInventory().getInventoryId()
        );
    }*/

   /* @Override
    public void updateNoticeState(InventoryNoticeDTO notice) {
        inventoryNoticeDAO.save(new InventoryNotice(
                notice.getNoticeId(),
                notice.getDepartment(),
                notice.getOrderQty(),
                notice.getDate(),
                notice.getExpDate(),
                notice.getOrderHolder(),
                notice.isState(),
                inventoryDAO.findOne ( notice.getInventory() )
        ));
    }*/

    @Override//delete notice
    public void deleteInventoryNotice(int noticeId) {
        inventoryDAO.delete(noticeId);
    }


    @Override//Find inventory by id
    public InventoryDTO findInventory(int inventoryId) {
        Inventory notice = inventoryDAO.findOne(inventoryId);
        return new InventoryDTO(
                notice.getInventoryId(),
                notice.getText(),
                notice.getDescription(),
                notice.getOrderQty(),
                notice.getType(),
                notice.getOrderLimit(),
                notice.getGetPrice(),
                notice.getSellingPrice(),
                notice.getDate()
        );
    }

    @Transactional
    @Override//Update when supply order
    public void updateInventory(InventoryDTO inventoryDTO1) {
        try {
            InventoryOrder top = inventoryOrderDAO.findTopByOrderByOrderIdDesc();//Gen new id to order
            int x = (top.getOrderId()) + 1;
            inventoryDTO1.setOrderId((x));
        } catch (NullPointerException e) {
            inventoryDTO1.setOrderId((1));
        }

        inventoryOrderDAO.save(new InventoryOrder(//save order
                inventoryDTO1.getOrderId(),
                inventoryDTO1.getDate(),
                inventoryDTO1.getGetPrice(),
                inventoryDTO1.getNewOrderQty(),
                supplierDAO.findOne(inventoryDTO1.getSupplierId()),
                inventoryDAO.findOne(inventoryDTO1.getInventoryId())
        ));


        inventoryDAO.save(new Inventory(//save inventory
                inventoryDTO1.getInventoryId(),
                inventoryDTO1.getText(),
                inventoryDTO1.getDescription(),
                inventoryDTO1.getOrderQty(),
                inventoryDTO1.getType(),
                inventoryDTO1.getOrderLimit(),
                inventoryDTO1.getGetPrice(),
                inventoryDTO1.getSellingPrice(),
                inventoryDTO1.getDate()
        ));
        Inventory i3 = inventoryDAO.findOne(inventoryDTO1.getInventoryId());
        InventoryNotice all = inventoryNoticeDAO.findOne(inventoryDTO1.getNoticeId());
        if((i3.getOrderQty() >= all.getOrderQty())){

            all.setState(true);
            inventoryNoticeDAO.save(all);
        }


    }

    @Override// load all inventory
    public List<InventoryNoticeDTO> findAllInventoryNotice() {
        Iterable<InventoryNotice> all = inventoryNoticeDAO.findAll();
        List<InventoryNoticeDTO> dtos = new ArrayList<>();
        for (InventoryNotice a : all) {
            dtos.add(new InventoryNoticeDTO(
                    a.getNoticeId(),
                    a.getDepartment(),
                    a.getOrderQty(),
                    a.getDate(),
                    a.getExpDate(),
                    a.getOrderHolder(),
                    a.isState(),
                    a.getInventory().getInventoryId(),
                    a.getInventory().getText(),
                    a.getInventory().getOrderQty()
            ));
        }
        return dtos;
    }

    @Override//delete department type
    public void deleteInventoryType(int id) {
        itemTypeDAO.delete(id);
    }

    @Override
    public ItemTypeDTO findTopByOrderByIdDesc() {//find top department type
        ItemType itemType = null;
        try {
            itemType = itemTypeDAO.findTopByOrderByIdDesc();
        } catch (Exception e) {
            // Logger.getLogger("lk.sliit.project.employeeManagement.service.custom.impl").log(Level.SEVERE, null,e); //Add Logger To Catch Exception
        }
        return new ItemTypeDTO(
                itemType.getId()
        );
    }//End Get Total Emp

    @Override
    public void saveInventoryType(ItemTypeDTO inventoryDTO) {//save department type
        itemTypeDAO.save(new ItemType(
                inventoryDTO.getId(),
                inventoryDTO.getUserType(),
                inventoryDTO.getSubmittedBy()
        ));
    }

    @Override
    public void saveSupplier(SupplierDTO supplierDTO) {//supplier save
        supplierDAO.save(new Supplier(
                supplierDTO.getId(),
                supplierDTO.getName(),
                supplierDTO.getAddress(),
                supplierDTO.getMobile(),
                supplierDTO.getEmail(),
                supplierDTO.getGender(),
                supplierDTO.getDate(),
                supplierDTO.getBirthday(),
                supplierDTO.getSubmittedBy(),
                supplierDTO.getImage()
        ));
    }

    @Override
    public List<SupplierDTO> findAllSuppliers() {//Find all supplier
        Iterable<Supplier> all = supplierDAO.findAll();
        List<SupplierDTO> dtos = new ArrayList<>();
        for (Supplier a : all) {
            dtos.add(new SupplierDTO(
                    a.getId(),
                    a.getName(),
                    a.getAddress(),
                    a.getMobile(),
                    a.getEmail(),
                    a.getGender(),
                    a.getDate(),
                    a.getBirthday(),
                    a.getSubmittedBy(),
                    a.getImage()
            ));
        }
        return dtos;

    }

    @Override
    public SupplierDTO findTopByOrderBySupplierIdDesc() {//find top supplier id to generate id
        Supplier supplier = null;
        try {
            supplier = supplierDAO.findTopByOrderByIdDesc();
        } catch (Exception e) {
            // Logger.getLogger("lk.sliit.project.employeeManagement.service.custom.impl").log(Level.SEVERE, null,e); //Add Logger To Catch Exception
        }
        return new SupplierDTO(
                supplier.getId()
        );
    }//End Get Total

    @Override
    public void deleteSupplier(int userId) {
        supplierDAO.delete(userId);
    }//delete supplier

    @Override
    public InventoryNoticeDTO findTopByBarNoticeIdDesc() {
        InventoryNotice notice = null;
        try {
            notice = inventoryNoticeDAO.findTopByOrderByNoticeIdDesc();
        } catch (Exception e) {
        }
        return new InventoryNoticeDTO(
                notice.getNoticeId()
        );
    }//End Get Total

    @Override
    public void saveOrderNotice(InventoryNoticeDTO noticeDTO) {//Add order notice to inventory
        noticeDTO.setDepartment("Beverage");
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        noticeDTO.setDate(date);
        noticeDTO.setState(false);
        try {
            InventoryNotice notice = inventoryNoticeDAO.findInventoryNoticeByInventoryAndExpDateEquals(//If already have notice in today update notice
                    inventoryDAO.findOne(noticeDTO.getInventoryId()), noticeDTO.getExpDate());
            noticeDTO.setNoticeId(notice.getNoticeId());
            noticeDTO.setOrderQty((noticeDTO.getOrderQty() + notice.getOrderQty()));
        } catch (Exception e) {
        }

        inventoryNoticeDAO.save(new InventoryNotice(
                noticeDTO.getNoticeId(),
                noticeDTO.getDepartment(),
                noticeDTO.getOrderQty(),
                noticeDTO.getDate(),
                noticeDTO.getExpDate(),
                noticeDTO.getOrderHolder(),
                noticeDTO.isState(),
                inventoryDAO.findOne(noticeDTO.getInventoryId())

        ));
    }

    @Override//top online order
    public InventoryDTO findTopByOrderByOrderIdDesc() {
        InventoryOrder orders = null;
        try {
            orders = inventoryOrderDAO.findTopByOrderByOrderIdDesc();
        } catch (Exception e) {

        }
        return new InventoryDTO(
                orders.getOrderId()
        );
    }//End

    @Override
    public boolean findOne(int supplierId) {//find supplier
        System.out.println(supplierId + "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
        Supplier supplier = null;
        try {
            supplier = supplierDAO.findOne(supplierId);
            return true;
        } catch (NullPointerException f) {
            return false;
        }
    }

    @Override
    public InventoryDTO findHighestId() {
        Inventory a = inventoryDAO.findTopByOrderByInventoryIdDesc();

        return new InventoryDTO(
                a.getInventoryId()
        );

    }

    @Override
    public InventoryDTO findFoodItemById(int inventoryId) {//find food item (find one)
        Inventory inventoryDTO1 = inventoryDAO.findOne(inventoryId);
        return new InventoryDTO(
                inventoryDTO1.getInventoryId(),
                inventoryDTO1.getText(),
                inventoryDTO1.getDescription(),
                inventoryDTO1.getOrderQty(),
                inventoryDTO1.getType(),
                inventoryDTO1.getOrderLimit(),
                inventoryDTO1.getGetPrice(),
                inventoryDTO1.getSellingPrice(),
                inventoryDTO1.getDate()
        );


    }

    @Override
    public List<InventoryDTO> findStockData(String  val) { //find all dep type equal
        Iterable<Inventory> all = inventoryDAO.findAllByTypeEquals(val);
        List<InventoryDTO> dtos = new ArrayList<>();
        for (Inventory a : all) {
            dtos.add(new InventoryDTO(
                    a.getInventoryId(),
                    a.getText(),
                    a.getDescription(),
                    a.getOrderQty(),
                    a.getType(),
                    a.getOrderLimit(),
                    a.getGetPrice(),
                    a.getSellingPrice(),
                    a.getDate()
            ));
        }
        return dtos;
    }
    @Override
    public List<InventoryDTO> findAllBeverageItems() {//Find all inventory items type beverage
        Iterable<Inventory> all = inventoryDAO.findAllByTypeEquals("Beverage");
        List<InventoryDTO> dtos = new ArrayList<>();
        for (Inventory a : all) {
            dtos.add(new InventoryDTO(
                    a.getInventoryId(),
                    a.getText(),
                    a.getDescription(),
                    a.getOrderQty(),
                    a.getType(),
                    a.getOrderLimit(),
                    a.getGetPrice(),
                    a.getSellingPrice(),
                    a.getDate()
            ));
        }
        return dtos;
    }

    @Override//find all notice within 7 days
    public List<InventoryNoticeDTO> stockOrderNotices(String val) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -7);
        java.util.Date beforeweek = cal.getTime();
        Date todaya = new Date();
        Iterable<InventoryNotice> allItems =
                inventoryNoticeDAO.findAllByDateBetweenAndDepartmentEquals(beforeweek,todaya,val);
        List<InventoryNoticeDTO> dtos = new ArrayList<>();
        for (InventoryNotice notice : allItems) {
            dtos.add(new InventoryNoticeDTO(
                    notice.getNoticeId(),
                    notice.getDepartment(),
                    notice.getOrderQty(),
                    notice.getDate(),
                    notice.getExpDate(),
                    notice.getOrderHolder(),
                    notice.isState(),
                    notice.getInventory().getInventoryId(),
                    notice.getInventory().getText(),
                    notice.getInventory().getOrderQty()
            ));
        }
        return dtos;
    }

    @Override//Load all InventoryDepartments
    public List<ItemTypeDTO> findInventoryDepartment() {
        Iterable<ItemType> allItems = itemTypeDAO.findAll();
        List<ItemTypeDTO> dtos = new ArrayList<>();
        for (ItemType itemType : allItems) {
            dtos.add(new ItemTypeDTO(
                    itemType.getId(),
                    itemType.getUserType(),
                    itemType.getSubmittedBy()
            ));
        }
        return dtos;
    }

    @Override//load inventory orders
    public List<InventoryOrderDTO> loadInventoryOrders() {
        Date todaydate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -7);
        java.util.Date beforeWeek = cal.getTime();
        Iterable<InventoryOrder> allItems = inventoryOrderDAO.findAllByDateBetween(beforeWeek,todaydate);
        List<InventoryOrderDTO> dtos = new ArrayList<>();
        for (InventoryOrder itemType : allItems) {
            dtos.add(new InventoryOrderDTO(
                    itemType.getOrderId(),
                    itemType.getDate(),
                    itemType.getPrice(),
                    itemType.getQuantity(),
                    itemType.getSupplier().getId(),
                    itemType.getSupplier().getName(),
                    itemType.getInventory().getInventoryId(),
                    itemType.getInventory().getText()

            ));
        }
        return dtos;
    }


    @Override//load inventory Bills
    public List<InventoryOrderDTO> findInventoryBill(GetDateInventoryDTO getDateInventoryDTO) {
        List<InventoryOrderDTO> inventoryOrderDTOS = new ArrayList<>();
        Iterable<InventoryOrder> iterable =
                inventoryOrderDAO.findAllByDateBetween(getDateInventoryDTO.getDateIn(),getDateInventoryDTO.getDateOut());

        for (InventoryOrder reservation : iterable) {
            inventoryOrderDTOS.add(new InventoryOrderDTO(
                    reservation.getOrderId(),
                    reservation.getDate(),
                    reservation.getPrice(),
                    reservation.getQuantity(),
                    reservation.getSupplier().getName(),
                    reservation.getInventory().getText()
            ));
        }
        return inventoryOrderDTOS;
    }

    @Override
    public List<InventoryOrderDTO> findInventoryBillToday() {
        List<InventoryOrderDTO> inventoryOrderDTOS = new ArrayList<>();
        Iterable<InventoryOrder> iterable =
                inventoryOrderDAO.findAllByDateEquals(new Date());

        for (InventoryOrder reservation : iterable) {
            inventoryOrderDTOS.add(new InventoryOrderDTO(
                    reservation.getOrderId(),
                    reservation.getDate(),
                    reservation.getPrice(),
                    reservation.getQuantity(),
                    reservation.getSupplier().getName(),
                    reservation.getInventory().getText()
            ));
        }
        return inventoryOrderDTOS;
    }


}

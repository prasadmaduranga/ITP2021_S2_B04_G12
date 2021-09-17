package lk.sliit.hotel.service.custom.impl;

import lk.sliit.hotel.dao.barDAO.BarOrdersDAO;
import lk.sliit.hotel.dao.barDAO.BarOrdersDetailsDAO;
import lk.sliit.hotel.dao.inventoryDAO.InventoryDAO;
import lk.sliit.hotel.dto.bar.BarOrderDTO;
import lk.sliit.hotel.dto.bar.BarOrderDetailDTO;
import lk.sliit.hotel.dto.inventory.InventoryDTO;
import lk.sliit.hotel.entity.bar.BarOrderDetails;
import lk.sliit.hotel.entity.bar.BarOrders;
import lk.sliit.hotel.entity.inventory.Inventory;
import lk.sliit.hotel.service.custom.BarBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
@Transactional
public class BarBOImpl implements BarBO {

    @Autowired
    InventoryDAO inventoryDAO;
    @Autowired
    BarOrdersDAO barOrdersDAO;
    @Autowired
    BarOrdersDetailsDAO barOrdersDetailsDAO;

    @Override//All beverage items
    public List<InventoryDTO> findAllBeverageItems(String s) {
        Iterable<Inventory> all = inventoryDAO.findAllByTypeEquals(s);
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

    @Override//Find all bar Orders
    public List<BarOrderDTO> findAllBarOrders() {
        Iterable<BarOrders> all = barOrdersDAO.findAll();
        List<BarOrderDTO> dtos = new ArrayList<>();
        for (BarOrders a : all) {
            dtos.add(new BarOrderDTO(
                    a.getOrderId(),
                    a.getCustomerId(),
                    a.getUser()
            ));
        }
        return dtos;
    }

    @Transactional
    @Override//Spilt String and save bar
    public void saveBarOrder(BarOrderDTO barOrderDTO) {

        List<BarOrderDetailDTO> list = new ArrayList<BarOrderDetailDTO>();
        String arr = barOrderDTO.getOrderData();
        String yo[] = arr.split(" ");
        int count = 0;
        BarOrderDetailDTO itm = new BarOrderDetailDTO();
        for(String str:yo) {
            if(count == 0 ) {
                itm = new BarOrderDetailDTO();
                itm.setItemCode(Integer.parseInt(str));
                count ++;

            }else if(count == 1) {
                itm.setItemPrice(Double.parseDouble(str));
                count ++;

            }else if(count == 2) {
                itm.setQty(Double.parseDouble(str));
                list.add(itm);
                count = 0;
            }
        }

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 0);
        java.util.Date today =  cal.getTime();
        barOrderDTO.setDate(today);
        barOrdersDAO.save(new BarOrders (
                barOrderDTO.getId (),
                barOrderDTO.getDate(),
                barOrderDTO.getCustomerId (),
                barOrderDTO.getUser ()));

        for (BarOrderDetailDTO orderDetail :list ) {
            barOrdersDetailsDAO.save(new BarOrderDetails(
                    barOrderDTO.getId (), orderDetail.getItemCode(),
                    orderDetail.getItemPrice(), orderDetail.getQty()));
            Inventory inventory = inventoryDAO.findOne(orderDetail.getItemCode());
            inventory.setOrderQty(inventory.getOrderQty() - orderDetail.getQty());
            inventoryDAO.save(inventory);
        }
    }

    @Override//Find Top Bar Order Id
    public BarOrderDTO findTopByOrderByBarIdDesc() {
        BarOrders orders = null;
        try {
            orders = barOrdersDAO.findTopByOrderByOrderIdDesc ();
        }catch (Exception e){

        }
        return new BarOrderDTO(
                orders.getOrderId ()
        );
    }//End

    @Override//Find One
    public InventoryDTO findById(int itemCode) {
        Inventory a = inventoryDAO.findOne(itemCode);
        InventoryDTO menuDTO = new InventoryDTO(
                a.getInventoryId(),
                a.getText(),
                a.getDescription(),
                a.getOrderQty(),
                a.getType(),
                a.getOrderLimit(),
                a.getGetPrice(),
                a.getSellingPrice(),
                a.getDate());
        return menuDTO;
    }



}

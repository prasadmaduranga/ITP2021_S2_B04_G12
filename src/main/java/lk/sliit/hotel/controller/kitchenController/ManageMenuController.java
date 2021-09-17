package lk.sliit.hotel.controller.kitchenController;

import lk.sliit.hotel.controller.SuperController;
import lk.sliit.hotel.dto.kitchen.FoodItemDTO;
import lk.sliit.hotel.dto.kitchen.MenuDTO;
import lk.sliit.hotel.dto.kitchen.MenuDetailsDTO;
import lk.sliit.hotel.service.custom.IndexLoginBO;
import lk.sliit.hotel.service.custom.KitchenBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ManageMenuController {
    @Autowired
    IndexLoginBO indexLoginBO;

    @Autowired
    KitchenBO kitchenBO;

    String alertMsg = null;

    @PostMapping("/FoodPacks")
    public String addFoodPack(Model model, @ModelAttribute MenuDTO menuDTO) {
        alertMsg = null;
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        model.addAttribute("alert",alertMsg);
        model.addAttribute("menuCategories", KitchenUtil.menuCategories);

        try {
            MenuDTO menuItem = kitchenBO.findHighestFoodPackId();
            MenuDTO menuDTO1 = null;
            try {
                menuDTO1 = kitchenBO.findMenuItemById(menuDTO.getMenuId());
            } catch (NullPointerException d) {
                int maxId = (menuItem.getMenuId());
                if (menuDTO.getMenuId() == (maxId)) {
                    menuDTO.setMenuId((maxId));
                } else {
                    maxId++;
                    menuDTO.setMenuId((maxId));
                }
            }

        } catch (NullPointerException e) {
            menuDTO.setMenuId(1);
        }
        kitchenBO.saveMenuItem(menuDTO);
        return "redirect:/manageFoodPacks";
    }

    @GetMapping("/manageFoodPacks")
    public String foodPackPage(Model model) {
        alertMsg = null;
        model.addAttribute("alert",alertMsg);
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        List<MenuDTO> menuItemList = kitchenBO.findMenuItems();
        List<FoodItemDTO> foodItemDTOList = kitchenBO.findFoodItems();
        model.addAttribute("loadFoodItemTable", foodItemDTOList);
        model.addAttribute("loadMenuItemTable", menuItemList);
        model.addAttribute("menuCategories", KitchenUtil.menuCategories);
        return "manageFoodPacks";
    }


    @GetMapping(value = "/deleteFoodPackage/{menuId}")
    public void deleteMenuItem(Model model, @PathVariable("menuId") int menuItemId, HttpServletResponse response) {
        alertMsg = null;
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        model.addAttribute("alert",alertMsg);
        model.addAttribute("menuCategories", KitchenUtil.menuCategories);

        try {
            kitchenBO.deleteMenuItem(menuItemId);
        } catch (Exception e){

            alertMsg = "Delete food item failed";
            model.addAttribute(KitchenUtil.alertMessageName, alertMsg);

        }

        try {
            response.sendRedirect("/manageFoodPacks");
        } catch (IOException e) {

        }
    }



    @GetMapping("/editFoodPack")
    public String editFoodPack(Model model, @ModelAttribute MenuDTO menuDTO) {
        alertMsg = null;
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        model.addAttribute("alert",alertMsg);
        model.addAttribute("menuItem", kitchenBO.findMenuItemById(menuDTO.getMenuId()));

        List<FoodItemDTO> foodItemDTOS = kitchenBO.findFoodItems();
        List<FoodItemDTO> notSelectedFoodItems = new ArrayList<>();
        List<FoodItemDTO> selectedFoodItems = new ArrayList<>();

        if (kitchenBO.findFoodItemsDetails(menuDTO.getMenuId()) != null) {
            List<MenuDetailsDTO> menuDetailsDTOS = kitchenBO.findFoodItemsDetails(menuDTO.getMenuId());
            selectedFoodItems = loadSelectedFoodItems(selectedFoodItems, foodItemDTOS, menuDetailsDTOS);
            notSelectedFoodItems = loadNotSelectedFoodItems(selectedFoodItems, foodItemDTOS, notSelectedFoodItems);
        }

        model.addAttribute("loadSelectedFood", selectedFoodItems);
        model.addAttribute("loadFoodItemTable", notSelectedFoodItems);

        return "/editFoodPack";
    }

    @GetMapping("/addItemToPack")
    public String addItemToPack(Model model, @ModelAttribute MenuDetailsDTO menuDTO) {
        alertMsg = null;
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        model.addAttribute("alert",alertMsg);
        model.addAttribute("menuItem", kitchenBO.findMenuItemById(menuDTO.getMenuID()));
        kitchenBO.saveFoodDetail(menuDTO);

        List<FoodItemDTO> foodItemDTOS = kitchenBO.findFoodItems();
        List<FoodItemDTO> notSelectedFoodItems = new ArrayList<>();
        List<FoodItemDTO> selectedFoodItems = new ArrayList<>();

        if (kitchenBO.findFoodItemsDetails(menuDTO.getMenuID()) != null) {
            List<MenuDetailsDTO> menuDetailsDTOS = kitchenBO.findFoodItemsDetails(menuDTO.getMenuID());
            selectedFoodItems = loadSelectedFoodItems(selectedFoodItems, foodItemDTOS, menuDetailsDTOS);
            notSelectedFoodItems = loadNotSelectedFoodItems(selectedFoodItems, foodItemDTOS, notSelectedFoodItems);
        }

        model.addAttribute("loadSelectedFood", selectedFoodItems);
        model.addAttribute("loadFoodItemTable", notSelectedFoodItems);

        return "/editFoodPack";
    }

    @GetMapping(value = "/removeItemFromPack")
    public String deleteFoodItemFromPack(Model model, @ModelAttribute MenuDetailsDTO menuDetailsDTO) {
        alertMsg = null;
        model.addAttribute("loggerName", indexLoginBO.getEmployeeByIdNo(SuperController.idNo));
        model.addAttribute("alert",alertMsg);

        MenuDTO menuDTO = kitchenBO.findMenuItemById(menuDetailsDTO.getMenuID());
        model.addAttribute("menuItem", menuDTO);

        kitchenBO.deleteItemFromPack(menuDetailsDTO.getFoodItemID(),menuDetailsDTO.getFoodItemID());

        try {
            kitchenBO.deleteItemFromPack(menuDetailsDTO.getFoodItemID(),menuDetailsDTO.getMenuID());
        } catch (Exception e){}
        finally {
            List<FoodItemDTO> foodItemDTOS = kitchenBO.findFoodItems();
            List<FoodItemDTO> notSelectedFoodItems = new ArrayList<>();
            List<FoodItemDTO> selectedFoodItems = new ArrayList<>();

            if (kitchenBO.findFoodItemsDetails(menuDetailsDTO.getMenuID()) != null) {
                List<MenuDetailsDTO> menuDetailsDTOS = kitchenBO.findFoodItemsDetails(menuDetailsDTO.getMenuID());
                selectedFoodItems = loadSelectedFoodItems(selectedFoodItems, foodItemDTOS, menuDetailsDTOS);
                notSelectedFoodItems = loadNotSelectedFoodItems(selectedFoodItems, foodItemDTOS, notSelectedFoodItems);
            }

            model.addAttribute("loadSelectedFood", selectedFoodItems);
            model.addAttribute("loadFoodItemTable", notSelectedFoodItems);

        }

        return "/editFoodPack";

    }

    public boolean searchListByID(List<FoodItemDTO> list, FoodItemDTO object){
        for (FoodItemDTO item: list){
            if (item.getItemId() == object.getItemId()){
                return true;
            }
        }

        return false;
    }

    public List<FoodItemDTO> loadSelectedFoodItems(List<FoodItemDTO> selectedFoodItems, List<FoodItemDTO> foodItemDTOS, List<MenuDetailsDTO> menuDetailsDTOS){

        if (menuDetailsDTOS.size() != 0) {
            for (MenuDetailsDTO menuItem : menuDetailsDTOS) {
                for (FoodItemDTO item : foodItemDTOS) {
                    if (item.getItemId() == menuItem.getFoodItemID()) {
                        selectedFoodItems.add(item);
                    }
                }
            }
        }


        return selectedFoodItems;
    }

    public List<FoodItemDTO> loadNotSelectedFoodItems(List<FoodItemDTO> selectedFoodItems, List<FoodItemDTO> foodItemDTOS, List<FoodItemDTO> notSelectedFoodItems){
        if (selectedFoodItems.size() != 0){
            for (FoodItemDTO item: foodItemDTOS){
                if (!searchListByID(selectedFoodItems, item)){
                    notSelectedFoodItems.add(item);
                }
            }
        } else {
            notSelectedFoodItems = foodItemDTOS;
        }

        return notSelectedFoodItems;
    }

}
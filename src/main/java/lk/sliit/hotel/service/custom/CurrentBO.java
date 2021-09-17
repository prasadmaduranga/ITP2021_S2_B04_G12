package lk.sliit.hotel.service.custom;

import lk.sliit.hotel.dto.hr.CurrentBillDTO;
import lk.sliit.hotel.service.SuperBO;

import java.util.List;

public interface CurrentBO extends SuperBO {
    CurrentBillDTO findHighestCurrentBillId();

    void saveCurrentBill(CurrentBillDTO currentBillDTO);

    List<CurrentBillDTO> findAllCurrentBills();

    CurrentBillDTO findById(int billId);

    void deleteCurrentBill(int billId);
}

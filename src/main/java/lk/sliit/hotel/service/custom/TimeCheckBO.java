package lk.sliit.hotel.service.custom;


import lk.sliit.hotel.dto.timeCheckDTO;

import java.util.Date;
import java.util.List;

public interface TimeCheckBO {

    void setTime(timeCheckDTO meCheck);


    List<timeCheckDTO> getReqTime(Date date, Date tdate, Date tdate2);
}

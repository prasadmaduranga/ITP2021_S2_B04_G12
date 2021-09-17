package lk.sliit.hotel.service.custom.impl;

import lk.sliit.hotel.dao.TimeDAO;
import lk.sliit.hotel.dto.timeCheckDTO;
import lk.sliit.hotel.entity.TimeCheck;
import lk.sliit.hotel.service.custom.TimeCheckBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Service
public class TimeCheckBOImpl implements TimeCheckBO {

    @Autowired
    TimeDAO timeDAO;


    @Override
    public void setTime(timeCheckDTO meCheck) {
        timeDAO.save(new TimeCheck(
                meCheck.getId(),
                Time.valueOf(meCheck.getTimeSett()+":00"),
                Time.valueOf(meCheck.getTimeSett2()+":00"),
                Date.valueOf(meCheck.getDateSett())
        ));
    }

    @Override
    public List<timeCheckDTO> getReqTime(java.util.Date date, java.util.Date tdate, java.util.Date tdate2) {


        Iterable<TimeCheck> all = timeDAO.findAllByTimeTwoBetweenAndDateEquals(tdate,tdate2,date);
        Iterable<TimeCheck> all2 = timeDAO.findAllByTimeOneBetweenAndDateEquals(tdate,tdate2,date);
        Iterable<TimeCheck> all3 = timeDAO.findAllByTimeTwoGreaterThanEqualAndTimeOneLessThanEqualAndDateEquals(tdate,tdate2,date);

        System.out.println(date);
        System.out.println("Tset 1 "+tdate);
        System.out.println("Tset 2 "+tdate2);

        for (TimeCheck a : all2) {
            System.out.println("AAAAAAAAAA "+a.getId());
            System.out.println("AAAAAAAAAA "+a.getTimeSett());
            System.out.println("AAAAAAAAAA "+a.getTimeSett2());
        }
        for (TimeCheck a : all3) {
            System.out.println("CCCCCCCC "+a.getId());
            System.out.println("CCCCCCCC "+a.getTimeSett());
            System.out.println("CCCCCCCC "+a.getTimeSett2());
        }

        for (TimeCheck a : all2) {
            System.out.println("BBBBBBBBB "+a.getId());
            System.out.println("BBBBBBBBB "+a.getTimeSett());
            System.out.println("BBBBBBBBB "+a.getTimeSett2());
        }
        List<timeCheckDTO> dtos = new ArrayList<>();
        for (TimeCheck a : all) {
            dtos.add(new timeCheckDTO(
                    a.getId(),
                    a.getTimeSett(),
                    a.getTimeSett2(),
                    a.getDate()
            ));
        }
        return null;
    }
}

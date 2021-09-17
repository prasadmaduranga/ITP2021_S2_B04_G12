package lk.sliit.hotel.service.custom.impl;

import lk.sliit.hotel.dao.hrDAO.DepartmentDAO;
import lk.sliit.hotel.dao.manageSystemDAO.NoticeDAO;
import lk.sliit.hotel.dto.manager.NoticeDTO;
import lk.sliit.hotel.entity.manager.Notice;
import lk.sliit.hotel.service.custom.NoticeBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Service
@Transactional
public class NoticeBOImpl implements NoticeBO {


    @Autowired
    NoticeDAO noticeDAO;
    @Autowired
    DepartmentDAO departmentDAO;

    @Override
    public void saveNotice(NoticeDTO noticeDTO) {
        noticeDAO.save(new Notice(
                noticeDTO.getNoticeId(),
                noticeDTO.getTitle(),
                noticeDTO.getDescription(),
                noticeDTO.getDate(),
                departmentDAO.findOne(noticeDTO.getDepartment())
        ));
    }

    @Override
    @Transactional(readOnly = true)
    public List<NoticeDTO> findAll() {
        Iterable<Notice> all = noticeDAO.findAllByOrderByDateDesc();
        List<NoticeDTO> dtos = new ArrayList<>();
        for (Notice a : all) {
            dtos.add(new NoticeDTO(
                    a.getNoticeId(),
                    a.getTitle(),
                    a.getDescription(),
                    a.getDate(),
                    a.getDepartment().getDepartmentId()
            ));
        }
        return dtos;
    }

    @Override
    public void deleteNotice(int notId) {
        noticeDAO.delete(notId);
    }

    @Override
    public NoticeDTO findId() {
        Notice a = noticeDAO.findTopByOrderByNoticeIdDesc();
        try {
            return new NoticeDTO(
                    a.getNoticeId()
            );
        } catch (NullPointerException e) {
            System.out.println("No Notice Fond");
        }
        return null;
    }

    @Override
    public NoticeDTO findNoticeById(int noticeId) {
        Notice notice = noticeDAO.findOne(noticeId);
        return new NoticeDTO(
                notice.getNoticeId(),
                notice.getTitle(),
                notice.getDescription(),
                notice.getDate(),
                notice.getDepartment().getDepartmentId()
        );


    }

    @Override
    public List<NoticeDTO> findNoticeOneWeek() {

        Date todaydate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -7);
        Date beforeWeek = cal.getTime();
        Iterable <Notice> all = noticeDAO.findProjectsByDateBetweenOrderByDateDesc (beforeWeek ,todaydate);
        List<NoticeDTO> dtos = new ArrayList<>();
        for (Notice a : all) {
            dtos.add(new NoticeDTO(
                    a.getNoticeId(),
                    a.getTitle(),
                    a.getDescription(),
                    a.getDate(),
                    a.getDepartment().getDepartmentId()
            ));
        }
        return dtos;
    }


}

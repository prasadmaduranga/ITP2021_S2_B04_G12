package lk.sliit.hotel.service.custom;

import lk.sliit.hotel.dto.manager.NoticeDTO;
import lk.sliit.hotel.service.SuperBO;

import java.util.List;

public interface NoticeBO extends SuperBO {

    void saveNotice(NoticeDTO noticeDTO);

    List<NoticeDTO> findAll();

    void deleteNotice(int notId);

    NoticeDTO findId();

    NoticeDTO findNoticeById(int noticeId);


    List<NoticeDTO> findNoticeOneWeek();
}

package lk.sliit.hotel.entity.manager;


import lk.sliit.hotel.entity.SuperEntity;
import lk.sliit.hotel.entity.hr.Department;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Notice implements SuperEntity {

    @Id
    private int noticeId ;
    private String title;
    @Column(length = 1000)
    private String description;
    private Date date;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name="departmentId",referencedColumnName = "departmentId")
    private Department department;

    public Notice(int noticeId, String title, String description, Date date, Department department) {
        this.noticeId = noticeId;
        this.title = title;
        this.description = description;
        this.date = date;
        this.department = department;
    }

    public Notice() {
    }

    public int getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(int noticeId) {
        this.noticeId = noticeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}//End Class

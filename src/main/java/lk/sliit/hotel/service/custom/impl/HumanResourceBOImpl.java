package lk.sliit.hotel.service.custom.impl;

import lk.sliit.hotel.dao.houseKeepingDAO.HouseKeepingDAO;
import lk.sliit.hotel.dao.hrDAO.*;
import lk.sliit.hotel.dao.manageSystemDAO.EmployeeDAO;
import lk.sliit.hotel.dto.houseKeeping.HotelRoomDTO;
import lk.sliit.hotel.dto.hr.*;
import lk.sliit.hotel.dto.manager.EmployeeDTO;
import lk.sliit.hotel.entity.houseKeeping.HotelRoom;
import lk.sliit.hotel.entity.hr.*;
import lk.sliit.hotel.entity.manager.Employee;
import lk.sliit.hotel.service.custom.HumanResourceBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
@Transactional
public class HumanResourceBOImpl implements HumanResourceBO {
    @Autowired
    HouseKeepingDAO houseKeepingDAO;
    @Autowired
    AttendanceDAO attendanceDAO;
    @Autowired
    EmployeeDAO employeeDAO;
    @Autowired
    SalaryDAO salaryDAO;
    @Autowired
    EmployeeDAO manageDAO;
    @Autowired
    AccountsDAO accountsDAO;
    @Autowired
    SalarySettingsDAO salarySettingsDAO;
    @Autowired
    DepartmentDAO departmentDAO;
    @Autowired
    ActivityListDAO activityListDAO;

    @Override
    public void updateRoomHR(HotelRoomDTO hotelRoomDTO) {

        houseKeepingDAO.save(new HotelRoom(
                hotelRoomDTO.getRoomId2(),
                hotelRoomDTO.getRoomName(),
                hotelRoomDTO.getRoomType(),
                hotelRoomDTO.getDescription(),
                hotelRoomDTO.getStatus(),
                hotelRoomDTO.getHolder(),
                hotelRoomDTO.getPrice(),
                hotelRoomDTO.getDate()

        ));
    }

    @Override
    public List<AttendanceDTO> findTodayAttendance() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        Iterable<Attendance> attendances = null;
        try {
            attendances = attendanceDAO.findAttendanceByDateEquals(date);
        } catch (Exception e) {
        }
        List<AttendanceDTO> dtos = new ArrayList<>();
        for (Attendance attendance : attendances) {
            dtos.add(new AttendanceDTO(
                    attendance.getAttendanceId(),
                    attendance.getDate(),
                    attendance.getInTime(),
                    attendance.getOutTime(),
                    attendance.getOvertimeHours(),
                    attendance.getEmployeeID().getUserId(),
                    attendance.getEmployeeID().getName(),
                    attendance.getEmployeeID().getPosition(),
                    attendance.getEmployeeID().getImage()
            ));
        }
        return dtos;
    }

    //Save Attendance If Not Already Add Today
    @Override
    public void saveOrUpdate(AttendanceDTO attendanceDTO) {
        attendanceDAO.save(new Attendance(
                attendanceDTO.getAttendanceId(),
                attendanceDTO.getDate(),
                attendanceDTO.getSalary(),
                attendanceDTO.getInTime(),
                attendanceDTO.getOutTime(),
                attendanceDTO.getOvertimeHours(),
                employeeDAO.findOne(attendanceDTO.getEmployeeID())));
    }//End attendance save method

    @Override
    @Transactional(readOnly = true)
    public AttendanceDTO findTopByOrderByAttendanceIdDesc() {
        Attendance attendance = null;
        try {
            attendance = attendanceDAO.findTopByOrderByAttendanceIdDesc();
        } catch (Exception e) {

        }
        return new AttendanceDTO(
                attendance.getAttendanceId()
        );
    }//End Get Total Emp

    @Override//Delete Attendance
    public void deleteAttendance(int id) {
        attendanceDAO.delete(id);
    }

    @Override
    public List<AttendanceDTO> findTodayCleanAttendance() {
        Date date = new Date();
        Iterable<Attendance> attendances = null;
        try {
            attendances = attendanceDAO.findAttendanceByDateEquals(date);
        } catch (Exception e) {
        }
        List<AttendanceDTO> dtos = new ArrayList<>();
        for (Attendance attendance : attendances) {
            dtos.add(new AttendanceDTO(
                    attendance.getAttendanceId(),
                    attendance.getDate(),
                    attendance.getInTime(),
                    attendance.getOutTime(),
                    attendance.getOvertimeHours(),
                    attendance.getEmployeeID().getUserId(),
                    attendance.getEmployeeID().getName(),
                    attendance.getEmployeeID().getPosition(),
                    attendance.getEmployeeID().getImage(),
                    attendance.getEmployeeID().getDepartment().getDepartmentName()
            ));
        }
        return dtos;
    }

    @Override
    public List<SalaryDTO> findAllSalary() {
        Iterable<Salary> all = salaryDAO.findAll();
        List<SalaryDTO> dtos = new ArrayList<>();
        for (Salary a : all) {
            dtos.add(new SalaryDTO(
                    a.getSalaryId(),
                    a.getOtHours(),
                    a.getHours(),
                    a.getEmployeeID().getUserId(),
                    a.getEmployeeID().getName(),
                    a.getEmployeeID().getImage()

            ));
        }
        return dtos;
    }

    @Override
    public List<MonthlySalary> findAllUserList() {

        Date todaydate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        Date dt = cal.getTime();
        List<Iterable<Double>> list = new ArrayList<>();
        Iterable<Employee> allTable = employeeDAO.findAll();

        Double all4 = 0.0;
        List<MonthlySalary> dtoList = new ArrayList<>();

        for (Employee a : allTable) {
            try {
                all4 = attendanceDAO.findAllByDateBetweenAndEmployeeID_UserIdEquals(dt, todaydate, a.getUserId());
                dtoList.add(new MonthlySalary(
                        a.getUserId(),
                        a.getName(),
                        a.getSalary(),
                        all4
                ));
            } catch (Exception e) {
            }
        }
        return dtoList;
    }

    @Override
    public List<SalaryPayDTO> getSalaryPayment(String source) {
        List<String> list = new ArrayList<>();
        String[] sourceAry = source.split(" ");
        List<SalaryPayDTO> dtoList = new ArrayList<>();
        for (String value : sourceAry) {
            list.add(value);
        }
        SalarySettings s = salarySettingsDAO.findTopByOrderByIdDesc();
        addPayment(list);
        Double all4 = 0.0;
        Double all5 = 0.0;
        for (String aa : list) {
            int a = Integer.parseInt(aa);
            all4 = salaryDAO.findAllByDateBetweenAndEmployeeID_UserIdEquals(a);
            all5 = salaryDAO.findAllByDateBetweenAndEmployeeID_UserIdEqual(a);
            Employee employee = employeeDAO.findOne(Integer.valueOf(a));
            dtoList.add(new SalaryPayDTO(
                    employee.getSalary(),
                    new Date(),
                    s.getEtf(),
                    s.getEpf(),
                    all5,
                    all4,
                    employee.getSalary(),
                    s.getServiceCharge(),
                    false,
                    employee.getUserId(),
                    employee.getName()
            ));
        }
        return dtoList;
    }

    private void addPayment(List<String> list) {

    }

    @Override
    public List<AccountsDTO> findAllAccounts() {
        Iterable<Accounts> list = accountsDAO.findAll();
        List<AccountsDTO> list2 = new ArrayList<>();
        for (Accounts accounts : list) {
            list2.add(new AccountsDTO(
                    accounts.getAccountId(),
                    accounts.getChequeNo(),
                    accounts.getAmount(),
                    accounts.getDate(),
                    accounts.getDepartment().getDepartmentId(),
                    accounts.getDescription()
            ));
        }
        return list2;
    }

    @Override
    public void deleteAccount(int accountId) {
        accountsDAO.delete(accountId);
    }

    @Override
    public List<EmployeeDTO> findAllsalaryStateNotFalseTot() {
        Set<Employee> all = salaryDAO.findAllByStateEquals(false);

        List<EmployeeDTO> find2 = new ArrayList<>();
        for (Employee employee : all) {
            find2.add(new EmployeeDTO(
                    employee.getUserId(),
                    employee.getName(),
                    employee.getMobileNo(),
                    employee.getEmail(),
                    employee.getAddress(),
                    employee.getPosition(),
                    employee.getPassword(),
                    employee.getDateOfBirth(),
                    employee.getGender(),
                    employee.getSalary(),
                    employee.getDate(),
                    employee.getImage(),
                    employee.getDepartment().getDepartmentId()
            ));
        }
        return find2;
    }

    @Override
    public List<SalarySettingsDTO> getSalarySet() {
        Iterable<SalarySettings> all = salarySettingsDAO.findAllByOrderByIdDesc();

        List<SalarySettingsDTO> find2 = new ArrayList<>();
        for (SalarySettings settings : all) {
            find2.add(new SalarySettingsDTO(
                    settings.getId(),
                    settings.getEtf(),
                    settings.getEpf(),
                    settings.getServiceCharge(),
                    settings.getDate()
            ));
        }

        return find2;
    }

    //Save Etf,Epf,ServiceCharge
    @Override
    public void saveSettingSalary(SalarySettingsDTO settingsDTO) {
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        settingsDTO.setDate(date);
        salarySettingsDAO.save(new SalarySettings(
                settingsDTO.getId(),
                settingsDTO.getEtf(),
                settingsDTO.getEpf(),
                settingsDTO.getServiceCharge(),
                settingsDTO.getDate()

        ));
    }


    @Override
    public SalarySettingsDTO findsalarySettingById(int id) {
        SalarySettings settings = null;
        try {
            settings = salarySettingsDAO.findOne(id);
        } catch (Exception e) {
        }
        return new SalarySettingsDTO(
                settings.getId()
        );
    }//End


    @Override
    public SalarySettingsDTO findHighestSettingSalary() {
        SalarySettings settings = null;
        try {
            settings = salarySettingsDAO.findTopByOrderByIdDesc();
        } catch (Exception e) {
        }
        return new SalarySettingsDTO(
                settings.getId()
        );
    }//End

    @Override
    public ActivityListDTO findHighestActivityId() {
        ActivityList activityList = null;
        try {
            activityList = activityListDAO.findTopByOrderByActivityIdDesc();
        } catch (Exception e) {
        }
        return new ActivityListDTO(
                activityList.getActivityId()
        );
    }//End


    @Override
    public ActivityListDTO findActivityById(int activityId) {
        ActivityList settings = null;
        try {
            settings = activityListDAO.findOne(activityId);
        } catch (Exception e) {
        }
        return new ActivityListDTO(
                settings.getActivityId()
        );
    }//End

    @Override
    public void saveActivity(ActivityListDTO acti) {

        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        String sunday  = acti.getSundayIn() +" "+acti.getSundayOut();
        String monday  = acti.getMondayIn() +" "+acti.getMondayOut();
        String tuesday  = acti.getTuesdayIn() +" "+acti.getTuesdayOut();
        String wed  = acti.getWednesdayIn() +" "+acti.getWednesdayOut();
        String thurs  = acti.getThursdayOut() +" "+acti.getThursdayOut();
        String fri  = acti.getFridayIn() +" "+acti.getFridayOut();
        String sat  = acti.getSaturdayIn() +" "+acti.getSaturdayOut();
        activityListDAO.save(new ActivityList(
                acti.getActivityId(),
                acti.getEmployeeId(),
                sunday,
                monday,
                tuesday,
                wed,
                thurs,
                fri,
                sat,
                acti.getDate()


        ));
    }

    @Override
    public List<ActivityListDTO> findAllActivity() {
        Iterable<ActivityList> all = activityListDAO.findAll();

        List<ActivityListDTO> find2 = new ArrayList<>();
        for (ActivityList settings : all) {
            Employee rmp = employeeDAO.findOne(settings.getEmployeeId());
            find2.add(new ActivityListDTO(
                    settings.getActivityId(),
                    settings.getEmployeeId(),
                    rmp.getName(),
                    settings.getMonday(),
                    settings.getSunday(),
                    settings.getTuesday(),
                    settings.getWednesday(),
                    settings.getThursday(),
                    settings.getFriday(),
                    settings.getSaturday(),
                    settings.getDate()
            ));
        }

        return find2;
    }

    @Override
    public void deleteActivity(int activityId) {
        activityListDAO.delete(activityId);
    }

    @Override
    public List<AttendanceDTO> findAllAttendance() {
        Iterable<Attendance> attendances = null;
        try {
            attendances = attendanceDAO.findAll();
        } catch (Exception e) {
        }
        List<AttendanceDTO> dtos = new ArrayList<>();
        for (Attendance attendance : attendances) {
            dtos.add(new AttendanceDTO(
                    attendance.getAttendanceId(),
                    attendance.getDate(),
                    attendance.getInTime(),
                    attendance.getOutTime(),
                    attendance.getOvertimeHours(),
                    attendance.getEmployeeID().getUserId(),
                    attendance.getEmployeeID().getName(),
                    attendance.getEmployeeID().getPosition(),
                    attendance.getEmployeeID().getImage()
            ));
        }
        return dtos;
    }

    @Override
    public void deleteSalary(String s) {
        try {
            int id = Integer.parseInt(s);

            Iterable<Salary> salaries = salaryDAO.findAll();


            for (Salary d: salaries) {
                if(d.getEmployeeID().getUserId() == id){
                    salaryDAO.delete (d.getSalaryId());
                }
            }
        }catch (Exception e){

        }
    }


    @Override
    public SalaryDTO findHighestSalaryId() {
        Salary salary = null;
        try {
            salary = salaryDAO.findTopByOrderBySalaryIdDesc();
        } catch (Exception e) {
        }
        return new SalaryDTO(
                salary.getSalaryId()
        );
    }//End Get Total Emp


    @Override
    public SalaryDTO findSalarybyId(int salaryId) {
        Salary salary = salaryDAO.findOne(salaryId);
        SalaryDTO salaryDTO = new SalaryDTO(
                salary.getSalaryId(),
                salary.getOtHours(),
                salary.getHours(),
                salary.getEmployeeID().getUserId()
        );
        return salaryDTO;
    }

    @Override
    public void saveSalary(SalaryDTO salary) {
        Date todaydate = new Date();
        Calendar cal = Calendar.getInstance();
        int m = (todaydate.getMonth());
        Date beforeWeek = cal.getTime();
        Employee employee = employeeDAO.findOne(salary.getEmployeeID());

        salaryDAO.save(new Salary(
                salary.getSalaryId(),
                salary.getOtHours(),
                salary.getHours(),
                false,
                new Date(),
                employee


        ));
    }

    @Override
    public List<SalaryDTO> findAllsalaryStateNotFalse() {
        Iterable<Salary> all = salaryDAO.findAllByStateAndDateEquals(false, new Date());

        List<SalaryDTO> dtos = new ArrayList<>();
        for (Salary salary : all) {
            dtos.add(new SalaryDTO(
                    salary.getSalaryId(),
                    salary.getOtHours(),
                    salary.getHours(),
                    salary.getEmployeeID().getUserId(),
                    salary.getEmployeeID().getName(),
                    salary.getEmployeeID().getImage()
            ));
        }
        return dtos;
    }

    @Override
    public AccountsDTO findHighestAccountId() {
        Accounts accounts = null;
        try {
            accounts = accountsDAO.findTopByOrderByAccountIdDesc();
        } catch (Exception e) {

        }
        return new AccountsDTO(accounts.getAccountId());
    }

    @Override
    public AccountsDTO findAccountById(int accountId) {
        Accounts accounts = accountsDAO.findOne(accountId);
        AccountsDTO accountsDTO = new AccountsDTO(
                accounts.getAccountId(),
                accounts.getChequeNo(),
                accounts.getAmount(),
                accounts.getDate(),
                accounts.getDepartment().getDepartmentId(),
                accounts.getDescription()
        );
        return accountsDTO;
    }

    @Override
    public void saveAccounts(AccountsDTO accountsDTO) {
        accountsDAO.save(new Accounts(
                accountsDTO.getAccountId(),
                accountsDTO.getChequeNo(),
                accountsDTO.getAmount(),
                accountsDTO.getDate(),
                accountsDTO.getDescription(),
                departmentDAO.findOne(accountsDTO.getDepartment())
        ));
    }
}

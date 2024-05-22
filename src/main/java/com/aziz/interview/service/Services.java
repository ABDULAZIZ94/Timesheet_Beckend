package com.aziz.interview.service;

import com.aziz.interview.entity.Status;
import com.aziz.interview.entity.Timesheet;
import com.aziz.interview.entity.User;
import com.aziz.interview.repository.StatusRepository;
import com.aziz.interview.repository.TimesheetRepository;
import com.aziz.interview.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class Services {
    @Autowired //auto initialize
    private TimesheetRepository iTimeSheetRepository = null;
    @Autowired //auto initialize
    private UserRepository userRepository = null;
    @Autowired //auto initialize
    private StatusRepository statusRepository = null;
    //construction and initialization inside constructor
    public Services(TimesheetRepository iTimeSheetRepository) {
        this.iTimeSheetRepository = iTimeSheetRepository;
    }
    //service function that create a row in timesheet table
    public Timesheet createTimesheet(Timesheet timesheet){
        return iTimeSheetRepository.save(timesheet);
    }
    //service function that read all row in timesheet table
    public List<Timesheet> getTimesheets() {
        return iTimeSheetRepository.findAllByOrderByProjectnameDesc();
    }
    public List<Timesheet> getTimesheetsRanged(Date begin, Date end) {
        return iTimeSheetRepository.findAllByDatetoBetween(begin, end);
    }
    public List<Timesheet> getTimesheetsByTaskname(String taskname) {
        return iTimeSheetRepository.findByTask(taskname);
    }
    public Timesheet getTimesheetById(Number id) {
        return iTimeSheetRepository.findById(id);
    }
    // service function to delete a row in timesheet table by id
    public void deleteTimesheetByid(Integer id){
        iTimeSheetRepository.deleteById(id);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }
    public List<Status> getStatuses(){
        return statusRepository.findAll();
    }

    // practise anvance jpa
    public  List<Timesheet> getTimesheetByProjecknameLike(String project_like){
        return iTimeSheetRepository.findByProjectnameLike(project_like); }

    //use jpql
}

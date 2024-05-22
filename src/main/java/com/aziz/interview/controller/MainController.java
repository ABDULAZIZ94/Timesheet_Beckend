package com.aziz.interview.controller;

import com.aziz.interview.entity.Status;
import com.aziz.interview.entity.Timesheet;
import com.aziz.interview.entity.User;
import com.aziz.interview.service.Services;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class MainController {
    //private final Logger logger = LoggerFactory.getLogger(MainController.class);
    @Autowired
    Services service;
    //create a row in timesheet table
    @PostMapping("timesheet")
    public ResponseEntity<Timesheet> create(@RequestBody Timesheet timesheet) {
        Timesheet ts = service.createTimesheet(timesheet);
        return new ResponseEntity<>(ts, HttpStatus.OK);
    }
    //get timesheets data from timesheet table
    @GetMapping("timesheet")
    public ResponseEntity<List<Timesheet>> getAllTimeSheets()  {
        List<Timesheet> lst = service.getTimesheets();
        return new ResponseEntity<>(lst, HttpStatus.OK);
    }
    @GetMapping("timesheet/taskname/{taskname}")
    public ResponseEntity<List<Timesheet>> getAllTimeSheetsByTaskname(@PathVariable String taskname)  {
        List<Timesheet> lst = service.getTimesheetsByTaskname(taskname);
        return new ResponseEntity<>(lst, HttpStatus.OK);
    }
    @GetMapping("timesheet/id/{id}")
    public ResponseEntity<List<Timesheet>> getTimesheetById(@PathVariable Integer id)  {
        Timesheet lst = service.getTimesheetById(id);
        return new ResponseEntity(lst, HttpStatus.OK);
    }
    @GetMapping("timesheet/like/{lks}")
    public ResponseEntity<List<Timesheet>> getTimesheetById(@PathVariable String lks)  {
        List<Timesheet> lst = service.getTimesheetByProjecknameLike(lks);
        return new ResponseEntity(lst, HttpStatus.OK);
    }
    @GetMapping("timesheet/ranged")
    public ResponseEntity<List<Timesheet>> getTimesheetsRanged(
            @RequestParam @DateTimeFormat(pattern = "d/M/yyyy") Date begin,
            @RequestParam @DateTimeFormat(pattern = "d/M/yyyy") Date end)  {
        List<Timesheet> lst = service.getTimesheetsRanged(begin, end);
        return new ResponseEntity(lst, HttpStatus.OK);
    }
    @DeleteMapping("timesheet/{id}")
    public void deleteTimesheetByid(@PathVariable Integer id)  {
        service.deleteTimesheetByid(id);
    }
    //get users data from user table
    @GetMapping("users")
    public ResponseEntity<List<User>> getUsers()  {
        List<User> lst = service.getUsers();
        return new ResponseEntity<>(lst, HttpStatus.OK);
    }
    //get statuses data from status table
    @GetMapping("statuses")
    public ResponseEntity<List<Status>> getStatuses()  {
        List<Status> lst = service.getStatuses();
        return new ResponseEntity<>(lst, HttpStatus.OK);
    }
}

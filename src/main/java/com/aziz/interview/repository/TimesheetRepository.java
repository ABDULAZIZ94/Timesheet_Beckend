package com.aziz.interview.repository;

import com.aziz.interview.entity.Status;
import com.aziz.interview.entity.Timesheet;
import com.aziz.interview.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
public interface TimesheetRepository extends JpaRepository<Timesheet, Integer> {
    //define custom query method
    List<Timesheet> findByTask(String taskName);
    Timesheet findById(Number id);

    //practises advance jpa
    List<Timesheet> findByProjectnameLike(String projectLike);
    List<Timesheet> findAllByOrderByDatefrom();
    List<Timesheet> findAllByOrderByProjectnameDesc();
    List<Timesheet> findAllByDatetoBetween( Date begin , Date end);
    List<Timesheet> findAllByOrderByDatefromAscDatetoAsc();
    List<Timesheet> findAllByOrderByProjectnameAscDatefromAscDatetoAsc();

    //using jpql query

}


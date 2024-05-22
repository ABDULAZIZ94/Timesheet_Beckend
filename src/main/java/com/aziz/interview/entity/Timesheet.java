package com.aziz.interview.entity;

import jakarta.persistence.*;
import org.hibernate.*;
import org.hibernate.engine.internal.Cascade;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "timesheet")
public class Timesheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "timesheet_id")
    private int id;
    private String projectname;
    private String task;
    private Date datefrom;
    private Date dateto;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User assignto;

    @ManyToOne
    @JoinColumn(name = "stat_id")
    private Status status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Date getDatefrom() {
        return datefrom;
    }

    public void setDatefrom(Date datefrom) {
        this.datefrom = datefrom;
    }

    public Date getDateto() {
        return dateto;
    }

    public void setDateto(Date dateto) {
        this.dateto = dateto;
    }

    //List<Status>
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getAssignto() {
        return assignto;
    }

    public void setAssignto(User assignto) {
        this.assignto = assignto;
    }


}

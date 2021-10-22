package com.mountblue.zoom.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "meetings",uniqueConstraints = @UniqueConstraint(columnNames = "session_name"))
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="session_name")
    private String sessionName;

    @Column(name = "start_date")
    @DateTimeFormat(pattern ="yyyy-mm-dd")
    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Column(name = "start_time")
     private String time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}

package com.mountblue.zoom.service;

import com.mountblue.zoom.entity.Meeting;
import com.mountblue.zoom.repository.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.sql.Timestamp;

@Service
public class MeetingService {

    @Autowired
    private MeetingRepository meetingRepository;


    public boolean checkScheduledMeeting(String sessionName) {
        boolean isScheduled = false;
        Meeting meeting = meetingRepository.findBySessionName(sessionName);
        if (meeting != null){
            if (meeting.getStartDate().before(getCurrentTimestamp())) {
                    isScheduled = true;
            }
        }
        return isScheduled;
    }
    private Timestamp getCurrentTimestamp() {
        Date date = new Date();
        return new Timestamp(date.getTime());
    }

    public String save(Meeting meeting) {
        String message ="";
        if(meetingRepository.findBySessionName(meeting.getSessionName())==null) {
            meetingRepository.save(meeting);
            message="success";
        }else {
            message="error";
        }
        return message;
    }
}

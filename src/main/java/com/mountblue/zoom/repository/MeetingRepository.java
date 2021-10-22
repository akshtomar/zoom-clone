package com.mountblue.zoom.repository;

import com.mountblue.zoom.entity.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting,Integer> {
    Meeting findBySessionName(String sessionName);
}

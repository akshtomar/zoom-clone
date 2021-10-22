package com.mountblue.zoom.repository;

import com.mountblue.zoom.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<User,Integer> {
    User findByEmail(String email);
}

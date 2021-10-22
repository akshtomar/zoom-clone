package com.mountblue.zoom.service;

import com.mountblue.zoom.entity.User;
import com.mountblue.zoom.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private RegistrationRepository registrationRepository;

    @Override
    public User findByEmail(String email) {
        return registrationRepository.findByEmail(email);
    }

    @Override
    public void save(User user) {
        registrationRepository.save(user);
    }
}

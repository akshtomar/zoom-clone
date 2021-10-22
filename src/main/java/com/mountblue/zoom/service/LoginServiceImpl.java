package com.mountblue.zoom.service;

import com.mountblue.zoom.entity.User;
import com.mountblue.zoom.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private LoginRepository loginRepository;

    @Override
    public List<User> getListOfUsers() {
        return loginRepository.findAll();
    }
}

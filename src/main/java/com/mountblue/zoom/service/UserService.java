package com.mountblue.zoom.service;

import com.mountblue.zoom.entity.User;

public interface UserService {
    User findByEmail(String email);

    void save(User user);
}

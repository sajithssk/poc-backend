package com.vwits.SdcPlannerbackend.service;

import com.vwits.SdcPlannerbackend.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findByEmail(String email);
}

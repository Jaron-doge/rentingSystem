package com.example.rent.service.impl;

import com.example.rent.entity.User;
import com.example.rent.service.ManagerService;

import java.util.List;

public class ManagerServiceImpl implements ManagerService {
    @Override
    public List<User> selectManager(String username) {
        return null;
    }

    @Override
    public User getManager(Integer userid) {
        return null;
    }

    @Override
    public boolean addManager(User user) {
        return false;
    }

    @Override
    public boolean updateManager(User user) {
        return false;
    }

    @Override
    public boolean deleteManager(Integer userid) {
        return false;
    }
}

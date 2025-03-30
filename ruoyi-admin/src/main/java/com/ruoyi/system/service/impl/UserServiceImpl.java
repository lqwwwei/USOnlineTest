package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.UserWithRoles;
import com.ruoyi.system.mapper.UserMapper;
import com.ruoyi.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public List<UserWithRoles> getUsersWithRoles() {
        return userMapper.selectUsersWithRoles();
    }
}

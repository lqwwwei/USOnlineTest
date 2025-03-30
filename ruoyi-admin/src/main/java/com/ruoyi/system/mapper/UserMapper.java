package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.UserWithRoles;

import java.util.List;

public interface UserMapper {
    List<UserWithRoles> selectUsersWithRoles();
}

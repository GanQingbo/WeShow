package com.gqb.user.service;

import com.github.pagehelper.PageInfo;
import com.gqb.user.entity.User;
import com.gqb.user.entity.vo.UserLoginVo;

/**
 * @program: WeShow
 * @description:
 * @author: Gan
 * @date: 2021-03-18 11:29
 **/
public interface UserService {
    PageInfo<User> getUserByPage(int page, int size, User user);
    User getUserById(Long id);
    int createUser(User user);
    int updateUser(User user);
    int deleteUserById(Long id);
    int updateStatus(Long id);
    User getUserByUsername(String username);
    User getUserByPhone(String phone);

    User login(UserLoginVo userLoginVo);
}

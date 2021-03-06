package com.gqb.user.dao;

import com.gqb.user.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @program: WeShow
 * @description:
 * @author: Gan
 * @date: 2021-03-18 11:30
 **/
@Mapper
public interface UserDao {
    List<User> getAllUsers();

    List<User> getUserQuery(User user);

    User getUserById(@Param("id") Long id);

    int createUser(User user);

    int deleteUserById(@Param("id") Long id);

    int updateUser(User user);

    int updateStatus(User user);

    Byte getStatus(@Param("id") Long id);

    User getUserByUsername(@Param("username") String username);

    User getUserByPhone(@Param("phone") String phone);

    User getUserByLogin(@Param("username") String username);
}

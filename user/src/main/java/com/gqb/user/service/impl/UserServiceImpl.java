package com.gqb.user.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gqb.user.dao.UserDao;
import com.gqb.user.entity.User;
import com.gqb.user.entity.vo.UserLoginVo;
import com.gqb.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: WeShow
 * @description:
 * @author: Gan
 * @date: 2021-03-18 11:29
 **/
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    /**
     * 分页带查询结果User
     * @param page
     * @param size
     * @param user
     * @return
     */
    @Override
    public PageInfo<User> getUserByPage(int page, int size, User user) {
        //开启分页插件page helper
        PageHelper.startPage(page,size);
        System.out.println(user.getStatus());
        List<User> userList = userDao.getUserQuery(user);
        //封装到PageInfo
        PageInfo<User> pageInfo=new PageInfo<>(userList);
        return pageInfo;
    }

    @Override
    public User getUserById(Long id) {
        User user = userDao.getUserById(id);
        return user;
    }

    @Override
    public int createUser(User user) {
        int i = userDao.createUser(user);
        return i;
    }

    @Override
    public int updateUser(User user) {
        int i = userDao.updateUser(user);
        return i;
    }

    @Override
    public int deleteUserById(Long id) {
        int i = userDao.deleteUserById(id);
        return i;
    }

    @Override
    public int updateStatus(Long id) {
        User user = new User();
        user.setId(id);
        Byte status = userDao.getStatus(id);
        int i=0;
        if(status==0){ //启用
            user.setStatus((byte)1);
           i = userDao.updateStatus(user);
        }else if(status==1){ //禁用
            user.setStatus((byte)0);
           i = userDao.updateStatus(user);
        }
        return i;
    }

    @Override
    public User getUserByUsername(String username) {
        User user = userDao.getUserByUsername(username);
        return user;
    }

    @Override
    public User getUserByPhone(String phone) {
        User user = userDao.getUserByPhone(phone);
        return user;
    }

    /**
     * 用户登录
     * @param userLoginVo
     * @return
     */
    @Override
    public User login(UserLoginVo userLoginVo) {
        log.info("userLogin:"+userLoginVo.getUsername());
        User user = userDao.getUserByLogin(userLoginVo.getUsername());
        if(user==null){
            log.info("DB查不到user");
            return null;
        }
        String password= SecureUtil.md5(userLoginVo.getPassword());
        if(!StringUtils.isEmpty(userLoginVo.getPassword()) && password.equals(user.getPassword())){
            //密码正确,String比较要用equal
            return user;
        }
        log.info("User密码错误");
        return null;
    }
}

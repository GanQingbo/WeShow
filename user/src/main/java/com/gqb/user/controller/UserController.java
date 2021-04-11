package com.gqb.user.controller;

import com.github.pagehelper.PageInfo;
import com.gqb.common.utils.R;
import com.gqb.user.entity.User;
import com.gqb.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @program: WeShow
 * @description:
 * @author: Gan
 * @date: 2021-03-18 11:28
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/getAllUser/{page}/{size}")
    public R getUserByPage(@PathVariable("page") Integer page, @PathVariable("size") Integer size, @RequestBody User user){
        PageInfo<User> userByPage = userService.getUserByPage(page, size, user);
        return R.ok().data("user",userByPage);
    }

    @PostMapping("/createUser")
    public R createUser(@RequestBody User user){
        int user1 = userService.createUser(user);
        if(user1>0){
            return R.ok().message("创建用户成功").data("id",user.getId());
        }
        return R.error().message("创建用户失败");
    }

    @GetMapping("/getUserById/{id}")
    public R getUserById(@PathVariable("id") Long id){
        User userById = userService.getUserById(id);
        return R.ok().data("user",userById);
    }

    @PostMapping("/updateUser")
    public R updateUser(@RequestBody User user){
        int i = userService.updateUser(user);
        if(i>0){
            return R.ok().message("更新用户信息成功");
        }
        return R.error().message("更新用户信息失败");
    }

    @DeleteMapping("/deleteUserById/{id}")
    public R deleteUserById(@PathVariable("id") Long id){
        int i = userService.deleteUserById(id);
        if(i>0){
            return R.ok().message("删除用户成功");
        }
        return R.error().message("删除用户失败");
    }

    @PostMapping("/updateStatus/{id}")
    public R updateStatus(@PathVariable("id") Long id){
        int i = userService.updateStatus(id);
        if(i>0){
            return R.ok();
        }
        return R.error();
    }
}

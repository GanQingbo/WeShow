package com.gqb.auth.entity.vo;

import java.io.Serializable;

/**
 * @author GanQingbo
 * @Classname UserLoginVo
 * @Description
 * @date 2021/4/13 23:22
 */
public class UserLoginVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserLoginVo() {
    }

    public UserLoginVo(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

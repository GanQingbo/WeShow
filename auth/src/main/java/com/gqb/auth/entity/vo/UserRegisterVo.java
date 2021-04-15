package com.gqb.auth.entity.vo;

import java.io.Serializable;

/**
 * @author GanQingbo
 * @Classname UserRegisterVo
 * @Description 注册Vo
 * @date 2021/4/13 20:37
 */
public class UserRegisterVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private String mobile;
    private String code;

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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public UserRegisterVo() {
    }

    public UserRegisterVo(String username, String password, String mobile, String code) {
        this.username = username;
        this.password = password;
        this.mobile = mobile;
        this.code = code;
    }

    @Override
    public String toString() {
        return "UserRegisterVo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", mobile='" + mobile + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}

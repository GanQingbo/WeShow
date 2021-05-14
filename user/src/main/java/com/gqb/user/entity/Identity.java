package com.gqb.user.entity;

import java.io.Serializable;

/**
 * @author GanQingbo
 * @Classname Identity
 * @Description
 * @date 2021/4/23 18:43
 */
public class Identity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long userId;
    /**
     * 身份证号码
     */
    private String number;
    /**
     * 姓名
     */
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Identity() {
    }

    public Identity(Long id, Long userId, String number, String name) {
        this.id = id;
        this.userId = userId;
        this.number = number;
        this.name = name;
    }
}

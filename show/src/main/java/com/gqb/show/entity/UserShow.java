package com.gqb.show.entity;

import java.io.Serializable;

/**
 * @program: WeShow
 * @description: 用户收藏演出中间表
 * @author: Gan
 * @date: 2021-04-21 17:27
 **/
public class UserShow implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Long userId;
    private Long showId;

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

    public Long getShowId() {
        return showId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }

    public UserShow() {
    }

    public UserShow(Long id, Long userId, Long showId) {
        this.id = id;
        this.userId = userId;
        this.showId = showId;
    }

    @Override
    public String toString() {
        return "UserShow{" +
                "id=" + id +
                ", userId=" + userId +
                ", showId=" + showId +
                '}';
    }
}

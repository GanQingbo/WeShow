package com.gqb.show.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author GanQingbo
 * @Classname ShowComment
 * @Description
 * @date 2021/4/22 22:17
 */
public class ShowComment implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Long showId;
    private Long userId;
    private String comments;
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getShowId() {
        return showId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public ShowComment() {
    }

    public ShowComment(Long id, Long showId, Long userId, String comments, Date createTime) {
        this.id = id;
        this.showId = showId;
        this.userId = userId;
        this.comments = comments;
        this.createTime = createTime;
    }
}

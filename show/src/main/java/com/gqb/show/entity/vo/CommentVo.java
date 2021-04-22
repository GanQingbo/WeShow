package com.gqb.show.entity.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author GanQingbo
 * @Classname CommentVo
 * @Description 包括用户信息
 * @date 2021/4/22 23:40
 */
public class CommentVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Long showId;
    private Long userId;
    private String comments;
    private String nickname;
    private String header;
    private String showPoster;
    private String showName;
    private Date createTime;

    public String getShowPoster() {
        return showPoster;
    }

    public void setShowPoster(String showPoster) {
        this.showPoster = showPoster;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public CommentVo() {
    }

    public CommentVo(Long id, Long showId, Long userId, String comments, String nickname, String header, String showPoster, String showName, Date createTime) {
        this.id = id;
        this.showId = showId;
        this.userId = userId;
        this.comments = comments;
        this.nickname = nickname;
        this.header = header;
        this.showPoster = showPoster;
        this.showName = showName;
        this.createTime = createTime;
    }
}

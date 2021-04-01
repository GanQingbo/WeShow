package com.gqb.show.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author GanQingbo
 * @Classname Recommend
 * @Description 首页推荐演出类
 * @date 2021/3/31 12:37
 */
public class Recommend implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    private Long id;
    /**
     * 演出id
     */
    private Long showId;
    /**
     * 创建日期
     */
    private Date createTime;

    public Recommend() {
    }

    public Recommend(Long id, Long showId, Date createTime) {
        this.id = id;
        this.showId = showId;
        this.createTime = createTime;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Recommend{" +
                "id=" + id +
                ", showId=" + showId +
                ", createTime=" + createTime +
                '}';
    }
}

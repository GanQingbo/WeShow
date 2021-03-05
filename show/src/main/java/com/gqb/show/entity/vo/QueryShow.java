package com.gqb.show.entity.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author GanQingbo
 * @Classname QueryShow
 * @Description 搜索框查询show的参数vo
 * @date 2021/3/4 11:46
 */
public class QueryShow implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 表演类型
     */
    private String showType;
    /**
     * 表演名称
     */
    private String showName;
    /**
     * 表演者
     */
    private String showPerformer;
    /**
     * 演出城市
     */
    private String showCity;

    /**
     * 开始时间
     */
    private Date beginTime;
    /**
     * 结束时间
     */
    private Date endTime;

    public String getShowType() {
        return showType;
    }

    public void setShowType(String showType) {
        this.showType = showType;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getShowPerformer() {
        return showPerformer;
    }

    public void setShowPerformer(String showPerformer) {
        this.showPerformer = showPerformer;
    }

    public String getShowCity() {
        return showCity;
    }

    public void setShowCity(String showCity) {
        this.showCity = showCity;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public QueryShow() {
    }

    public QueryShow(String showType, String showName, String showPerformer, String showCity, Date beginTime, Date endTime) {
        this.showType = showType;
        this.showName = showName;
        this.showPerformer = showPerformer;
        this.showCity = showCity;
        this.beginTime = beginTime;
        this.endTime = endTime;
    }
}

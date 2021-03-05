package com.gqb.show.entity.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author GanQingbo
 * @Classname completeShow
 * @Description 分页列表查询结果，把show type id 换成show type,去掉简介和海报
 * @date 2021/3/3 18:47
 */
public class CompleteShow implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    private Long id;
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
     * 演出地点
     */
    private String showPlace;
    /**
     * 演出时间
     */
    private Date showTime;
    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 联系号码
     */
    private String showMobile;
    /**
     * 创建时间
     */
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getShowPlace() {
        return showPlace;
    }

    public void setShowPlace(String showPlace) {
        this.showPlace = showPlace;
    }

    public Date getShowTime() {
        return showTime;
    }

    public void setShowTime(Date showTime) {
        this.showTime = showTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }


    public String getShowMobile() {
        return showMobile;
    }

    public void setShowMobile(String showMobile) {
        this.showMobile = showMobile;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public CompleteShow() {
    }

    public CompleteShow(Long id, String showType, String showName, String showPerformer, String showCity, String showPlace, Date showTime, Date endTime, String showMobile, Date createTime) {
        this.id = id;
        this.showType = showType;
        this.showName = showName;
        this.showPerformer = showPerformer;
        this.showCity = showCity;
        this.showPlace = showPlace;
        this.showTime = showTime;
        this.endTime = endTime;
        this.showMobile = showMobile;
        this.createTime = createTime;
    }
}

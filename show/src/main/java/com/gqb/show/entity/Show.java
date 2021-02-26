package com.gqb.show.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author GanQingbo
 * @Classname Show
 * @Description 演出实体类
 * @date 2021/2/25 10:06
 */
public class Show implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    private Long id;
    /**
     * 表演类型id
     */
    private Long showTypeId;
    /**
     * 表演名称
     */
    private String showName;
    /**
     * 表演简介
     */
    private String showIntro;
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
     * 演出海报
     */
    private String showPoster;
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

    public Long getShowTypeId() {
        return showTypeId;
    }

    public void setShowTypeId(Long showTypeId) {
        this.showTypeId = showTypeId;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getShowIntro() {
        return showIntro;
    }

    public void setShowIntro(String showIntro) {
        this.showIntro = showIntro;
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

    public String getShowPoster() {
        return showPoster;
    }

    public void setShowPoster(String showPoster) {
        this.showPoster = showPoster;
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

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Show() {
    }

    public Show(Long id, Long showTypeId, String showName, String showIntro, String showPerformer, String showCity, String showPlace, Date showTime, Date endTime, String showPoster, String showMobile, Date createTime) {
        this.id = id;
        this.showTypeId = showTypeId;
        this.showName = showName;
        this.showIntro = showIntro;
        this.showPerformer = showPerformer;
        this.showCity = showCity;
        this.showPlace = showPlace;
        this.showTime = showTime;
        this.endTime = endTime;
        this.showPoster = showPoster;
        this.showMobile = showMobile;
        this.createTime = createTime;
    }

    public Show(Long showTypeId, String showName, String showPerformer, String showCity, String showPlace, Date showTime) {
        this.showTypeId = showTypeId;
        this.showName = showName;
        this.showPerformer = showPerformer;
        this.showCity = showCity;
        this.showPlace = showPlace;
        this.showTime = showTime;
    }
}

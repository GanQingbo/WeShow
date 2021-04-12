package com.gqb.show.entity.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author GanQingbo
 * @Classname PerfectShow
 * @Description 究极版show，集大成于一身
 * @date 2021/4/12 23:58
 */
public class PerfectShow implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * show id
     */
    private Long id;
    /**
     * 演出类型
     */
    private String showType;
    private String showName;
    private String showIntro;
    private String showPerformer;
    private String showCity;
    private String showPlace;
    private Date showTime;
    private Date endTime;
    private String showPoster;
    private String showMobile;
    /**
     * 座位类型
     */
    private String seatType;
    /**
     * 座位价格
     */
    private BigDecimal seatPrice;
    /**
     * 座位总数
     */
    private int seatNumber;
    /**
     * 座位余量
     */
    private int seatSurplus;
    /**
     * 开售时间
     */
    private Date sellTime;
    /**
     * 热度
     */
    private int heat;

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

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public BigDecimal getSeatPrice() {
        return seatPrice;
    }

    public void setSeatPrice(BigDecimal seatPrice) {
        this.seatPrice = seatPrice;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getSeatSurplus() {
        return seatSurplus;
    }

    public void setSeatSurplus(int seatSurplus) {
        this.seatSurplus = seatSurplus;
    }

    public Date getSellTime() {
        return sellTime;
    }

    public void setSellTime(Date sellTime) {
        this.sellTime = sellTime;
    }

    public int getHeat() {
        return heat;
    }

    public void setHeat(int heat) {
        this.heat = heat;
    }

    public PerfectShow() {
    }

    public PerfectShow(Long id, String showType, String showName, String showIntro, String showPerformer, String showCity, String showPlace, Date showTime, Date endTime, String showPoster, String showMobile, String seatType, BigDecimal seatPrice, int seatNumber, int seatSurplus, Date sellTime, int heat) {
        this.id = id;
        this.showType = showType;
        this.showName = showName;
        this.showIntro = showIntro;
        this.showPerformer = showPerformer;
        this.showCity = showCity;
        this.showPlace = showPlace;
        this.showTime = showTime;
        this.endTime = endTime;
        this.showPoster = showPoster;
        this.showMobile = showMobile;
        this.seatType = seatType;
        this.seatPrice = seatPrice;
        this.seatNumber = seatNumber;
        this.seatSurplus = seatSurplus;
        this.sellTime = sellTime;
        this.heat = heat;
    }

    @Override
    public String toString() {
        return "PerfectShow{" +
                "id=" + id +
                ", showType='" + showType + '\'' +
                ", showName='" + showName + '\'' +
                ", showIntro='" + showIntro + '\'' +
                ", showPerformer='" + showPerformer + '\'' +
                ", showCity='" + showCity + '\'' +
                ", showPlace='" + showPlace + '\'' +
                ", showTime=" + showTime +
                ", endTime=" + endTime +
                ", showPoster='" + showPoster + '\'' +
                ", showMobile='" + showMobile + '\'' +
                ", seatType='" + seatType + '\'' +
                ", seatPrice=" + seatPrice +
                ", seatNumber=" + seatNumber +
                ", seatSurplus=" + seatSurplus +
                ", sellTime=" + sellTime +
                ", heat=" + heat +
                '}';
    }
}

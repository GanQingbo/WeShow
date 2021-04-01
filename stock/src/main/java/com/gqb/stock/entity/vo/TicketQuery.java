package com.gqb.stock.entity.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author GanQingbo
 * @Classname TicketQuery
 * @Description ticke查询的列表
 * @date 2021/3/28 16:39
 */
public class TicketQuery implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Long showId;
    private String showName;
    private String seatType;
    private BigDecimal seatPrice;
    /**
     * 座位总数
     */
    private int seatNumber;
    /**
     * 余票
     */
    private int seatSurplus;
    private Date sellTime;
    private Date showTime;
    private Date createTime;
    private String isShow;

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

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
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


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getShowTime() {
        return showTime;
    }

    public void setShowTime(Date showTime) {
        this.showTime = showTime;
    }

    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }

    public TicketQuery() {
    }

    public TicketQuery(Long id, Long showId, String showName, String seatType, BigDecimal seatPrice, int seatNumber, int seatSurplus, Date sellTime, Date showTime, Date createTime, String isShow) {
        this.id = id;
        this.showId = showId;
        this.showName = showName;
        this.seatType = seatType;
        this.seatPrice = seatPrice;
        this.seatNumber = seatNumber;
        this.seatSurplus = seatSurplus;
        this.sellTime = sellTime;
        this.showTime = showTime;
        this.createTime = createTime;
        this.isShow = isShow;
    }

    @Override
    public String toString() {
        return "TicketQuery{" +
                "id=" + id +
                ", showId=" + showId +
                ", showName='" + showName + '\'' +
                ", seatType='" + seatType + '\'' +
                ", seatPrice=" + seatPrice +
                ", seatNumber=" + seatNumber +
                ", seatSurplus=" + seatSurplus +
                ", sellTime=" + sellTime +
                ", showTime=" + showTime +
                ", createTime=" + createTime +
                ", isShow='" + isShow + '\'' +
                '}';
    }
}

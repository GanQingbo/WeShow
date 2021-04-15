package com.gqb.stock.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author GanQingbo
 * @Classname Ticket
 * @Description 座位票实体类
 * @date 2021/3/10 10:24
 */
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    /**
     * 演出id
     */
    private Long showId;
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
     * 当前座位号
     */
    private int currentNo;

    /**
     * 剩余座位数
     */
    private int seatSurplus;

    /**
     * 锁定的座位数
     */
    private int seatLocked;
    /**
     *退票表状态，0已售完，1未售完
     */
    private byte returnStatus;

    /**
     *开售时间
     */
    private Date sellTime;

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

    public byte getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(byte returnStatus) {
        this.returnStatus = returnStatus;
    }

    public int getCurrentNo() {
        return currentNo;
    }

    public void setCurrentNo(int currentNo) {
        this.currentNo = currentNo;
    }

    public Date getSellTime() {
        return sellTime;
    }

    public void setSellTime(Date sellTime) {
        this.sellTime = sellTime;
    }

    public int getSeatLocked() {
        return seatLocked;
    }

    public void setSeatLocked(int seatLocked) {
        this.seatLocked = seatLocked;
    }

    public Ticket() {
    }

    public Ticket(Long id, Long showId, String seatType, BigDecimal seatPrice, int seatNumber, int currentNo, int seatSurplus, int seatLocked, byte returnStatus, Date sellTime) {
        this.id = id;
        this.showId = showId;
        this.seatType = seatType;
        this.seatPrice = seatPrice;
        this.seatNumber = seatNumber;
        this.currentNo = currentNo;
        this.seatSurplus = seatSurplus;
        this.seatLocked = seatLocked;
        this.returnStatus = returnStatus;
        this.sellTime = sellTime;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", showId=" + showId +
                ", seatType='" + seatType + '\'' +
                ", seatPrice=" + seatPrice +
                ", seatNumber=" + seatNumber +
                ", currentNo=" + currentNo +
                ", seatSurplus=" + seatSurplus +
                ", seatLocked=" + seatLocked +
                ", returnStatus=" + returnStatus +
                ", sellTime=" + sellTime +
                '}';
    }
}

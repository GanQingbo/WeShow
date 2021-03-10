package com.gqb.stock.entity;

import java.io.Serializable;
import java.math.BigDecimal;

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
     * 剩余座位数
     */
    private int seatSurplus;

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

    public Ticket() {
    }

    public Ticket(Long id, Long showId, String seatType, BigDecimal seatPrice, int seatNumber, int seatSurplus) {
        this.id = id;
        this.showId = showId;
        this.seatType = seatType;
        this.seatPrice = seatPrice;
        this.seatNumber = seatNumber;
        this.seatSurplus = seatSurplus;
    }
}
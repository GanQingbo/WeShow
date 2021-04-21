package com.gqb.order.entity.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @program: WeShow
 * @description: 订单列表完整信息vo
 * @author: Gan
 * @date: 2021-04-21 18:15
 **/
public class OrderVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Long userId;
    private Long showId;
    private Long ticketId;
    private String orderSn;
    private String showName;
    private Date showTime;
    private String showPoster;
    private String seatType;
    private BigDecimal orderAmount;
    private Byte orderStatus;
    private Byte deleteStatus;
    private Date createTime;
    private Date updateTime;
    private Date paymentTime;

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getShowId() {
        return showId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
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

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Byte getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Byte orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Byte getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Byte deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public OrderVo() {
    }

    public OrderVo(Long id, Long userId, Long showId, Long ticketId, String orderSn, String showName, Date showTime, String showPoster, String seatType, BigDecimal orderAmount, Byte orderStatus, Byte deleteStatus, Date createTime, Date updateTime, Date paymentTime) {
        this.id = id;
        this.userId = userId;
        this.showId = showId;
        this.ticketId = ticketId;
        this.orderSn = orderSn;
        this.showName = showName;
        this.showTime = showTime;
        this.showPoster = showPoster;
        this.seatType = seatType;
        this.orderAmount = orderAmount;
        this.orderStatus = orderStatus;
        this.deleteStatus = deleteStatus;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.paymentTime = paymentTime;
    }

}

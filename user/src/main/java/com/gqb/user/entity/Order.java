package com.gqb.user.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author GanQingbo
 * @Classname Order
 * @Description 订单实体类
 * @date 2021/3/10 15:41
 */
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    private Long id;
    /**
     * 订单号
     */
    private String orderSn;
    /**
     * 用户id
     */
    private  Long userId;
    /**
     * 演出id
     */
    private Long showId;
    /**
     * 售票id
     */
    private Long ticketId;
    /**
     * 座位号
     */
    private Integer seatNo;
    /**
     * 订单金额
     */
    private BigDecimal orderAmount;
    /**
     * 订单状态,0待支付，1已支付，3退票中，4退票完成
     */
    private Byte orderStatus;
    /**
     * 删除状态，0未删除，1已删除
     */
    private Byte deleteStatus;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 支付时间
     */
    private Date paymentTime;
    /**
     * 支付方式
     */
    private Byte paymentType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
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

    public Integer getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(Integer seatNo) {
        this.seatNo = seatNo;
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

    public Byte getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Byte paymentType) {
        this.paymentType = paymentType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Order() {
    }

    public Order(Long id, String orderSn, Long userId, Long showId, Long ticketId, Integer seatNo, BigDecimal orderAmount, Byte orderStatus, Byte deleteStatus, Date createTime, Date updateTime, Date paymentTime, Byte paymentType) {
        this.id = id;
        this.orderSn = orderSn;
        this.userId = userId;
        this.showId = showId;
        this.ticketId = ticketId;
        this.seatNo = seatNo;
        this.orderAmount = orderAmount;
        this.orderStatus = orderStatus;
        this.deleteStatus = deleteStatus;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.paymentTime = paymentTime;
        this.paymentType = paymentType;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderSn='" + orderSn + '\'' +
                ", userId=" + userId +
                ", showId=" + showId +
                ", ticketId=" + ticketId +
                ", seatNo=" + seatNo +
                ", orderAmount=" + orderAmount +
                ", orderStatus=" + orderStatus +
                ", deleteStatus=" + deleteStatus +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", paymentTime=" + paymentTime +
                ", paymentType=" + paymentType +
                '}';
    }
}

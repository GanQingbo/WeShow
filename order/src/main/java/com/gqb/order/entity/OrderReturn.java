package com.gqb.order.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author GanQingbo
 * @Classname OrderReturn
 * @Description 退票类
 * @date 2021/3/10 15:46
 */
public class OrderReturn implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Long orderId;
    private Long adminId;
    private Date createTime;
    private Date handleTime;
    /**
     * 退票状态，0待处理，1已退票，2已拒绝
     */
    private Byte returnStatus;
    private BigDecimal returnMoney;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(Date handleTime) {
        this.handleTime = handleTime;
    }

    public Byte getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(Byte returnStatus) {
        this.returnStatus = returnStatus;
    }

    public BigDecimal getReturnMoney() {
        return returnMoney;
    }

    public void setReturnMoney(BigDecimal returnMoney) {
        this.returnMoney = returnMoney;
    }

    public OrderReturn() {
    }

    public OrderReturn(Long id, Long orderId, Long adminId, Date createTime, Date handleTime, Byte returnStatus, BigDecimal returnMoney) {
        this.id = id;
        this.orderId = orderId;
        this.adminId = adminId;
        this.createTime = createTime;
        this.handleTime = handleTime;
        this.returnStatus = returnStatus;
        this.returnMoney = returnMoney;
    }

    @Override
    public String toString() {
        return "OrderReturn{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", adminId=" + adminId +
                ", createTime=" + createTime +
                ", handleTime=" + handleTime +
                ", returnStatus=" + returnStatus +
                ", returnMoney=" + returnMoney +
                '}';
    }
}

package com.gqb.order.entity.vo;

import com.gqb.order.entity.Order;

import java.io.Serializable;

/**
 * @author GanQingbo
 * @Classname ConfirmResponseVo
 * @Description 确认下单后返回数据
 * @date 2021/4/15 18:43
 */
public class ConfirmResponseVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Order order;
    /**
     * 错误状态码，0成功，
     */
    private Integer code;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public ConfirmResponseVo() {
    }

    public ConfirmResponseVo(Order order, Integer code) {
        this.order = order;
        this.code = code;
    }
}

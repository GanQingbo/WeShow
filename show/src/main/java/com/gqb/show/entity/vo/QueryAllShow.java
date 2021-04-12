package com.gqb.show.entity.vo;

import java.io.Serializable;

/**
 * @author GanQingbo
 * @Classname QueryAllShow
 * @Description 前台全部查询show
 * @date 2021/4/12 21:56
 */
public class QueryAllShow implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 演出类型
     */
    private String showType;
    /**
     * 演出城市
     */
    private String showCity;
    /**
     * 演出时间，0表示全部时间，7表示7天内，30表示一个月内
     */
    private int showTime;
    /**
     * 排序，0默认按时间，1按热度排序，2价格排序
     */
    private int showOrder;

    public String getShowType() {
        return showType;
    }

    public void setShowType(String showType) {
        this.showType = showType;
    }

    public String getShowCity() {
        return showCity;
    }

    public void setShowCity(String showCity) {
        this.showCity = showCity;
    }

    public int getShowTime() {
        return showTime;
    }

    public void setShowTime(int showTime) {
        this.showTime = showTime;
    }

    public int getShowOrder() {
        return showOrder;
    }

    public void setShowOrder(int showOrder) {
        this.showOrder = showOrder;
    }

    public QueryAllShow() {
    }

    public QueryAllShow(String showType, String showCity, int showTime, int showOrder) {
        this.showType = showType;
        this.showCity = showCity;
        this.showTime = showTime;
        this.showOrder = showOrder;
    }

    @Override
    public String toString() {
        return "QueryAllShow{" +
                "showType='" + showType + '\'' +
                ", showCity='" + showCity + '\'' +
                ", showTime=" + showTime +
                ", showOrder=" + showOrder +
                '}';
    }
}

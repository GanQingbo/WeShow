package com.gqb.show.entity;

import java.io.Serializable;

/**
 * @author GanQingbo
 * @Classname ShowType
 * @Description 演出类型实体类
 * @date 2021/2/25 10:32
 */
public class ShowType implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;
    /**
     * 表演类型
     */
    private String showType;

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

    public ShowType() {
    }

    public ShowType(Long id, String showType) {
        this.id = id;
        this.showType = showType;
    }
}

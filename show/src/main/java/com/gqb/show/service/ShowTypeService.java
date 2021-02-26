package com.gqb.show.service;


import com.gqb.show.entity.ShowType;

import java.util.List;

/**
 * @author GanQingbo
 * @Classname ShowTypeService
 * @Description 演出类型接口
 * @date 2021/2/25 11:45
 */
public interface ShowTypeService {
    int createShowType(ShowType showType);
    List<ShowType> selectAllShowType();
}

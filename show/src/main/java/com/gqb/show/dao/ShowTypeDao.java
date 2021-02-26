package com.gqb.show.dao;

import com.gqb.show.entity.ShowType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author GanQingbo
 * @Classname ShowTypeDao
 * @Description
 * @date 2021/2/25 11:17
 */
@Mapper
public interface ShowTypeDao {
    int createShowType(ShowType showType);
    List<ShowType> selectAllShowType();
}

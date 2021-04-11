package com.gqb.show.dao;

import com.gqb.show.entity.ShowHeat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * @program: WeShow
 * @description:
 * @author: Gan
 * @date: 2021-04-10 17:07
 **/
@Mapper
public interface ShowHeatDao {
    int createShowHeat(@Param("id")Long id);
}

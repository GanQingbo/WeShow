package com.gqb.show.dao;

import com.gqb.show.entity.Show;
import com.gqb.show.entity.UserShow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: WeShow
 * @description:
 * @author: Gan
 * @date: 2021-04-21 17:29
 **/
@Mapper
public interface UserShowDao {
    int userAddShow(UserShow userShow);
    int userReduceShow(UserShow userShow);
    List<Show> getUserShows(@Param("id") Long id);
}

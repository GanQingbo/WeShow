package com.gqb.show.service;

import com.github.pagehelper.PageInfo;
import com.gqb.show.entity.Show;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author GanQingbo
 * @Classname ShowService
 * @Description
 * @date 2021/2/25 18:24
 */
public interface ShowService {
    List<Show> getAllShow();
    List<Show> getShowByTime();
    List<Show> getShowByCity(String showCity);
    List<Show> getShowByPerformer(String showPerformer);
    List<Show> getShowByType(String showType);
    Show getShowById(Long id);
    List<Show> getShowByName(String showName);
    int createShow(Show show);
    int deleteShowById(Long id);
    int deleteShowByName(String showName);
    PageInfo<Show> getShowByPage(int page, int size);
}

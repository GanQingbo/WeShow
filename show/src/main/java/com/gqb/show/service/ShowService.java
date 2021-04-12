package com.gqb.show.service;

import com.github.pagehelper.PageInfo;
import com.gqb.show.entity.Show;
import com.gqb.show.entity.vo.CompleteShow;
import com.gqb.show.entity.vo.QueryAllShow;
import com.gqb.show.entity.vo.QueryShow;

import java.util.List;

/**
 * @author GanQingbo
 * @Classname ShowService
 * @Description
 * @date 2021/2/25 18:24
 */
public interface ShowService {
    List<Show> getAllShow();

//    PageInfo<Show> getShowByTime();

    List<Show> getShowByCity(String showCity);

    List<Show> getShowByPerformer(String showPerformer);

    List<Show> getShowByType(String showType);

    Show getShowById(Long id);

    List<Show> getShowByName(String showName);

    int createShow(Show show);

    int createShowHeat(Long id);

    int deleteShowById(Long id);

    int deleteShowByName(String showName);

    int updateShow(Show show);

    PageInfo<CompleteShow> getShowByPage(int page, int size, QueryShow show);

    PageInfo<Show> getShowByPageAndTime(int page, int size, Show show);

    List<Show> getAllShowByQuery(QueryAllShow queryShow);
}

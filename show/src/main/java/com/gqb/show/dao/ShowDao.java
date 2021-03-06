package com.gqb.show.dao;

import com.gqb.show.entity.Show;
import com.gqb.show.entity.vo.CompleteShow;
import com.gqb.show.entity.vo.PerfectShow;
import com.gqb.show.entity.vo.QueryAllShow;
import com.gqb.show.entity.vo.QueryShow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author GanQingbo
 * @Classname ShowDao
 * @Description
 * @date 2021/2/25 17:37
 */
@Mapper
public interface ShowDao {
    List<Show> getAllShows();

    List<Show> getShowByTime();

    List<Show> getShowByCity(@Param("showCity") String showCity);

    List<Show> getShowByPerformer(@Param("showPerformer") String showPerformer);

    List<Show> getShowByType(@Param("showType") String showType);

    List<Show> getShowByName(@Param("showName") String showName);

    Show getShowById(@Param("id") Long id);

    int createShow(Show show);

    int deleteShowById(@Param("id") Long id);

    int deleteShowByName(@Param("showName") String showName);

    int updateShow(Show show);

    List<CompleteShow> getCompleteShow(QueryShow show);

    List<Show> getShowByPageAndTime(Show show);

    List<PerfectShow> getAllShowByQuery(QueryAllShow queryShow);

    List<PerfectShow> getPerfectShow(QueryAllShow queryAllShow);

    List<PerfectShow> getPerfectShowByKey(@Param("key") String key);
}

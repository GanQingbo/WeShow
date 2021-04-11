package com.gqb.show.dao;

import com.gqb.show.entity.Recommend;
import com.gqb.show.entity.Show;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author GanQingbo
 * @Classname RecommendDao
 * @Description
 * @date 2021/3/31 12:39
 */
@Mapper
public interface RecommendDao {
    List<Show> getShowRecommend();
    int deleteRecommend(@Param("id") Long id);
    int createRecommend(@Param("id") Long id);
    List<Recommend> getAllRecommend();
    int getRecommendCount();
    List<Show> getShowByHeat();
}

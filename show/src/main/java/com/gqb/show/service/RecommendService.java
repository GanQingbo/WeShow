package com.gqb.show.service;

import com.gqb.show.entity.Recommend;
import com.gqb.show.entity.Show;

import java.util.List;

/**
 * @author GanQingbo
 * @Classname RecommendService
 * @Description
 * @date 2021/3/31 12:50
 */
public interface RecommendService {
    List<Show> getShowRecommend();
    List<Recommend> getAllRecommend();
    List<Show> getHotShow();
    List<Show> getPersonalRecommend();
    int createShowRecommend(Long id);
    int deleteShowRecommend(Long id);
}

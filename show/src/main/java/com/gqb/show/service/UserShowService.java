package com.gqb.show.service;

import com.gqb.show.entity.Show;
import com.gqb.show.entity.UserShow;

import java.util.List;

/**
 * @program: WeShow
 * @description: 用户收藏演出
 * @author: Gan
 * @date: 2021-04-21 17:42
 **/
public interface UserShowService {
    int userAddShow(UserShow userShow);
    int userReduceShow(UserShow userShow);
    List<Show> getUserShows(Long id);
    boolean userIsLike(UserShow userShow);
}

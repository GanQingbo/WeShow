package com.gqb.show.service.Impl;

import com.gqb.show.dao.ShowHeatDao;
import com.gqb.show.dao.UserShowDao;
import com.gqb.show.entity.Show;
import com.gqb.show.entity.UserShow;
import com.gqb.show.service.UserShowService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: WeShow
 * @description: 用户收藏演出
 * @author: Gan
 * @date: 2021-04-21 17:43
 **/
@Service
public class UserShowServiceImpl implements UserShowService {
    @Resource
    UserShowDao userShowDao;
    @Resource
    ShowHeatDao showHeatDao;

    @Override
    public int userAddShow(UserShow userShow) {
        int i = userShowDao.userAddShow(userShow);
        //热度
        showHeatDao.increaseLike(userShow.getShowId());
        return i;
    }

    @Override
    public int userReduceShow(UserShow userShow) {
        int i = userShowDao.userReduceShow(userShow);
        //热度
        showHeatDao.decreaseLike(userShow.getShowId());
        return i;
    }

    @Override
    public List<Show> getUserShows(Long id) {
        List<Show> shows = userShowDao.getUserShows(id);
        return shows;
    }
}

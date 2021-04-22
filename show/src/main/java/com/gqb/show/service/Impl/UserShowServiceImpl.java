package com.gqb.show.service.Impl;

import com.gqb.show.dao.ShowHeatDao;
import com.gqb.show.dao.UserShowDao;
import com.gqb.show.entity.Show;
import com.gqb.show.entity.ShowHeat;
import com.gqb.show.entity.UserShow;
import com.gqb.show.service.UserShowService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class UserShowServiceImpl implements UserShowService {
    @Resource
    UserShowDao userShowDao;
    @Resource
    ShowHeatDao showHeatDao;

    @Override
    public int userAddShow(UserShow userShow) {
        log.info("======用户id："+userShow.getUserId());
        int i = userShowDao.userAddShow(userShow);
        //热度
        showHeatDao.increaseLike(userShow.getShowId());
        updateShowHeat(userShow.getShowId());
        return i;
    }

    @Override
    public int userReduceShow(UserShow userShow) {
        int i = userShowDao.userReduceShow(userShow);
        //热度
        showHeatDao.decreaseLike(userShow.getShowId());
        updateShowHeat(userShow.getShowId());
        return i;
    }

    @Override
    public List<Show> getUserShows(Long id) {
        List<Show> shows = userShowDao.getUserShows(id);
        return shows;
    }

    //更新演出热度
    public int updateShowHeat(Long id) {
        ShowHeat showHeat = showHeatDao.getHeatById(id);
        //热度计算公式
        int heat=showHeat.getClicks()+showHeat.getLikes()+showHeat.getComments()*2;
        showHeat.setHeat(heat);
        int i = showHeatDao.updateHeat(showHeat);
        return i;
    }

    //判断是否已被收藏
    @Override
    public boolean userIsLike(UserShow userShow) {
        List<Show> shows = userShowDao.getUserShows(userShow.getUserId());
        for(Show show:shows){
            if(show.getId()==userShow.getShowId()){
                //已在收藏列表
                return true;
            }
        }
        return false;
    }
}

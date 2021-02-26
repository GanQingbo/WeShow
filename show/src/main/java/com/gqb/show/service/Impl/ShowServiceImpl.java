package com.gqb.show.service.Impl;

import com.gqb.show.dao.ShowDao;
import com.gqb.show.entity.Show;
import com.gqb.show.service.ShowService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author GanQingbo
 * @Classname ShowServcieImpl
 * @Description
 * @date 2021/2/25 18:25
 */
@Service
public class ShowServiceImpl implements ShowService {
    @Resource
    private ShowDao showDao;

    @Override
    public List<Show> getAllShow() {
        List<Show> shows = showDao.getAllShows();
        for(Show show:shows){
            System.out.println(show.getShowTime());
        }
        return shows;
    }

    /***
    *@Description 获取未开始的表演
    *@param
    *@return
    */
    @Override
    public List<Show> getShowByTime() {
        List<Show> shows = showDao.getShowByTime();
        return shows;
    }

    @Override
    public List<Show> getShowByCity(String showCity) {
        List<Show> showByCity = showDao.getShowByCity(showCity);
        return showByCity;
    }

    @Override
    public List<Show> getShowByPerformer(String showPerformer) {
        return null;
    }

    @Override
    public List<Show> getShowByType(String showType) {
        return null;
    }

    @Override
    public Show getShowById(Long id) {
        return null;
    }

    @Override
    public Show getShowByName(String showName) {
        return null;
    }

    @Override
    public int createShow(Show show) {
        return 0;
    }

    @Override
    public int deleteShowById(Long id) {
        return 0;
    }

    @Override
    public int deleteShowByName(String showName) {
        return 0;
    }
}

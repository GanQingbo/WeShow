package com.gqb.show.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    /***
    *@Description 获取全部表演信息
    *@param
    *@return
    */
    @Override
    public List<Show> getAllShow() {
        List<Show> shows = showDao.getAllShows();
        for(Show show:shows){
            System.out.println(show.getShowTime());
        }
        return shows;
    }

    /***
    *@Description 分页查询
    *@param page,size
    *@return
    */
    public PageInfo<Show> getShowByPage(int page,int size){
        System.out.println("page:"+page+"size:"+size);
        //开启分页插件page helper
        PageHelper.startPage(page,size);
        List<Show> shows = showDao.getAllShows();
        //封装到PageInfo
        PageInfo<Show> pageInfo=new PageInfo<>(shows);
        System.out.println("page:"+pageInfo.getPageNum()+"size:"+pageInfo.getPageSize());
        return pageInfo;
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
        List<Show> showByPerformer = showDao.getShowByPerformer(showPerformer);
        return showByPerformer;
    }

    @Override
    public List<Show> getShowByType(String showType) {
        List<Show> showByType = showDao.getShowByType(showType);
        return showByType;
    }

    @Override
    public Show getShowById(Long id) {
        Show showById = showDao.getShowById(id);
        return showById;
    }

    @Override
    public List<Show> getShowByName(String showName) {
        List<Show> showByName = showDao.getShowByName(showName);
        return showByName;
    }

    @Override
    public int createShow(Show show) {
        if(show!=null){
            return showDao.createShow(show);
        }
       return 0;
    }

    @Override
    public int deleteShowById(Long id) {
        return showDao.deleteShowById(id);
    }

    @Override
    public int deleteShowByName(String showName) {
        return showDao.deleteShowByName(showName);
    }
}

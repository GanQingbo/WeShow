package com.gqb.show.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gqb.show.dao.ShowDao;
import com.gqb.show.dao.ShowHeatDao;
import com.gqb.show.entity.Show;
import com.gqb.show.entity.vo.CompleteShow;
import com.gqb.show.entity.vo.QueryAllShow;
import com.gqb.show.entity.vo.QueryShow;
import com.gqb.show.service.ShowService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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

    @Resource
    private ShowHeatDao showHeatDao;

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
    public PageInfo<CompleteShow> getShowByPage(int page, int size, QueryShow show){
        //开启分页插件page helper
        PageHelper.startPage(page,size);
        List<CompleteShow> completeShow = showDao.getCompleteShow(show);
        //封装到PageInfo
        PageInfo<CompleteShow> pageInfo=new PageInfo<>(completeShow);
        return pageInfo;
    }


    /***
    *@Description 分页获取未开始的表演
    *@param
    *@return
    */
    @Override
    public PageInfo<Show> getShowByPageAndTime(int page,int size,Show show){
        PageHelper.startPage(page,size);
        List<Show> shows = showDao.getShowByPageAndTime(show);
        PageInfo<Show> pageInfo=new PageInfo<>(shows);
        return pageInfo;
    }

    /**
     * 前台Show带条件的查询
     * @param queryShow
     * @return
     */
    @Override
    public List<Show> getAllShowByQuery(QueryAllShow queryShow) {
        if(queryShow.getShowType()=="全部演出"){
            queryShow.setShowType("");
        }
        if(queryShow.getShowCity()=="全国"){
            queryShow.setShowCity("");
        }
        List<Show> shows = showDao.getAllShowByQuery(queryShow);
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

    /**
     * 添加演出
     * @param show
     * @return
     */
    @Override
    public int createShow(Show show) {
        if(show!=null){
            if(showDao.createShow(show)==1){
                return 1;
            }
        }
       return 0;
    }


    @Override
    public int createShowHeat(Long id) {
        int showHeat = showHeatDao.createShowHeat(id);
        return showHeat;
    }

    @Override
    public int deleteShowById(Long id) {
        return showDao.deleteShowById(id);
    }

    @Override
    public int deleteShowByName(String showName) {
        return showDao.deleteShowByName(showName);
    }

    @Override
    public int updateShow(Show show) {
        return showDao.updateShow(show);
    }

}

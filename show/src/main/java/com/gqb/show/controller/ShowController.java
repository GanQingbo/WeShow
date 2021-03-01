package com.gqb.show.controller;

import com.gqb.common.utils.R;
import com.gqb.show.entity.Show;
import com.gqb.show.service.ShowService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author GanQingbo
 * @Classname ShowController
 * @Description
 * @date 2021/2/25 18:26
 */
@RestController
@RequestMapping("/show/show")
public class ShowController {
    @Resource
    private ShowService showService;

    @GetMapping("/getAllShow")
    public R getAllShow(){
        List<Show> shows = showService.getAllShow();
        return R.ok().setData(shows);
    }

    @GetMapping("/getShowByTime")
    public R getShowByTime(){
        List<Show> shows=showService.getShowByTime();
        if (shows!=null&&!shows.isEmpty()){
            return R.ok().setData(shows);
        }
        return R.error("无查询结果");
    }

    @GetMapping("/getShowByCity/{showCity}")
    public R getShowByCity(@PathVariable String showCity){
        List<Show> lists = showService.getShowByCity(showCity);
        if(lists!=null&&!lists.isEmpty()){
            return R.ok().setData(lists);
        }
        return R.error("无查询结果");
    }

    @GetMapping("/getShowByPerformer/{showPerformer}")
    public R getShowByPerformer(@PathVariable String showPerformer){
        List<Show> showByPerformer = showService.getShowByPerformer(showPerformer);
        if(showByPerformer!=null&&!showByPerformer.isEmpty()){
            return R.ok().setData(showByPerformer);
        }
        return R.error("无查询结果");
    }

    @GetMapping("/getShowByType/{showType}")
    public R getShowByType(@PathVariable String showType){
        List<Show> showByType = showService.getShowByType(showType);
        if(showByType!=null&&!showByType.isEmpty()){
            return R.ok().setData(showByType);
        }
        return R.error("无查询结果");
    }

    @GetMapping("/getShowById/{id}")
    public R getShowById(@PathVariable Long id){
        Show showById = showService.getShowById(id);
        if(showById!=null){
            return R.ok().setData(showById);
        }
        return R.error("无查询结果");
    }

    @GetMapping("/getShowByName/{showName}")
    public R getShowByName(@PathVariable String showName){
        List<Show> showByName = showService.getShowByName(showName);
        if(showByName!=null &&!showByName.isEmpty()){
            return R.ok().setData(showByName);
        }
        return R.error("无查询结果");
    }
}

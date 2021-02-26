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
        if (shows!=null){
            return R.ok().setData(shows);
        }
        return R.error("无查询结果");
    }

    @GetMapping("/getShowByCity/{showCity}")
    public R getShowByCity(@PathVariable String showCity){
        List<Show> lists = showService.getShowByCity(showCity);
        if(lists!=null){
            return R.ok().setData(lists);
        }
        return R.error("无查询结果");
    }
}

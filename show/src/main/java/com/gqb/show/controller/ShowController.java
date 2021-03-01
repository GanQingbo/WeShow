package com.gqb.show.controller;

import com.github.pagehelper.PageInfo;
import com.gqb.common.utils.R;
import com.gqb.show.entity.Show;
import com.gqb.show.service.ShowService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/getShowByPage/{page}/{size}")
    public R getShowByPage(@PathVariable("page") Integer page,@PathVariable("size") Integer size){
        PageInfo<Show> showByPage = showService.getShowByPage(page, size);
        return R.ok().setData(showByPage);
    }

    @GetMapping("/getShowByTime")
    public R getShowByTime(){
        List<Show> shows=showService.getShowByTime();
        if (shows!=null&&!shows.isEmpty()){
            return R.ok().setData(shows);
        }
        return R.error("无查询结果");
    }

    @GetMapping("/getShowByPageAndTime/{page}/{size}")
    public R getShowByPageAndTime(@PathVariable("page") Integer page,@PathVariable("size") Integer size){
        PageInfo<Show> shows = showService.getShowByPageAndTime(page, size);
        return R.ok().setData(shows);
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

    @PostMapping("/createShow")
    public R createShow(@RequestBody Show show){
        int i = showService.createShow(show);
        if(i>0){
            return R.ok().put("id",show.getId());
        }
        return R.error(444,"创建Show失败");
    }

    @DeleteMapping("/deleteShowById/{id}")
    public R deleteById(@PathVariable Long id){
        int i = showService.deleteShowById(id);
        if(i>0){
            return R.ok();
        }
        return R.error("删除show失败");
    }

    @DeleteMapping("/deleteShowByName/{name}")
    public R deleteByName(@PathVariable String name){
        int i = showService.deleteShowByName(name);
        if(i>0){
            return R.ok();
        }
        return R.error("删除show失败");
    }

    @PostMapping("/updateShow")
    public R updateShow(@RequestBody Show show){
        int i = showService.updateShow(show);
        if(i>0){
            return R.ok();
        }
        return R.error("更新show失败");
    }
}

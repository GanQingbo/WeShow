package com.gqb.show.controller;

import com.gqb.common.utils.R;
import com.gqb.show.entity.Recommend;
import com.gqb.show.entity.Show;
import com.gqb.show.service.RecommendService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author GanQingbo
 * @Classname ShowCommendController
 * @Description
 * @date 2021/3/31 16:06
 */
@RestController
@RequestMapping("/show/recommend")
public class ShowCommendController {
    @Resource
    RecommendService recommendService;


    @GetMapping("/getAllRecommend")
    public R getAllCommend(){
        List<Recommend> allRecommend = recommendService.getAllRecommend();
        if(allRecommend!=null){
            return R.ok().data("recommend",allRecommend);
        }
        return R.error();
    }
    //缓存
    @GetMapping("/getShowRecommend")
    public R getShowCommend(){
        List<Show> recommend = recommendService.getShowRecommend();
        if(recommend!=null){
            return R.ok().data("show",recommend);
        }
        return R.error().message("缓存加载失败");
    }

    @PostMapping("/createShowRecommend/{id}")
    public R createShowCommend(@PathVariable("id") Long id){
        int i = recommendService.createShowRecommend(id);
        if(i==-2){
            return R.error().code(420).message("推荐数量已达上限");
        }
        if(i>0){
            return R.ok().message("创建成功");
        }
        return R.error().message("未知错误");
    }

    @DeleteMapping("/deleteShowRecommend/{id}")
    public R deleteShowRecommend(@PathVariable("id") Long id){
        int i = recommendService.deleteShowRecommend(id);
        if(i>0){
            return R.ok();
        }
        return R.error();
    }

    //热度前十的演出
    @GetMapping("/topHot")
    public R topHotShow(){
        List<Show> shows = recommendService.getHotShow();
        if(shows!=null && shows.size()!=0){
            return R.ok().data("show",shows);
        }
        return R.error().message("获取排行榜失败");
    }

    //个人推荐
    @GetMapping("/personalRecommend")
    public R personalRecommend(){
        return null;
    }
}

package com.gqb.show.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.github.pagehelper.util.StringUtil;
import com.gqb.show.dao.RecommendDao;
import com.gqb.show.entity.Recommend;
import com.gqb.show.entity.Show;
import com.gqb.show.service.RecommendService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author GanQingbo
 * @Classname RecommendServiceImpl
 * @Description
 * @date 2021/3/31 15:52
 */
@Service
public class RecommendServiceImpl implements RecommendService {

    @Resource
    RecommendDao recommendDao;

    //resource不能写成redisTemplate,根据名字注入
    @Resource
    StringRedisTemplate stringRedisTemplate;

    /**
     * 从缓存中获取首页轮换图数据
     * @return
     */
    @Override
    public List<Show> getShowRecommend() {
        String rotationJson = stringRedisTemplate.opsForValue().get("RotationRecommend");
        if(StringUtil.isEmpty(rotationJson)){
            //缓存中没有，从数据库读
            List<Show> shows = recommendDao.getShowRecommend();
            //转换为Json放进缓存中
            String s = JSON.toJSONString(shows);
            stringRedisTemplate.opsForValue().set("RotationRecommend",s);
            return shows;
        }
        //Json还原成List<Show>
        List<Show> shows = JSON.parseObject(rotationJson, new TypeReference<List<Show>>() {
        });
        return shows;
    }

    //后台查看的Recommmend数据
    @Override
    public List<Recommend> getAllRecommend() {
        List<Recommend> allRecommend = recommendDao.getAllRecommend();
        return allRecommend;
    }

    @Override
    public int createShowRecommend(Long id) {
        int count = recommendDao.getRecommendCount();
        if(count>3){
            //最多4个轮换
            return -2;
        }
        int i = recommendDao.createRecommend(id);
        return i;
    }

    @Override
    public int deleteShowRecommend(Long id) {
        int i = recommendDao.deleteRecommend(id);
        return i;
    }
}

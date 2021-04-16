package com.gqb.show;

import com.alibaba.fastjson.JSON;
import com.gqb.common.utils.R;
import com.gqb.show.feign.OrderFeign;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @author GanQingbo
 * @Classname MyShowTest
 * @Description
 * @date 2021/3/31 15:29
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MyShowTest {
    @Resource
    StringRedisTemplate stringRedisTemplate;
    @Resource
    OrderFeign orderFeign;

    @Test
    public void testRedisTemplate(){
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ops.set("hello","world"+ UUID.randomUUID().toString());
        String s = ops.get("hello");
        System.out.println("s:"+s);
    }

    @Test
    public void testJosn(){
        R r = orderFeign.getShowsByUserId(26L);
        String ids = r.getData().get("showId").toString();
        System.out.println(ids);
        List<Long> longs = JSON.parseArray(ids, Long.class);
        System.out.println(longs);

    }

}

package com.gqb.show;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
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

    @Test
    public void testRedisTemplate(){
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ops.set("hello","world"+ UUID.randomUUID().toString());
        String s = ops.get("hello");
        System.out.println("s:"+s);
    }
}

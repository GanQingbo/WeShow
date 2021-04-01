package com.gqb.order;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

/**
 * @author GanQingbo
 * @Classname OrderRedisTest
 * @Description
 * @date 2021/3/21 21:37
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderRedisTest {
    @Test
    public void test() {
        //1.连接redis服务端
        Jedis jedis = new Jedis("159.75.112.187", 6379);
        jedis.auth("123456");
        //2.操作redis
        String ping = jedis.ping();
        jedis.set("test", "hello world");
        System.out.println(ping);
        //3.关闭连接
        jedis.close();

    }
    @Test
    public void test2(){
        char c='我';
        int i=c;
        float f=c;
        double d=c;
        System.out.println(c);
        System.out.println(i);
        System.out.println(f);
        System.out.println(d);
        StringBuilder sb=new StringBuilder();
    }

}

    


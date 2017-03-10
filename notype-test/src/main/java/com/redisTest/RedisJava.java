package com.redisTest;

import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by cuiqingqing on 17/3/9.
 */
public class RedisJava {
    public static void main(String[] args){
        //连接本地的Redis服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connection to server successfully");
        //查看服务是否运行
        System.out.println("server is running:"+jedis.ping());

        //设置redis字符串数据
        jedis.set("runoobkey","hello girl");
        System.out.println("Stored string in redis:"+jedis.get("runoobkey"));
        //存储数据到列表中
        jedis.lpush("tutorial-list", "Redis");
        jedis.lpush("tutorial-list", "Mongodb");
        jedis.lpush("tutorial-list", "Mysql");
        // 获取存储的数据并输出
        List<String> list = jedis.lrange("tutorial-list", 0 ,5);
        for(int i=0; i<list.size(); i++) {
            System.out.println("Stored string in redis:: "+list.get(i));
        }
        // 获取数据并输出
        Set<String> listKey = jedis.keys("*");
        Iterator i = listKey.iterator();
        while(i.hasNext()){
            String key = (String) i.next();
            System.out.println("has key:"+key);
        }
    }
}

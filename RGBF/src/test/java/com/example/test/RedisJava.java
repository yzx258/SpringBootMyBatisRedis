package com.example.test;

import redis.clients.jedis.Jedis;

public class RedisJava {
    public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        System.out.println("连接成功");
        String ycw = jedis.get("ycw");
        System.out.println("ycw:"+ycw);
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
    }
}

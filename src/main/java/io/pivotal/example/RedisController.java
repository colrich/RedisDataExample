package io.pivotal.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {


    @Autowired
    protected RedisTemplate<String, String> redisTemplate;

    @RequestMapping(value = "/testredis")
    public String testRedis() {
        ValueOperations<String, String> valops = redisTemplate.opsForValue();
        valops.set("testkey", "some value");
        return "set key 'testkey'";
    }


}


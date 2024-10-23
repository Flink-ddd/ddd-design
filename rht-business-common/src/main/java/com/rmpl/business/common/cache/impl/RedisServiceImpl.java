//package com.rmpl.order.cache.impl;
//
//import com.rmpl.order.cache.CacheService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.data.redis.core.BoundHashOperations;
//import org.springframework.data.redis.core.BoundValueOperations;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import java.util.concurrent.TimeUnit;
//
///**
// * @author muxh
// * @version V1.0
// * @since 2021-08-04 11:46
// */
//@Slf4j
//@Component
//public class RedisServiceImpl implements CacheService {
//
//    @Resource
//    private StringRedisTemplate template;
//
//    @Override
//    public String get(String key) {
//        return template.boundValueOps(key).get();
//    }
//
//    @Override
//    public void set(String key, String value, long seconds) {
//        template.opsForValue().set(key, value, seconds, TimeUnit.MILLISECONDS);
//    }
//
//    @Override
//    public void set(String key, String value) {
//        template.opsForValue().set(key, value);
//    }
//
//    @Override
//    public Boolean del(String key) {
//        return template.delete(key);
//    }
//
//    /**
//     * 递增 递增完成之后再进行设置缓存时间，确保过期时间生效
//     */
//    @Override
//    public void setIncrement(String key, long seconds) {
//        log.info("使用redis进行递增：key{},缓存时间：{}", key, seconds);
//        BoundValueOperations<String, String> stringStringBoundValueOperations = template.boundValueOps(key);
//        stringStringBoundValueOperations.increment(1);
//        stringStringBoundValueOperations.expire(seconds, TimeUnit.MILLISECONDS);
//    }
//
//    @Override
//    public void set(String key, String hkey, String hvalue, long seconds) {
//        BoundHashOperations<String, Object, Object> stringObjectObjectBoundHashOperations = template.boundHashOps(key);
//        stringObjectObjectBoundHashOperations.expire(seconds, TimeUnit.MILLISECONDS);
//        stringObjectObjectBoundHashOperations.put(hkey, hvalue);
//    }
//
//    @Override
//    public String get(String key, String hkey) {
//        BoundHashOperations<String, Object, Object> stringObjectObjectBoundHashOperations = template.boundHashOps(key);
//        Object o = stringObjectObjectBoundHashOperations.get(hkey);
//        return o == null ? null : o.toString();
//    }
//}

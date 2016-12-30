package tk.mybatis.springboot.util;

import com.google.common.cache.*;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author zhou
 * @version V1.0
 * @Description:
 * @date 2016/12/29 13:47
 * @jdk v1.7
 * @tomcat v7.0
 */
public class CacheUtil {
    private static Cache<String, Object> cache =
            CacheBuilder
                    .newBuilder()
                    .maximumSize(1000)
                    .expireAfterWrite(120, TimeUnit.MINUTES)
                    .removalListener(new RemovalListener<String, Object>(){
                        @Override
                        public void onRemoval(RemovalNotification<String, Object> rn) {
                            System.out.println(rn.getKey()+"被移除");

                        }})
                    .build();

    public static void putCache(String key,Object value){
        cache.put(key,value);
    }

    public static Object getCache(String key) throws ExecutionException {
        return cache.getIfPresent(key);
    }

    public static void removeCache(String key){
        cache.invalidate(key);
    }


}

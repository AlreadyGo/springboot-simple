package tk.springboot.simple.util;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import org.apache.log4j.Logger;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author zhou
 * @Description:
 * @date 2016/12/29 13:47
 */
public class CacheUtil {
    private static Logger logger = Logger.getLogger(CacheUtil.class);

    private static Cache<String, Object> cache =
            CacheBuilder
                    .newBuilder()
                    .maximumSize(1000)
                    .expireAfterWrite(120, TimeUnit.MINUTES)
                    .removalListener(new RemovalListener<String, Object>() {
                        @Override
                        public void onRemoval(RemovalNotification<String, Object> rn) {
                            logger.info(rn.getKey() + "被移除");
                        }
                    })
                    .build();

    public static void putCache(String key, Object value) {
        cache.put(key, value);
    }

    public static Object getCache(String key) throws ExecutionException {
        return cache.getIfPresent(key);
    }

    public static void removeCache(String key) {
        cache.invalidate(key);
    }


}

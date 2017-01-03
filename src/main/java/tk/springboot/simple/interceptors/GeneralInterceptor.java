package tk.springboot.simple.interceptors;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import tk.springboot.simple.model.Permission;
import tk.springboot.simple.util.CacheUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

/**
 * @author zhou
 * @version V1.0
 * @Description:
 * @date 2016/12/29 14:04
 * @jdk v1.7
 * @tomcat v7.0
 */
public class GeneralInterceptor extends HandlerInterceptorAdapter {
    private AntPathMatcher matcher = new AntPathMatcher();
    private static Logger logger=Logger.getLogger(GeneralInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri=request.getRequestURI(),userCookie;
        boolean isSuccess=false;
        if((userCookie=parseUserCookie(request.getHeader("cookie")))!=null){
            JSONObject object=JSON.parseObject(userCookie);
            Object cache= CacheUtil.getCache(object.getString("name")+object.getString("timestamp"));
            if(cache!=null){
                List<Permission> permissionList= (List<Permission>)cache;
                for(Permission permission:permissionList){
                    if(matcher.match(permission.getUrl(),uri)){
                        isSuccess= true;
                    }
                }
            }
        }
        logger.info(String.format("uri:%s,%s",uri,isSuccess));
        return isSuccess;
    }
    private String parseUserCookie(String cookie){
       String[] s= cookie.split(";");
        for(String ss:s){
            String[] sss=ss.split("=");
                if("user".equals(sss[0].trim())){
                    try {
                        return URLDecoder.decode(sss[1],"utf-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
        }
        return null;
    }
}

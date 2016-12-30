package tk.mybatis.springboot.interceptors;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import tk.mybatis.springboot.model.Permission;
import tk.mybatis.springboot.util.CacheUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
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
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri=request.getRequestURI();
        String userCookie;
        if((userCookie=parseUserCookie(request.getHeader("cookie")))!=null){
            JSONObject object=JSON.parseObject(userCookie);
            Object cache= CacheUtil.getCache(object.getString("name")+object.getString("timestamp"));
            if(cache!=null){
                List<Permission> permissionList= (List<Permission>)cache;
                for(Permission permission:permissionList){
                    if(matcher.match(permission.getUrl(),uri)){
                        return true;
                    }
                }
            }
        }
        return false;
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

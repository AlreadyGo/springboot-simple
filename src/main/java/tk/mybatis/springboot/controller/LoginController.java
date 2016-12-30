package tk.mybatis.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.springboot.model.RespInfo;
import tk.mybatis.springboot.model.User;
import tk.mybatis.springboot.service.UserService;
import tk.mybatis.springboot.util.CacheUtil;

import java.util.concurrent.ExecutionException;

import static tk.mybatis.springboot.util.Consts.*;

/**
 * @author zhou
 * @version V1.0
 * @Description:
 * @date 2016/12/29 14:39
 * @jdk v1.7
 * @tomcat v7.0
 */
@RestController
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login/{timestamp}")
    public RespInfo login(@RequestBody User user,@PathVariable String timestamp) {
        User u=userService.getByNamePwd(user);
        int code=ERROR_CODE;
        if(u!=null){
            code=SUCCESS_CODE;
            String username=user.getName();
            CacheUtil.putCache(username+timestamp,userService.pullPermissions(username));
        }
       return new RespInfo(code,u,null);
    }

    @RequestMapping(value = "/pull/{key}")
    public RespInfo pull(@PathVariable String key) throws ExecutionException {

       return new RespInfo(SUCCESS_CODE, CacheUtil.getCache(key),null);
    }
}

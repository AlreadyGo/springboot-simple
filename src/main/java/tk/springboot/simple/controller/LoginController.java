package tk.springboot.simple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.springboot.simple.model.RespInfo;
import tk.springboot.simple.model.User;
import tk.springboot.simple.service.UserService;
import tk.springboot.simple.util.CacheUtil;
import tk.springboot.simple.util.Consts;

import java.util.concurrent.ExecutionException;

/**
 * @author zhou
 * @Description:
 * @date 2016/12/29 14:39
 * @jdk v1.8
 */
@RestController
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login/{timestamp}")
    public RespInfo login(@RequestBody User user, @PathVariable String timestamp) {
        User u=userService.getByNamePwd(user);
        int code= Consts.ERROR_CODE;
        if(u!=null){
            code= Consts.SUCCESS_CODE;
            String username=user.getName();
            CacheUtil.putCache(username+timestamp,userService.pullPermissions(username));
        }
       return new RespInfo(code,u,null);
    }

    @RequestMapping(value = "/pull/{key}")
    public RespInfo pull(@PathVariable String key) throws ExecutionException {

       return new RespInfo(Consts.SUCCESS_CODE, CacheUtil.getCache(key),null);
    }
}

package tk.springboot.simple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.springboot.simple.model.RespInfo;
import tk.springboot.simple.model.User;
import tk.springboot.simple.model.UserRole;
import tk.springboot.simple.model.enums.Status;
import tk.springboot.simple.model.view.DispatchView;
import tk.springboot.simple.service.UserRoleService;
import tk.springboot.simple.service.UserService;
import tk.springboot.simple.util.Consts;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    @RequestMapping("/all")
    public List<User> getAll() {
        return userService.getAll().stream().map(u->{u.setPassword(""); return u;}).collect(Collectors.toList());
    }

    @RequestMapping(value = "/view/{id}")
    public RespInfo view(@PathVariable Integer id) {
        User user = userService.getById(id);
        return new RespInfo(Consts.SUCCESS_CODE,user);
    }

    @RequestMapping(value = "/delete/{id}")
    public RespInfo delete(@PathVariable Integer id) {
        userService.deleteById(id);
        return new RespInfo(Consts.SUCCESS_CODE,null,"删除成功");
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public RespInfo save(@RequestBody User user) {
        String msg = user.getId() == null ? "注册成功" : "修改成功";
        userService.save(user);
        return new RespInfo(Consts.SUCCESS_CODE,user,msg);
    }

    @RequestMapping(value = "/updateStatus", method = RequestMethod.POST)
    public RespInfo updateStatus(@RequestBody User user) {
        String message=user.getStatus().equals(Status.VALID)?"启用成功":"禁用成功";
        userService.updateStatus(user);
        return new RespInfo(Consts.SUCCESS_CODE,null,message);
    }

    @RequestMapping(value = "/updatePassword/{origin}", method = RequestMethod.POST)
    public RespInfo updatePassword(@RequestBody User user,@PathVariable("origin") String origin) {
        boolean isSuccess=false;
        if(userService.checkPassword(user.getName(),origin) && userService.updatePasswordByName(user)==1){
            isSuccess=true;
        }
        return new RespInfo(Consts.SUCCESS_CODE,isSuccess,"");
    }

    @RequestMapping(value = "/dispatch", method = RequestMethod.POST)
    public RespInfo dispatch(@RequestBody DispatchView dispatchView) {
        Long userId=dispatchView.getId();
        userRoleService.deleteById(userId.intValue());
        List<UserRole> userRoles=new ArrayList<>();
        UserRole userRole;
        for(Long sid:dispatchView.getSubIds()){
            userRole=new UserRole();
            userRole.setUid(userId);
            userRole.setRid(sid);
            userRoles.add(userRole);
        }
        userRoleService.saveList(userRoles);
        return new RespInfo(Consts.SUCCESS_CODE,null,"配置成功");
    }

    @RequestMapping(value = "/getRolesByUid/{uid}")
    public RespInfo getRolesByUid(@PathVariable Integer uid) {
        return new RespInfo(Consts.SUCCESS_CODE,userRoleService.getById(uid),null);
    }
}

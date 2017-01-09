package tk.springboot.simple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.springboot.simple.model.RespInfo;
import tk.springboot.simple.model.Permission;
import tk.springboot.simple.service.PermissionService;
import tk.springboot.simple.util.Consts;

import java.util.List;

@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/all")
    public List<Permission> getAll(Permission permission) {
        return permissionService.getAll(permission);
    }

    @RequestMapping(value = "/view/{id}")
    public RespInfo view(@PathVariable Integer id) {
        Permission permission = permissionService.getById(id);
        return new RespInfo(Consts.SUCCESS_CODE,permission);
    }

    @RequestMapping(value = "/delete/{id}")
    public RespInfo delete(@PathVariable Integer id) {
        permissionService.deleteById(id);
        return new RespInfo(Consts.SUCCESS_CODE,null,"删除成功");
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public RespInfo save(@RequestBody Permission permission) {
        String msg = permission.getId() == null ? "新增成功!" : "修改成功!";
        permissionService.save(permission);
        return new RespInfo(Consts.SUCCESS_CODE,permission,msg);
    }
}

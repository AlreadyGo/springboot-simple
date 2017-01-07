/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2016 abel533@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package tk.springboot.simple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.springboot.simple.model.RespInfo;
import tk.springboot.simple.model.Role;
import tk.springboot.simple.model.RolePermission;
import tk.springboot.simple.model.enums.Status;
import tk.springboot.simple.model.view.DispatchView;
import tk.springboot.simple.service.RolePermissionService;
import tk.springboot.simple.service.RoleService;
import tk.springboot.simple.util.Consts;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private RolePermissionService rolePermissionService;
    @RequestMapping("/all")
    public List<Role> getAll(Role role) {
        return roleService.getAll(role);
    }

    @RequestMapping(value = "/view/{id}")
    public RespInfo view(@PathVariable Integer id) {
        Role role = roleService.getById(id);
        return new RespInfo(Consts.SUCCESS_CODE,role);
    }

    @RequestMapping(value = "/delete/{id}")
    public RespInfo delete(@PathVariable Integer id) {
        roleService.deleteById(id);
        return new RespInfo(Consts.SUCCESS_CODE,null,"删除成功");
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public RespInfo save(@RequestBody Role role) {
        roleService.save(role);
        return new RespInfo(Consts.SUCCESS_CODE,role,role.getId() == null ? "创建成功" : "修改成功"
        );
    }
    @RequestMapping(value = "/updateStatus", method = RequestMethod.POST)
    public RespInfo updateStatus(@RequestBody Role role) {
        String message=role.getStatus().equals(Status.VALID)?"启用成功":"禁用成功";
        roleService.updateStatus(role);
        return new RespInfo(Consts.SUCCESS_CODE,null,message);
    }
    @RequestMapping(value = "/dispatch", method = RequestMethod.POST)
    public RespInfo dispatch(@RequestBody DispatchView dispatchView) {
        Long rid=dispatchView.getId();
        rolePermissionService.deleteById(rid.intValue());
        List<RolePermission> rolePermissions=new ArrayList<>();
        RolePermission rolePermission;
        for(Long pid:dispatchView.getSubIds()){
            rolePermission=new RolePermission();
            rolePermission.setPid(pid);
            rolePermission.setRid(rid);
            rolePermissions.add(rolePermission);
        }
        rolePermissionService.saveList(rolePermissions);
        return new RespInfo(Consts.SUCCESS_CODE,null,"配置成功");
    }
    @RequestMapping(value = "/getPermissionIdsByRid/{rid}")
    public RespInfo getPermissionIdsByRid(@PathVariable Integer rid) {
        return new RespInfo(Consts.SUCCESS_CODE,rolePermissionService.getById(rid),null);
    }
}

package tk.mybatis.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.springboot.mapper.RolePermissionMapper;
import tk.mybatis.springboot.model.Role;
import tk.mybatis.springboot.model.RolePermission;

import java.util.List;

/**
 * @author zhou
 * @version V1.0
 * @Description:
 * @date 2016/12/26 15:05
 * @jdk v1.7
 * @tomcat v7.0
 */
@Service
public class RolePermissionService {
    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    public List<RolePermission> getAll(RolePermission rolePermission) {
        return rolePermissionMapper.selectAll();
    }

    public List<RolePermission> getById(Integer id) {
        Example example=new Example(Role.class);
        example.createCriteria().andCondition("rid=",id);
        return rolePermissionMapper.selectByExample(example);
    }

    public void deleteById(Integer roleId) {
        Example example=new Example(Role.class);
        example.createCriteria().andCondition("rid=",roleId);
        rolePermissionMapper.deleteByExample(example);
    }

    public void saveList(List<RolePermission> rolePermissions){
        rolePermissionMapper.insertList(rolePermissions);
    }
    public void save(RolePermission rolePermission) {
       rolePermissionMapper.insert(rolePermission);
    }
}

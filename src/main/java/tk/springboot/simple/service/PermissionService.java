package tk.springboot.simple.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.springboot.simple.mapper.PermissionMapper;
import tk.springboot.simple.model.Permission;

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
public class PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;

    public List<Permission> getAll(Permission permission) {
        return permissionMapper.selectAll();
    }

    public Permission getById(Integer id) {
        return permissionMapper.selectByPrimaryKey(id);
    }

    public void deleteById(Integer id) {
        permissionMapper.deleteByPrimaryKey(id);
    }

    public void save(Permission permission) {
        if (permission.getId() != null) {
            permissionMapper.updateByPrimaryKey(permission);
        } else {
            permissionMapper.insert(permission);
        }
    }
}

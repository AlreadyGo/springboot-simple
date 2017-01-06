package tk.springboot.simple.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.springboot.simple.mapper.RoleMapper;
import tk.springboot.simple.model.Role;
import tk.springboot.simple.model.enums.Status;

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
public class RoleService {
    @Autowired
    private RoleMapper roleMapper;

    public List<Role> getAll(Role role) {
        return roleMapper.selectAll();
    }

    public Role getById(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    public void deleteById(Integer id) {
        roleMapper.deleteByPrimaryKey(id);
    }

    public void save(Role role) {
        if (role.getId() != null) {
            roleMapper.updateByPrimaryKey(role);
        } else {
            role.setStatus(Status.VALID);
            roleMapper.insert(role);
        }
    }
    public void updateStatus(Role role){
        roleMapper.updateStatus(role);
    }
}

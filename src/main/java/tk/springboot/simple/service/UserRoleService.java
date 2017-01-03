package tk.springboot.simple.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.springboot.simple.mapper.UserRoleMapper;
import tk.springboot.simple.model.UserRole;

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
public class UserRoleService {
    @Autowired
    private UserRoleMapper userRoleMapper;

    public List<UserRole> getAll(UserRole userRole) {
        return userRoleMapper.selectAll();
    }

    public List<UserRole> getById(Integer id) {
        Example example=new Example(UserRole.class);
        example.createCriteria().andCondition("uid=",id);
       return userRoleMapper.selectByExample(example);
    }

    public void deleteById(Integer id) {
        Example example=new Example(UserRole.class);
        example.createCriteria().andCondition("uid=",id);
        userRoleMapper.deleteByExample(example);
    }

    public void save(UserRole userRole) {
       userRoleMapper.insert(userRole);
    }

    public void saveList(List<UserRole> userRoles) {
        userRoleMapper.insertList(userRoles);
    }


}

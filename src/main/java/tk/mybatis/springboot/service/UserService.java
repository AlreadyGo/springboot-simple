package tk.mybatis.springboot.service;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.springboot.mapper.UserMapper;
import tk.mybatis.springboot.model.Permission;
import tk.mybatis.springboot.model.User;
import tk.mybatis.springboot.model.enums.Status;

import java.util.Date;
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
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> getAll() {
        return userMapper.selectAll();
    }

    public User getById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public void deleteById(Integer id) {
        userMapper.deleteByPrimaryKey(id);
    }

    public void save(User user) {
        if (user.getId() != null) {
            userMapper.updateByPrimaryKey(user);
        } else {
            user.setStatus(Status.VALID);
            user.setCreateDate(new Date());
            user.setLastLogin(new Date());
            userMapper.insert(user);
        }
    }

    public User getByNamePwd(User user){
        return userMapper.selectOne(user);
    }

    public List<Permission> pullPermissions(String name){
        return userMapper.pullPermissions(name);
    }
}

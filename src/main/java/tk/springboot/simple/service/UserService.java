package tk.springboot.simple.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.springboot.simple.mapper.UserMapper;
import tk.springboot.simple.model.Permission;
import tk.springboot.simple.model.User;
import tk.springboot.simple.model.enums.Status;

import java.util.Date;
import java.util.List;

/**
 * @author zhou
 * @Description:
 * @date 2016/12/26 15:05
 * @jdk v1.8
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
            user.setUpdateDate(new Date());
            userMapper.updateByPrimaryKeySelective(user);
        } else {
            user.setStatus(Status.VALID);
            user.setCreateDate(new Date());
            user.setLastLogin(new Date());
            userMapper.insert(user);
        }
    }

    public void updateStatus(User user){
     userMapper.updateStatus(user);
    }

    public int updatePasswordByName(User user){
        Example example=new Example(User.class);
        example.createCriteria().andCondition("name=",user.getName());
        user.setUpdateDate(new Date());
        return userMapper.updateByExampleSelective(user,example);
    }

    public boolean checkPassword(String name,String password){
        Example example=new Example(User.class);
        example.createCriteria().andCondition("name=",name).andCondition("password=",password);
        return userMapper.selectCountByExample(example)==1?true:false;
    }

    public User getByNamePwd(User user){
        return userMapper.selectOne(user);
    }

    public List<Permission> pullPermissions(String name){
        return userMapper.pullPermissions(name);
    }
}

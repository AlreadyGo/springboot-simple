package tk.springboot.simple.mapper;

import org.apache.ibatis.annotations.Param;
import tk.springboot.simple.model.Permission;
import tk.springboot.simple.model.User;
import tk.springboot.simple.util.MyMapper;

import java.util.List;

public interface UserMapper extends MyMapper<User> {
    List<Permission> pullPermissions(@Param("name") String name);

    void updateStatus(User user);
}

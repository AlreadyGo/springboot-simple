package tk.springboot.simple.mapper;

import tk.springboot.simple.model.Role;
import tk.springboot.simple.util.MyMapper;

public interface RoleMapper extends MyMapper<Role> {
    void updateStatus(Role role);
}

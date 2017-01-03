package tk.springboot.simple.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
<<<<<<< HEAD:src/test/java/tk/mybatis/springboot/test/RoleTest.java
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.springboot.Application;
import tk.mybatis.springboot.model.Role;
import tk.mybatis.springboot.model.User;
import tk.mybatis.springboot.model.enums.Status;
import tk.mybatis.springboot.service.RoleService;
import tk.mybatis.springboot.service.UserService;

import java.util.Date;
=======
import tk.springboot.simple.Application;
import tk.springboot.simple.model.Role;
import tk.springboot.simple.model.enums.Status;
import tk.springboot.simple.service.RoleService;
>>>>>>> 8927f868c09713e707d37350ac50d3e4e74141fe:src/test/java/tk/springboot/simple/test/RoleTest.java

/**
 * @author zhou
 * @version V1.0
 * @Description:
 * @date 2016/12/27 15:39
 * @jdk v1.7
 * @tomcat v7.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Transactional
@SpringApplicationConfiguration(Application.class)
public class RoleTest {
    @Autowired
    private RoleService roleService;

    @Test
    public void roleSave(){
        for(int i=0;i<10;i++){
            Role role=new Role();
            role.setStatus(Status.VALID);
            role.setName("role"+i);
            role.setDescription("desc"+i);
            roleService.save(role);
        }

    }
}

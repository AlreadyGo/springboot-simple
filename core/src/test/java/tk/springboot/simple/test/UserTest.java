package tk.springboot.simple.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import tk.springboot.simple.Application;
import tk.springboot.simple.model.User;
import tk.springboot.simple.model.enums.Status;
import tk.springboot.simple.service.UserService;

import java.util.Date;

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
public class UserTest {
    @Autowired
    private UserService userService;

    @Test
    public void userSave() {
        for (int i = 0; i < 20; i++) {
            User user = new User();
            user.setLastLogin(new Date());
            user.setCreateDate(new Date());
            user.setPassword("password" + i);
            user.setName("name" + i);
            user.setStatus(Status.VALID);
            user.setEmail("email@address" + i);
            userService.save(user);
        }

    }
}

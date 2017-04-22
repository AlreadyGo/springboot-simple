package tk.springboot.simple.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import tk.springboot.simple.Application;
import tk.springboot.simple.model.Permission;
import tk.springboot.simple.model.enums.PermissionType;
import tk.springboot.simple.service.PermissionService;

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
public class PermissionTest {
    @Autowired
    private PermissionService permissionService;

    @Test
    public void userSave() {
        for (int i = 0; i < 44; i++) {
            Permission permission = new Permission();
            permission.setName("name" + i);
            PermissionType permissionType = null;
            if (i % 4 == 0) permissionType = PermissionType.BUTTON;
            if (i % 4 == 1) permissionType = PermissionType.MENU1ST;
            if (i % 4 == 2) permissionType = PermissionType.MENU2ND;
            permission.setPermissionType(permissionType);
            permission.setValue("value" + i);
            permission.setUrl("url" + i);
            permissionService.save(permission);
        }

    }
}

package tk.mybatis.springboot.model;

/**
 * @author zhou
 * @version V1.0
 * @Description:
 * @date 2016/12/26 14:22
 * @jdk v1.7
 * @tomcat v7.0
 */
public class RolePermission {
    private Long rid;
    private Long pid;

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }
}

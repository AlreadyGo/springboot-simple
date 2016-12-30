package tk.mybatis.springboot.model;

/**
 * @author zhou
 * @version V1.0
 * @Description:
 * @date 2016/12/26 14:21
 * @jdk v1.7
 * @tomcat v7.0
 */
public class UserRole {
    private Long uid;
    private Long rid;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }
}

package tk.mybatis.springboot.model;

import tk.mybatis.springboot.model.enums.Status;

import java.util.Date;

/**
 * @author zhou
 * @version V1.0
 * @Description:
 * @date 2016/12/26 14:09
 * @jdk v1.7
 * @tomcat v7.0
 */
public class User  extends BaseEntity{
    private String name;
    private String password;
    private String email;
    private Date createDate;
    private Date updateDate;
    private Date lastLogin;
    private Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}

package tk.mybatis.springboot.model;

import tk.mybatis.springboot.model.enums.Status;

/**
 * @author zhou
 * @version V1.0
 * @Description:
 * @date 2016/12/26 14:12
 * @jdk v1.7
 * @tomcat v7.0
 */
public class Role extends BaseEntity{
    private String name;
    private String description;
    private Status status;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

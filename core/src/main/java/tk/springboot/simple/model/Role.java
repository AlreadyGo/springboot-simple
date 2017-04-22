package tk.springboot.simple.model;

import tk.springboot.simple.model.enums.Status;

/**
 * @author zhou
 * @Description:
 * @date 2016/12/26 14:12
 */
public class Role extends BaseEntity {
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

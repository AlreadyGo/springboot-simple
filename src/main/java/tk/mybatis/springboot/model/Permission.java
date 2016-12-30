package tk.mybatis.springboot.model;

import tk.mybatis.springboot.model.enums.PermissionType;

/**
 * @author zhou
 * @version V1.0
 * @Description:
 * @date 2016/12/26 14:17
 * @jdk v1.7
 * @tomcat v7.0
 */
public class Permission extends BaseEntity{
    private String name;
    private PermissionType permissionType;
    private String value;
    private String url;
    private String description;
    private String style;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PermissionType getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(PermissionType permissionType) {
        this.permissionType = permissionType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

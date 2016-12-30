package tk.mybatis.springboot.model;

/**
 * @author zhou
 * @version V1.0
 * @Description:
 * @date 2016/12/26 16:04
 * @jdk v1.7
 * @tomcat v7.0
 */
public class RespInfo {
    private Integer status;

    private Object content;

    private String message;

    public RespInfo(Integer status, Object content, String message) {
        this.status = status;
        this.content = content;
        this.message = message;
    }
    public RespInfo(Integer status, Object content) {
        this.status = status;
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

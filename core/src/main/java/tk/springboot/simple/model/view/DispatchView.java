package tk.springboot.simple.model.view;

/**
 * @author zhou
 * @Description:
 * @date 2016/12/28 17:05
 * @jdk v1.8
 */
public class DispatchView {
    private Long id;

    private Long[] subIds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long[] getSubIds() {
        return subIds;
    }

    public void setSubIds(Long[] subIds) {
        this.subIds = subIds;
    }
}

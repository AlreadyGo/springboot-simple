package tk.springboot.simple.model;

import tk.springboot.simple.model.enums.UploadType;

import java.util.Date;

/**
 * @author zhou
 * @Description:
 * @date 2017/1/9 10:39
 * @jdk v1.8
 */
public class UploadResult extends BaseEntity {
    private Date createDate;
    private String detail;
    private UploadType uploadType;

    public UploadResult() {
    }

    public UploadResult(Date createDate, String detail, UploadType uploadType) {
        this.createDate = createDate;
        this.detail = detail;
        this.uploadType = uploadType;
    }


    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public UploadType getUploadType() {
        return uploadType;
    }

    public void setUploadType(UploadType uploadType) {
        this.uploadType = uploadType;
    }
}

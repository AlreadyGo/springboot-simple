package tk.springboot.simple.model;

import java.util.Date;

/**
 * @author zhou
 * @Description:
 * @date 2017/1/10 14:11
 * @jdk v1.8
 */
public class PersonalInfo extends BaseEntity {
    private String route;//承运线路
    private String driverName;//司机姓名
    private String carNum;//车号
    private String telephoneNum;//手机号
    private String carType;//车型
    private String carTeam;//车队
    private String bankNum;//银行账号
    private String orderRate;//接单频率
    private String serviceAbility;//服务能力
    private String address;//联系地址
    private String description;//备注
    private Date   createDate;
    private Date   updateDate;

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

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public String getTelephoneNum() {
        return telephoneNum;
    }

    public void setTelephoneNum(String telephoneNum) {
        this.telephoneNum = telephoneNum;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarTeam() {
        return carTeam;
    }

    public void setCarTeam(String carTeam) {
        this.carTeam = carTeam;
    }

    public String getBankNum() {
        return bankNum;
    }

    public void setBankNum(String bankNum) {
        this.bankNum = bankNum;
    }

    public String getOrderRate() {
        return orderRate;
    }

    public void setOrderRate(String orderRate) {
        this.orderRate = orderRate;
    }

    public String getServiceAbility() {
        return serviceAbility;
    }

    public void setServiceAbility(String serviceAbility) {
        this.serviceAbility = serviceAbility;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

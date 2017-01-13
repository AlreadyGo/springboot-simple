package tk.springboot.simple.model;

import java.util.Date;

/**
 * @author zhou
 * @Description:
 * @date 2017/1/9 14:55
 * @jdk v1.8
 */
public class DeliveryManInfo extends BaseEntity {
    private String code;//承运商代码
    private String name;//承运商名称
    private String address;//承运商地址
    private String serviceScope;//服务范围
    private String routeProvince;//承运路线省份
    private String routeCity;//承运路线城市
    private String originLinkWay;//始发地上海联系方式
    private String agencyLinkWay;//办事处联系方式
    private String mainLink;//主要联系人
    private String contract;//合同签订
    private String description;//其他说明
    private Date createDate;
    private Date updateDate;

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getRouteCity() {
        return routeCity;
    }

    public void setRouteCity(String routeCity) {
        this.routeCity = routeCity;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getServiceScope() {
        return serviceScope;
    }

    public void setServiceScope(String serviceScope) {
        this.serviceScope = serviceScope;
    }

    public String getRouteProvince() {
        return routeProvince;
    }

    public void setRouteProvince(String routeProvince) {
        this.routeProvince = routeProvince;
    }

    public String getOriginLinkWay() {
        return originLinkWay;
    }

    public void setOriginLinkWay(String originLinkWay) {
        this.originLinkWay = originLinkWay;
    }

    public String getAgencyLinkWay() {
        return agencyLinkWay;
    }

    public void setAgencyLinkWay(String agencyLinkWay) {
        this.agencyLinkWay = agencyLinkWay;
    }

    public String getMainLink() {
        return mainLink;
    }

    public void setMainLink(String mainLink) {
        this.mainLink = mainLink;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

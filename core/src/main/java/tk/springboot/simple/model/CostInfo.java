package tk.springboot.simple.model;//

import tk.springboot.simple.model.enums.CostStatus;

import java.util.Date;

/**
 * Created by Administrator on 2017/1/16.
 */
public class CostInfo extends BaseEntity{
    private String orderNum;//订单号
    private String transportWay;//运输方式
    private String receivingWay;//提货方式
    private String driverName;//承运司机
    private String carType;//车型
    private String carRental;//租车费用
    private String deliveryManName;//承运商
    private String expressNumber;//物流单号
    private String telephoneNum;//联系电话
    private String shippingCost;//运费单价
    private String receivingCost;//提货成本
    private String transportCost;//运输成本
    private String deliveryCost;//送货费
    private String otherCost;//其他费用
    private String totalCost;//总成本
    private CostStatus costStatus;//成本状态
    private Date createDate;
    private Date updateDate;

    public CostStatus getCostStatus() {
        return costStatus;
    }

    public void setCostStatus(CostStatus costStatus) {
        this.costStatus = costStatus;
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

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getTransportWay() {
        return transportWay;
    }

    public void setTransportWay(String transportWay) {
        this.transportWay = transportWay;
    }

    public String getReceivingWay() {
        return receivingWay;
    }

    public void setReceivingWay(String receivingWay) {
        this.receivingWay = receivingWay;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarRental() {
        return carRental;
    }

    public void setCarRental(String carRental) {
        this.carRental = carRental;
    }

    public String getDeliveryManName() {
        return deliveryManName;
    }

    public void setDeliveryManName(String deliveryManName) {
        this.deliveryManName = deliveryManName;
    }

    public String getExpressNumber() {
        return expressNumber;
    }

    public void setExpressNumber(String expressNumber) {
        this.expressNumber = expressNumber;
    }

    public String getTelephoneNum() {
        return telephoneNum;
    }

    public void setTelephoneNum(String telephoneNum) {
        this.telephoneNum = telephoneNum;
    }

    public String getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(String shippingCost) {
        this.shippingCost = shippingCost;
    }

    public String getReceivingCost() {
        return receivingCost;
    }

    public void setReceivingCost(String receivingCost) {
        this.receivingCost = receivingCost;
    }

    public String getTransportCost() {
        return transportCost;
    }

    public void setTransportCost(String transportCost) {
        this.transportCost = transportCost;
    }

    public String getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(String deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public String getOtherCost() {
        return otherCost;
    }

    public void setOtherCost(String otherCost) {
        this.otherCost = otherCost;
    }

    public String getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(String totalCost) {
        this.totalCost = totalCost;
    }
}

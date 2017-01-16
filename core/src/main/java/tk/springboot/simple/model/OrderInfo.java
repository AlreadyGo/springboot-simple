package tk.springboot.simple.model;

import java.util.Date;

/**
 * @author zhou
 * @Description:
 * @date 2017/1/11 14:47
 * @jdk v1.8
 */
public class OrderInfo extends BaseEntity {
    private String sendDate;//发货日期
    private String customerCode;//客户编号
    private String sender;//发货单位
    private String orderNum;//订单号
    private String originAddress;//提货地址
    private String destinationCity;//送货城市
    private String receiverCom;//收货客户
    private String receiverPerson;//收货人
    private String telephoneNum;//联系电话
    private String destinationAddress;//送货地址
    private String productName;//产品名称
    private String wrap;//包装
    private Integer count;//数量
    private Double weight;//重量
    private Double volume;//体积
    private String receiveDate;//到货日期
    private String settleWay;//结算方式
    private Double amount;//金额
    private Boolean isSettled;//是否结算
    private Boolean isCostCalc;//是否成本计算
    private Date createDate;
    private Date updateDate;

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getOriginAddress() {
        return originAddress;
    }

    public void setOriginAddress(String originAddress) {
        this.originAddress = originAddress;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public String getReceiverCom() {
        return receiverCom;
    }

    public void setReceiverCom(String receiverCom) {
        this.receiverCom = receiverCom;
    }

    public String getReceiverPerson() {
        return receiverPerson;
    }

    public void setReceiverPerson(String receiverPerson) {
        this.receiverPerson = receiverPerson;
    }

    public String getTelephoneNum() {
        return telephoneNum;
    }

    public void setTelephoneNum(String telephoneNum) {
        this.telephoneNum = telephoneNum;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getWrap() {
        return wrap;
    }

    public void setWrap(String wrap) {
        this.wrap = wrap;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public String getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(String receiveDate) {
        this.receiveDate = receiveDate;
    }

    public String getSettleWay() {
        return settleWay;
    }

    public void setSettleWay(String settleWay) {
        this.settleWay = settleWay;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Boolean getSettled() {
        return isSettled;
    }

    public void setSettled(Boolean settled) {
        isSettled = settled;
    }

    public Boolean getCostCalc() {
        return isCostCalc;
    }

    public void setCostCalc(Boolean costCalc) {
        isCostCalc = costCalc;
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

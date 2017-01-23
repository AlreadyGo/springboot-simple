package tk.springboot.simple.model;

import tk.springboot.simple.model.enums.AccountStatus;

import java.util.Date;

/**
 * @author zhou
 * @Description:
 * @date 2017/1/17 9:25
 * @jdk v1.8
 */
public class Account extends BaseEntity {
    private String orderNum;//订单号
    private Double measure;//结算标准量
    private Double price;//收入单价
    private Double freight;//运费收入
    private Double ladingCost;//提货费
    private Double deliveryCost;//送货费
    private Double otherCost;//其他费用
    private Double sum;//合计收入
    private Date createDate;
    private Date updateDate;
    private AccountStatus accountStatus;


    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Double getMeasure() {
        return measure;
    }

    public void setMeasure(Double measure) {
        this.measure = measure;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getFreight() {
        return freight;
    }

    public void setFreight(Double freight) {
        this.freight = freight;
    }

    public Double getLadingCost() {
        return ladingCost;
    }

    public void setLadingCost(Double ladingCost) {
        this.ladingCost = ladingCost;
    }

    public Double getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(Double deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public Double getOtherCost() {
        return otherCost;
    }

    public void setOtherCost(Double otherCost) {
        this.otherCost = otherCost;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
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

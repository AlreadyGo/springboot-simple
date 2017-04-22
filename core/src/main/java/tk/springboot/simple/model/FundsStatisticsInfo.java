package tk.springboot.simple.model;

import java.util.Date;

/**
 * Created by Administrator on 2017/1/18.
 */
public class FundsStatisticsInfo extends BaseEntity {
    private Date paymentDate;//付款日期
    private String orderNum;//订单号
    private String discountNetting;//回扣冲低
    private String paidTrunk;//已付款
    private String balancesTrunk;//余额款
    private String clearingForm;//结算方式
    private String paidShort;//已付款
    private String balancesShort;//余额款
    private String rebateAmount;//回扣金额
    private String chargeSituation;//收款情况
    private Date createDate;
    private Date updateDate;


    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getDiscountNetting() {
        return discountNetting;
    }

    public void setDiscountNetting(String discountNetting) {
        this.discountNetting = discountNetting;
    }

    public String getPaidTrunk() {
        return paidTrunk;
    }

    public void setPaidTrunk(String paidTrunk) {
        this.paidTrunk = paidTrunk;
    }

    public String getBalancesTrunk() {
        return balancesTrunk;
    }

    public void setBalancesTrunk(String balancesTrunk) {
        this.balancesTrunk = balancesTrunk;
    }

    public String getClearingForm() {
        return clearingForm;
    }

    public void setClearingForm(String clearingForm) {
        this.clearingForm = clearingForm;
    }

    public String getPaidShort() {
        return paidShort;
    }

    public void setPaidShort(String paidShort) {
        this.paidShort = paidShort;
    }

    public String getBalancesShort() {
        return balancesShort;
    }

    public void setBalancesShort(String balancesShort) {
        this.balancesShort = balancesShort;
    }

    public String getRebateAmount() {
        return rebateAmount;
    }

    public void setRebateAmount(String rebateAmount) {
        this.rebateAmount = rebateAmount;
    }

    public String getChargeSituation() {
        return chargeSituation;
    }

    public void setChargeSituation(String chargeSituation) {
        this.chargeSituation = chargeSituation;
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

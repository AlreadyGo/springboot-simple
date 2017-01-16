package tk.springboot.simple.model;

import java.util.Date;

/**
 * @author zhou
 * @Description:
 * @date 2017/1/6 9:58
 */
public class SendInfo extends BaseEntity{
    private String code;//客户编码
    private String name;//客户名称
    private String accountMeasure;//结算标准量
    private String productType;//产品类型
    private String goodsType;//货物类型
    private String bizType;//业务类型
    private String swapType;//产品包装
    private String receiverType;//收货客户类型
    private String bizDesc;//主要业务描述
    private String baseLink;//客户联系人
    private String baseLinkWay;//联系方式
    private String baseGoodsAddress;//客户提货地址
    private String mainLink;//主要客户联系人
    private String mainLinkWay;//主要联系方式;
    private Date createDate;
    private Date updateDate;

    public SendInfo() {
    }

    public SendInfo(String code, String name) {
        this.code = code;
        this.name = name;
    }

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

    public String getAccountMeasure() {
        return accountMeasure;
    }

    public void setAccountMeasure(String accountMeasure) {
        this.accountMeasure = accountMeasure;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getSwapType() {
        return swapType;
    }

    public void setSwapType(String swapType) {
        this.swapType = swapType;
    }

    public String getReceiverType() {
        return receiverType;
    }

    public void setReceiverType(String receiverType) {
        this.receiverType = receiverType;
    }

    public String getBizDesc() {
        return bizDesc;
    }

    public void setBizDesc(String bizDesc) {
        this.bizDesc = bizDesc;
    }

    public String getBaseLink() {
        return baseLink;
    }

    public void setBaseLink(String baseLink) {
        this.baseLink = baseLink;
    }

    public String getBaseLinkWay() {
        return baseLinkWay;
    }

    public void setBaseLinkWay(String baseLinkWay) {
        this.baseLinkWay = baseLinkWay;
    }

    public String getBaseGoodsAddress() {
        return baseGoodsAddress;
    }

    public void setBaseGoodsAddress(String baseGoodsAddress) {
        this.baseGoodsAddress = baseGoodsAddress;
    }

    public String getMainLink() {
        return mainLink;
    }

    public void setMainLink(String mainLink) {
        this.mainLink = mainLink;
    }

    public String getMainLinkWay() {
        return mainLinkWay;
    }

    public void setMainLinkWay(String mainLinkWay) {
        this.mainLinkWay = mainLinkWay;
    }
}

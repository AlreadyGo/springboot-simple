package tk.springboot.simple.util;

import org.apache.commons.lang.StringUtils;
import tk.comm.model.CellBean;
import tk.comm.model.SheetBean;
import tk.springboot.simple.model.DeliveryManInfo;
import tk.springboot.simple.model.OrderInfo;
import tk.springboot.simple.model.PersonalInfo;
import tk.springboot.simple.model.SendInfo;

import java.util.*;

/**
 * @author zhou
 * @Description:
 * @date 2017/1/6 11:01
 * @jdk v1.8
 */
public class UploadExcelRules {
    private static final int SENDINFO_SHEET = 0;
    private static final int SENDINFO_BEGIN_ROW = 1;


    private static final int DELIVERYMANINFO_SHEET = 1;
    private static final int DELIVERYMANINFO_ROW = 0;

    private static final int PERSONALINFO_SHEET = 2;
    private static final int PERSONALINFO_ROW = 0;


    private static final int ORDER_SHEET = 0;
    private static final int ORDER_ROW = 1;


    public static List<SendInfo> parseSendInfos(List<SheetBean> sheetBeans) {
        List<SendInfo> sendInfos = new ArrayList<>();
        SendInfo sendInfo;
        SheetBean sheetBean = sheetBeans.get(SENDINFO_SHEET);
        List<CellBean> cellBeans = sheetBean.getCellBeanList();
        Map<Integer, List<CellBean>> combineResult = combineByRow(cellBeans);
        if (combineResult.size() > 0) {
            for (Map.Entry<Integer, List<CellBean>> entry : combineResult.entrySet()) {
                Integer row = entry.getKey();
                if (row > SENDINFO_BEGIN_ROW) {
                    List<CellBean> cellBeanList = entry.getValue();
                    sendInfo = new SendInfo();
                    for (CellBean cellBean : cellBeanList) {
                        int colNo = cellBean.getColNo();
                        String cellData = cellBean.getCellData().trim();
                        if (colNo == 1) sendInfo.setCode(cellData);
                        if (colNo == 2) sendInfo.setName(cellData);
                        if (colNo == 3) sendInfo.setAccountMeasure(cellData);
                        if (colNo == 4) sendInfo.setProductType(cellData);
                        if (colNo == 5) sendInfo.setGoodsType(cellData);
                        if (colNo == 6) sendInfo.setBizType(cellData);
                        if (colNo == 7) sendInfo.setSwapType(cellData);
                        if (colNo == 8) sendInfo.setReceiverType(cellData);
                        if (colNo == 9) sendInfo.setBizDesc(cellData);
                        if (colNo == 10) sendInfo.setBaseLink(cellData);
                        if (colNo == 11) sendInfo.setBaseLinkWay(cellData);
                        if (colNo == 12) sendInfo.setBaseGoodsAddress(cellData);
                        if (colNo == 13) sendInfo.setMainLink(cellData);
                        if (colNo == 14) sendInfo.setMainLinkWay(cellData);
                    }
                    sendInfo.setCreateDate(new Date());
                    sendInfo.setUpdateDate(new Date());
                    sendInfos.add(sendInfo);
                }
            }
        }
        return sendInfos;
    }

    private static Map<Integer, List<CellBean>> combineByRow(List<CellBean> cellBeans) {
        Map<Integer, List<CellBean>> map = new HashMap();
        for (CellBean cellBean : cellBeans) {
            int rowNo = cellBean.getRowNo();
            map.putIfAbsent(rowNo, new ArrayList<CellBean>() {
                {
                    add(cellBean);
                }
            });
            map.get(rowNo).add(cellBean);
        }
        return map;
    }

    public static List<DeliveryManInfo> parseDeliveryManInfos(List<SheetBean> sheetBeans) {
        List<DeliveryManInfo> deliveryManInfos = new ArrayList<>();
        DeliveryManInfo deliveryManInfo;
        SheetBean sheetBean = sheetBeans.get(DELIVERYMANINFO_SHEET);
        List<CellBean> cellBeans = sheetBean.getCellBeanList();
        Map<Integer, List<CellBean>> combineResult = combineByRow(cellBeans);
        if (combineResult.size() > 0) {
            for (Map.Entry<Integer, List<CellBean>> entry : combineResult.entrySet()) {
                Integer row = entry.getKey();
                if (row > DELIVERYMANINFO_ROW) {
                    List<CellBean> cellBeanList = entry.getValue();
                    deliveryManInfo = new DeliveryManInfo();
                    for (CellBean cellBean : cellBeanList) {
                        int colNo = cellBean.getColNo();
                        String cellData = cellBean.getCellData().trim();
                        if (colNo == 1) deliveryManInfo.setCode(cellData);
                        if (colNo == 2) deliveryManInfo.setName(cellData);
                        if (colNo == 3) deliveryManInfo.setAddress(cellData);
                        if (colNo == 4) deliveryManInfo.setServiceScope(cellData);
                        if (colNo == 5) deliveryManInfo.setRouteProvince(cellData);
                        if (colNo == 6) deliveryManInfo.setRouteCity(cellData);
                        if (colNo == 7) deliveryManInfo.setOriginLinkWay(cellData);
                        if (colNo == 8) deliveryManInfo.setAgencyLinkWay(cellData);
                        if (colNo == 9) deliveryManInfo.setMainLink(cellData);
                        if (colNo == 10) deliveryManInfo.setContract(cellData);
                        if (colNo == 11) deliveryManInfo.setDescription(cellData);
                    }
                    deliveryManInfo.setCreateDate(new Date());
                    deliveryManInfo.setUpdateDate(new Date());
                    deliveryManInfos.add(deliveryManInfo);
                }
            }
        }
        return deliveryManInfos;
    }

    public static List<PersonalInfo> parsePersonalInfos(List<SheetBean> sheetBeans) {
        List<PersonalInfo> personalInfos = new ArrayList<>();
        PersonalInfo personalInfo;
        SheetBean sheetBean = sheetBeans.get(PERSONALINFO_SHEET);
        List<CellBean> cellBeans = sheetBean.getCellBeanList();
        Map<Integer, List<CellBean>> combineResult = combineByRow(cellBeans);
        if (combineResult.size() > 0) {
            for (Map.Entry<Integer, List<CellBean>> entry : combineResult.entrySet()) {
                Integer row = entry.getKey();
                if (row > PERSONALINFO_ROW) {
                    List<CellBean> cellBeanList = entry.getValue();
                    personalInfo = new PersonalInfo();
                    for (CellBean cellBean : cellBeanList) {
                        int colNo = cellBean.getColNo();
                        String cellData = cellBean.getCellData().trim();
                        if (colNo == 1) personalInfo.setRoute(cellData);
                        if (colNo == 2) personalInfo.setDriverName(cellData);
                        if (colNo == 3) personalInfo.setCarNum(cellData);
                        if (colNo == 4) personalInfo.setTelephoneNum(cellData);
                        if (colNo == 5) personalInfo.setCarType(cellData);
                        if (colNo == 6) personalInfo.setCarTeam(cellData);
                        if (colNo == 7) personalInfo.setBankNum(cellData);
                        if (colNo == 8) personalInfo.setOrderRate(cellData);
                        if (colNo == 9) personalInfo.setServiceAbility(cellData);
                        if (colNo == 10) personalInfo.setAddress(cellData);
                        if (colNo == 11) personalInfo.setDescription(cellData);
                    }
                    personalInfo.setCreateDate(new Date());
                    personalInfo.setUpdateDate(new Date());
                    personalInfos.add(personalInfo);
                }
            }
        }
        return personalInfos;
    }

    public static List<OrderInfo> parseOrders(List<SheetBean> sheetBeans) {
        List<OrderInfo> orders = new ArrayList<>();
        OrderInfo order;
        SheetBean sheetBean = sheetBeans.get(ORDER_SHEET);
        List<CellBean> cellBeans = sheetBean.getCellBeanList();
        Map<Integer, List<CellBean>> combineResult = combineByRow(cellBeans);
        if (combineResult.size() > 0) {
            for (Map.Entry<Integer, List<CellBean>> entry : combineResult.entrySet()) {
                Integer row = entry.getKey();
                if (row > ORDER_ROW) {
                    List<CellBean> cellBeanList = entry.getValue();
                    order = new OrderInfo();
                    for (CellBean cellBean : cellBeanList) {
                        int colNo = cellBean.getColNo();
                        String cellData = cellBean.getCellData().trim();
                        if (colNo == 1) order.setSendDate(cellData);
                        if (colNo == 2) order.setCustomerCode(cellData);
                        if (colNo == 3) order.setSender(cellData);
                        if (colNo == 4) order.setOrderNum(cellData);
                        if (colNo == 5) order.setOriginAddress(cellData);
                        if (colNo == 6) order.setDestinationCity(cellData);
                        if (colNo == 7) order.setReceiverCom(cellData);
                        if (colNo == 8) order.setReceiverPerson(cellData);
                        if (colNo == 9) order.setTelephoneNum(cellData);
                        if (colNo == 10) order.setDestinationAddress(cellData);
                        if (colNo == 11) order.setProductName(cellData);
                        if (colNo == 12) order.setWrap(cellData);
                        if (colNo == 13)
                            order.setCount(StringUtils.isEmpty(cellData) ? null : Double.valueOf(cellData).intValue());
                        if (colNo == 14)
                            order.setWeight(StringUtils.isEmpty(cellData) ? null : Double.valueOf(cellData));
                        if (colNo == 15)
                            order.setVolume(StringUtils.isEmpty(cellData) ? null : Double.valueOf(cellData));
                        if (colNo == 16) order.setReceiveDate(cellData);
                        if (colNo == 17) order.setSettleWay(cellData);
                        if (colNo == 18)
                            order.setAmount(StringUtils.isEmpty(cellData) ? null : Double.valueOf(cellData));
                    }
                    order.setCreateDate(new Date());
                    order.setUpdateDate(new Date());
                    orders.add(order);
                }
            }
        }
        return orders;
    }
}

package tk.springboot.simple.util;

import tk.comm.model.CellBean;
import tk.comm.model.SheetBean;
import tk.springboot.simple.model.DeliveryManInfo;
import tk.springboot.simple.model.SendInfo;

import java.util.*;

/**
 * @author zhou
 * @Description:
 * @date 2017/1/6 11:01
 * @jdk v1.8
 */
public class UploadExcelRules {
    private static final int SENDINFO_SHEET=0;
    private static final int SENDINFO_BEGIN_ROW=1;


    private static final int DELIVERYMANINFO_SHEET=1;
    private static final int DELIVERYMANINFO_ROW=0;


    public static List<SendInfo> parseSendInfos(List<SheetBean> sheetBeans){
        List<SendInfo> sendInfos=new ArrayList<>();
        SendInfo sendInfo;
        SheetBean sheetBean=sheetBeans.get(SENDINFO_SHEET);
        List<CellBean> cellBeans=sheetBean.getCellBeanList();
        Map<Integer,List<CellBean>> combineResult=combineByRow(cellBeans);
        if(combineResult.size()>0){
            for(Map.Entry<Integer, List<CellBean>> entry:combineResult.entrySet()){
                Integer row=entry.getKey();
                if(row>SENDINFO_BEGIN_ROW){
                    List<CellBean> cellBeanList=entry.getValue();
                    sendInfo=new SendInfo();
                    for(CellBean cellBean:cellBeanList){
                        int colNo=cellBean.getColNo();
                        String cellData=cellBean.getCellData();
                        if(colNo==1) sendInfo.setCode(cellData);
                        if(colNo==2) sendInfo.setName(cellData);
                        if(colNo==3) sendInfo.setAccountMeasure(cellData);
                        if(colNo==4) sendInfo.setProductType(cellData);
                        if(colNo==5) sendInfo.setGoodsType(cellData);
                        if(colNo==6) sendInfo.setBizType(cellData);
                        if(colNo==7) sendInfo.setSwapType(cellData);
                        if(colNo==8) sendInfo.setReceiverType(cellData);
                        if(colNo==9) sendInfo.setBizDesc(cellData);
                        if(colNo==10) sendInfo.setBaseLink(cellData);
                        if(colNo==11) sendInfo.setBaseLinkWay(cellData);
                        if(colNo==12) sendInfo.setBaseGoodsAddress(cellData);
                        if(colNo==13) sendInfo.setMainLink(cellData);
                        if(colNo==14) sendInfo.setMainLinkWay(cellData);
                    }
                    sendInfo.setCreateDate(new Date());
                    sendInfos.add(sendInfo);
                }
            }
        }
        return sendInfos;
    }

    private static Map<Integer, List<CellBean>> combineByRow(List<CellBean> cellBeans) {
        Map<Integer,List<CellBean>> map=new HashMap();
        for(CellBean cellBean:cellBeans){
            int rowNo=cellBean.getRowNo();
            map.putIfAbsent(rowNo, new ArrayList<CellBean>() {
                {add(cellBean);}
            });
            map.get(rowNo).add(cellBean);
        }
        return map;
    }

    public static List<DeliveryManInfo> parseDeliveryManInfos(List<SheetBean> sheetBeans) {
        List<DeliveryManInfo> deliveryManInfos=new ArrayList<>();
        DeliveryManInfo deliveryManInfo;
        SheetBean sheetBean=sheetBeans.get(DELIVERYMANINFO_SHEET);
        List<CellBean> cellBeans=sheetBean.getCellBeanList();
        Map<Integer,List<CellBean>> combineResult=combineByRow(cellBeans);
        if(combineResult.size()>0){
            for(Map.Entry<Integer, List<CellBean>> entry:combineResult.entrySet()){
                Integer row=entry.getKey();
                if(row>DELIVERYMANINFO_ROW){
                    List<CellBean> cellBeanList=entry.getValue();
                    deliveryManInfo=new DeliveryManInfo();
                    for(CellBean cellBean:cellBeanList){
                        int colNo=cellBean.getColNo();
                        String cellData=cellBean.getCellData();
                        if(colNo==1) deliveryManInfo.setCode(cellData);
                        if(colNo==2) deliveryManInfo.setName(cellData);
                        if(colNo==3) deliveryManInfo.setAddress(cellData);
                        if(colNo==4) deliveryManInfo.setServiceScope(cellData);
                        if(colNo==5) deliveryManInfo.setRouteProvince(cellData);
                        if(colNo==6) deliveryManInfo.setRouteCity(cellData);
                        if(colNo==7) deliveryManInfo.setOriginLinkWay(cellData);
                        if(colNo==8) deliveryManInfo.setAgencyLinkWay(cellData);
                        if(colNo==9) deliveryManInfo.setMainLink(cellData);
                        if(colNo==10) deliveryManInfo.setContract(cellData);
                        if(colNo==11) deliveryManInfo.setDescription(cellData);
                    }
                    deliveryManInfo.setCreateDate(new Date());
                    deliveryManInfos.add(deliveryManInfo);
                }
            }
        }
        return deliveryManInfos;
    }
}

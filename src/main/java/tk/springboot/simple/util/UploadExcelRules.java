package tk.springboot.simple.util;

import tk.comm.model.CellBean;
import tk.comm.model.SheetBean;
import tk.springboot.simple.model.SendInfo;

import java.util.*;

/**
 * @author zhou
 * @Description:
 * @date 2017/1/6 11:01
 * @jdk v1.8
 */
public class UploadExcelRules {
    public static List<SendInfo> parseSendInfos(List<SheetBean> sheetBeans){
        List<SendInfo> sendInfos=new ArrayList<>();
        SendInfo sendInfo;
        SheetBean sheetBean=sheetBeans.get(0);
        List<CellBean> cellBeans=sheetBean.getCellBeanList();
        Map<Integer,List<CellBean>> combineResult=combineByRow(cellBeans);
        if(combineResult.size()>0){
            for(Map.Entry<Integer, List<CellBean>> entry:combineResult.entrySet()){
                Integer row=entry.getKey();
                if(row>1){
                    List<CellBean> cellBeanList=entry.getValue();
                    sendInfo=new SendInfo();
                    for(CellBean cellBean:cellBeanList){
                        int colNo=cellBean.getColNo();
                        if(colNo==1) sendInfo.setCode(cellBean.getCellData());
                        if(colNo==2) sendInfo.setName(cellBean.getCellData());
                        if(colNo==3) sendInfo.setAccountMeasure(cellBean.getCellData());
                        if(colNo==4) sendInfo.setProductType(cellBean.getCellData());
                        if(colNo==5) sendInfo.setGoodsType(cellBean.getCellData());
                        if(colNo==6) sendInfo.setBizType(cellBean.getCellData());
                        if(colNo==7) sendInfo.setSwapType(cellBean.getCellData());
                        if(colNo==8) sendInfo.setReceiverType(cellBean.getCellData());
                        if(colNo==9) sendInfo.setBizDesc(cellBean.getCellData());
                        if(colNo==10) sendInfo.setBaseLink(cellBean.getCellData());
                        if(colNo==11) sendInfo.setBaseLinkWay(cellBean.getCellData());
                        if(colNo==12) sendInfo.setBaseGoodsAddress(cellBean.getCellData());
                        if(colNo==13) sendInfo.setMainLink(cellBean.getCellData());
                        if(colNo==14) sendInfo.setMainLinkWay(cellBean.getCellData());
                    }
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
}

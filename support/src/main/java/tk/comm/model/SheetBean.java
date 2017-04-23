package tk.comm.model;

import java.util.List;

/**
 * @author zhou
 * @Description:① APP应用异常
 * @date 2016/7/26 14:51
 */
public class SheetBean {
    private Integer sheetNo;//sheet序号

    private String sheetName;//sheet名称

    private List<CellBean> cellBeanList;//单元格数据

    public Integer getSheetNo() {
        return sheetNo;
    }

    public void setSheetNo(Integer sheetNo) {
        this.sheetNo = sheetNo;
    }

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public List<CellBean> getCellBeanList() {
        return cellBeanList;
    }

    public void setCellBeanList(List<CellBean> cellBeanList) {
        this.cellBeanList = cellBeanList;
    }
}

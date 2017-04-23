package tk.comm.model;

import java.io.Serializable;

/**
 * @author zhou
 * @Description:① APP应用异常
 * @date 2016/7/26 14:51
 */
public class CellBean implements Serializable {
    private Integer rowNo;//行号

    private Integer colNo;//列号

    private int cellType;//数据类型

    private String cellTypeName;

    private String cellData;//数据

    public String getCellTypeName() {
        return cellTypeName;
    }

    public void setCellTypeName(String cellTypeName) {
        this.cellTypeName = cellTypeName;
    }

    public Integer getRowNo() {
        return rowNo;
    }

    public void setRowNo(Integer rowNo) {
        this.rowNo = rowNo;
    }

    public Integer getColNo() {
        return colNo;
    }

    public void setColNo(Integer colNo) {
        this.colNo = colNo;
    }

    public int getCellType() {
        return cellType;
    }

    public void setCellType(int cellType) {
        this.cellType = cellType;
    }

    public String getCellData() {
        return cellData;
    }

    public void setCellData(String cellData) {
        this.cellData = cellData;
    }
}

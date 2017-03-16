package tk.common.test;

import org.junit.Assert;
import org.junit.Test;
import tk.comm.model.CellBean;
import tk.comm.model.SheetBean;
import tk.comm.utils.ExcelUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static tk.comm.utils.ExcelUtil.readExcel;

/**
 * Created by Already on 2017/3/16.
 */
public class ExcelTest {
    @Test
    public void writeExcelTest() {
        try{
            List<SheetBean> sheetBeans = new ArrayList<SheetBean>();
            SheetBean sheetBean = new SheetBean();
            sheetBean.setSheetNo(0);
            sheetBean.setSheetName("test1");
            List<CellBean> cellBeanList = new ArrayList<CellBean>() {
                {
                    for (int j = 0; j < 5; j++) {
                        for (int i = 0; i < 10; i++) {
                            CellBean cellBean = new CellBean();
                            cellBean.setCellType(1);
                            cellBean.setRowNo(j);
                            cellBean.setColNo(i);
                            cellBean.setCellData("data" + j + "" + i);
                            add(cellBean);
                        }
                    }

                }

            };
            sheetBean.setCellBeanList(cellBeanList);

            SheetBean sheetBean2 = new SheetBean();
            sheetBean2.setSheetNo(1);
            sheetBean2.setSheetName("test2");
            List<CellBean> cellBeanList2 = new ArrayList<CellBean>() {
                {
                    for (int j = 0; j < 2; j++) {
                        for (int i = 0; i < 5; i++) {
                            CellBean cellBean = new CellBean();
                            cellBean.setCellType(1);
                            cellBean.setRowNo(j);
                            cellBean.setColNo(i);
                            cellBean.setCellData("datax" + j + "-" + i);
                            add(cellBean);
                        }
                    }

                }

            };
            sheetBean2.setCellBeanList(cellBeanList2);
            sheetBeans.add(sheetBean2);
            sheetBeans.add(sheetBean);

            ExcelUtil.writeExcel("", "./write.xls", sheetBeans);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Test
    public void readExcelTest(){
        try {
            List<SheetBean> sheetBeans=readExcel("./write.xls");
            //sheetBeans=readExcel(new FileInputStream("./write.xls"));
            Assert.assertTrue(sheetBeans.size()==2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

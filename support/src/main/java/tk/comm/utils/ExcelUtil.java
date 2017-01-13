package tk.comm.utils;

import tk.comm.model.CellBean;
import tk.comm.model.SheetBean;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author zhou
 * @version V1.0
 * @Description:
 * @date 2016/7/27 9:04
 * @jdk v1.7
 * @tomcat v7.0
 */
public class ExcelUtil {
    private static Logger logger=Logger.getLogger(ExcelUtil.class);
    private static final String XLS="xls";
    private static final String XLSX="xlsx";

    public static void writeExcel(String templateFile,String saveFile,List<SheetBean> sheetBeans) throws IOException {
        createDirs(saveFile);
        OutputStream os=new FileOutputStream(saveFile);
        logger.info("读取excel模板文件："+templateFile);
        Workbook book;
        sortSheetBeans(sheetBeans);
        if(!StringUtils.isEmpty(templateFile)) {
            String templateSuffix=getSuffix(templateFile);
            InputStream is = new FileInputStream(templateFile);
            book = createWorkBook(is,templateSuffix);
            fillWorkBook(book,sheetBeans);
        }else {
            String suffix=getSuffix(saveFile);
            book=createNewWorkBook(sheetBeans,suffix);
        }
        book.write(os);
        logger.info("读取完毕,写出到文件:"+saveFile);
    }
    private static String getSuffix(String fileName){
        return fileName.substring(fileName.lastIndexOf(".")+1);
    }

    private static void createDirs(String saveFile) {
        String[] paths=saveFile.split("/");
    }

    private static void sortSheetBeans(List<SheetBean> sheetBeans) {
        Collections.sort(sheetBeans, new Comparator<SheetBean>() {
            public int compare(SheetBean o1, SheetBean o2) {
                return o1.getSheetNo()-o2.getSheetNo();
            }
        });
    }

    private static void fillWorkBook(Workbook book, List<SheetBean> sheetBeans) {
        int sheetNum=sheetBeans.size();
        logger.info("写入sheet数目："+sheetNum);
        for(int sheetIndex=0;sheetIndex<sheetNum;sheetIndex++){
            Sheet sheet=book.getSheetAt(sheetIndex);
            if(book==null) sheet=book.createSheet();
            fillRowCell(sheet,sheetBeans.get(sheetIndex));
        }
    }
    private static Workbook createWorkBook(InputStream is,String suffix) throws IOException {
        Workbook workbook;
        if(suffix.equals(XLS)){
            workbook=is==null?new HSSFWorkbook():new HSSFWorkbook(is);
        }else if(suffix.equals(XLSX)){
            workbook=is==null?new XSSFWorkbook():new XSSFWorkbook(is);
        }else {
            throw new RuntimeException("模板文件路径错误......");
        }
        return workbook;
    }

    private static Workbook createNewWorkBook(List<SheetBean> sheetBeans,String suffix) throws IOException {
        Workbook workbook=null;
        if(sheetBeans!=null && !sheetBeans.isEmpty()){
            workbook=createWorkBook(null,suffix);
            Sheet sheet;
            for(SheetBean sheetBean:sheetBeans){
                sheet=workbook.createSheet(sheetBean.getSheetName());
                fillRowCell(sheet,sheetBean);
            }
        }
        return workbook;
    }
    private static void fillRowCell(Sheet sheet,SheetBean sheetBean){
        Map<Integer,List<CellBean>> cellBeanMap=toMap(sheetBean.getCellBeanList());
        logger.info("sheet"+sheet.getSheetName()+"写入行数："+cellBeanMap.size());
        int colNo;
        for(int rowNo:cellBeanMap.keySet()){
            Row row = sheet.getRow(rowNo);
            if(row==null) row=sheet.createRow(rowNo);
            List<CellBean> list=cellBeanMap.get(rowNo);
            if(list!=null && !list.isEmpty()) {
                for(CellBean cellBean:list) {
                    colNo=cellBean.getColNo();
                    Cell cell = row.getCell(colNo);
                    if(cell==null) cell=row.createCell(colNo);
                    cell.setCellType(cellBean.getCellType());
                    cell.setCellValue(cellBean.getCellData());
                }
            }
        }
    }

    private static Map<Integer, List<CellBean>> toMap(List<CellBean> cellBeanList) {
        Map<Integer, List<CellBean>> map=new HashMap<Integer, List<CellBean>>();
        for(final CellBean cellBean:cellBeanList){
            int rowNo=cellBean.getRowNo();
            if(map.get(rowNo)==null){
                map.put(rowNo,new ArrayList<CellBean>(){{
                    add(cellBean);
                }});
            }else{
                map.get(rowNo).add(cellBean);
            }
        }
        return map;
    }


    public static List<SheetBean> readExcel(String fileName) throws IOException {
        logger.info("读取excel文件:"+fileName);
        String suffix=getSuffix(fileName);
        InputStream is = new FileInputStream(fileName);
        return readExcel(is,suffix);
    }
    public static List<SheetBean> readExcel(InputStream is) throws IOException {
        return readExcel(is,XLSX);
    }
    public static List<SheetBean> readExcel(InputStream is,String suffix) throws IOException {
        Workbook  book = createWorkBook(is,suffix);
        List<SheetBean> sheetBeanList = new ArrayList<SheetBean>();
        int sheetsNumber = book.getNumberOfSheets();
        for (int sheetIndex = 0; sheetIndex < sheetsNumber; sheetIndex++) {
            sheetBeanList.add(parseSheetBean(book, sheetIndex));
        }
        return sheetBeanList;
    }


    private static SheetBean parseSheetBean(Workbook  book, int sheetIndex) {
        Sheet sheet = book.getSheetAt(sheetIndex);
        SheetBean sheetBean = new SheetBean();
        sheetBean.setSheetName(sheet.getSheetName());
        sheetBean.setSheetNo(sheetIndex);
        sheetBean.setCellBeanList(parseCellBeans(sheet));
        return sheetBean;
    }

    private static List<CellBean> parseCellBeans(Sheet sheet) {
        int firstRowNum = sheet.getFirstRowNum();
        int lastRowNum = sheet.getLastRowNum();
        List<CellBean> cellBeanList = new ArrayList<CellBean>();
        CellBean cellBean;
        for (int rowNum = firstRowNum; rowNum <= lastRowNum; rowNum++) {
            Row row = sheet.getRow(rowNum);
            if(row!=null){
                int firstCellNum = row.getFirstCellNum();
                int lastCellNum = row.getLastCellNum();
                for (int cellNum = firstCellNum; cellNum < lastCellNum; cellNum++) {
                    Cell cell = row.getCell(cellNum);
                    if (cell != null) {
                        cellBean = new CellBean();
                        cellBean.setRowNo(rowNum);
                        cellBean.setColNo(cellNum);
                        int cellType = cell.getCellType();
                        cellBean.setCellType(cellType);
                        cellBean.setCellTypeName(getCellTypeName(cellType));
                        cellBean.setCellData(getCellValue(cell, cellType));
                        cellBeanList.add(cellBean);
                    }
                }
            }
        }
        return cellBeanList;
    }

    private static String getCellTypeName(int cellTypeCode) {
        switch (cellTypeCode) {
            case 3:
                return "blank";
            case 1:
                return "text";
            case 4:
                return "boolean";
            case 0:
                return "numeric";
            case 2:
                return "formula";
        }
        return "#unknown cell type (" + cellTypeCode + ")#";
    }

    private static String getCellValue(Cell cell, int cellType) {
        String result = "";

        switch (cellType) {
            case 1:
                result = cell.getStringCellValue();
                break;
            case 4:
                result = (new Boolean(cell.getBooleanCellValue())).toString();
                break;
            case 0: {
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    result = getDateResult(cell);
                } else {
                    result = (new Double(cell.getNumericCellValue())).toString();
                }
                break;
            }
            case 2: {
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    result = getDateResult(cell);
                } else {
                    result = String.valueOf(cell.getNumericCellValue());
                }
                break;
            }
            case 3:
                result = "";
                break;
        }
        return result;
    }
    private static String getDateResult(Cell cell){
        Date date = cell.getDateCellValue();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }


    public static void main(String[] args) {
        try {
            readExcel(new FileInputStream("C:\\Users\\dell\\Desktop\\sh\\1-客户信息维护.xlsx"),"xlsx");
//            List<SheetBean> sheetBeans=new ArrayList<SheetBean>();
//            SheetBean sheetBean=new SheetBean();
//            sheetBean.setSheetNo(0);
//            sheetBean.setSheetName("test1");
//            List<CellBean> cellBeanList=new ArrayList<CellBean>(){
//                {
//                    for(int j=1;j<5;j++){
//                        for(int i=0;i<10;i++){
//                            CellBean cellBean=new CellBean();
//                            cellBean.setCellType(1);
//                            cellBean.setRowNo(j);
//                            cellBean.setColNo(i);
//                            cellBean.setCellData("data"+j+""+i);
//                            add(cellBean);
//                        }
//                    }
//
//                }
//
//            };
//            sheetBean.setCellBeanList(cellBeanList);
//
//            SheetBean sheetBean2=new SheetBean();
//            sheetBean2.setSheetNo(1);
//            sheetBean2.setSheetName("test2");
//            List<CellBean> cellBeanList2=new ArrayList<CellBean>(){
//                {
//                    for(int j=0;j<2;j++){
//                        for(int i=0;i<5;i++){
//                            CellBean cellBean=new CellBean();
//                            cellBean.setCellType(1);
//                            cellBean.setRowNo(j);
//                            cellBean.setColNo(i);
//                            cellBean.setCellData("datax"+j+"-"+i);
//                            add(cellBean);
//                        }
//                    }
//
//                }
//
//            };
//            sheetBean2.setCellBeanList(cellBeanList2);
//            sheetBeans.add(sheetBean2);
//            sheetBeans.add(sheetBean);
//
//            writeExcel("D:/test.xlsx","D:/write.xls",sheetBeans);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

package tk.comm.utils;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhou
 * @version V1.0
 * @Description:
 * @date 2016/7/28 9:24
 * @jdk v1.7
 * @tomcat v7.0
 */
public class CsvUtil {

    public static List<String[]> readCsv(String fileName) throws IOException {
        CSVReader csvReader = new CSVReader(new FileReader(fileName));
        List<String[]> list = csvReader.readAll();
        csvReader.close();
        return list;
    }

    public static void writeCsv(String fileName,List<String[]> data) throws IOException {
        CSVWriter csvWriter = new CSVWriter(new FileWriter(fileName), ',');
        for(String[] ss:data){
            csvWriter.writeNext(ss);
        }
        csvWriter.close();
    }

    public static void main(String[] args){
        try {
//            readCsv("d:\\test.csv");
            List<String[]> data=new ArrayList<String[]>();
            data.add(new String[]{"a","b","c"});
            data.add(new String[]{"1","2","3"});
            writeCsv("d:\\1.csv",data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package tk.comm.utils;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import org.apache.log4j.Logger;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhou
 * @Description:① APP应用异常
 * @date 2016/7/26 14:51
 */
public class CsvUtil {
    private static Logger logger=Logger.getLogger(CsvUtil.class);
    public static List<String[]> readCsv(String fileName) throws IOException {
        CSVReader csvReader = new CSVReader(new FileReader(fileName));
        List<String[]> list = csvReader.readAll();
        csvReader.close();
        return list;
    }

    public static void writeCsv(String fileName, List<String[]> data) throws IOException {
        CSVWriter csvWriter = new CSVWriter(new FileWriter(fileName), ',');
        for (String[] ss : data) {
            csvWriter.writeNext(ss);
        }
        csvWriter.close();
    }

    public static void main(String[] args) {
        try {
//            readCsv("d:\\test.csv");
            List<String[]> data = new ArrayList<String[]>();
            data.add(new String[]{"a", "b", "c"});
            data.add(new String[]{"1", "2", "3"});
            writeCsv("d:\\1.csv", data);
        } catch (IOException e) {
            logger.error(e);
        }
    }
}

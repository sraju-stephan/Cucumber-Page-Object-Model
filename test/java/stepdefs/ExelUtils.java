package stepdefs;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

/**
 * Created by cguggilam on 7/9/2017.
 */
public class ExelUtils {
static XSSFWorkbook wb;
    static XSSFSheet sheet;


    public static void setexcel(String path,int sheetnum) throws Exception {
        File src=new File(path);
        FileInputStream fis=new FileInputStream(src);
        wb=new XSSFWorkbook(fis);
        sheet=wb.getSheetAt(sheetnum);

    }

    public static String getdata(int rownum,int cellnum){
        String data=sheet.getRow(rownum).getCell(cellnum).getStringCellValue();
        return data;
    }
}

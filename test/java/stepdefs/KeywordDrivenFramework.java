package stepdefs;

/**
 * Created by cguggilam on 6/5/2017.
 */
public class KeywordDrivenFramework {
public static void main(String[] args) throws Exception {
    String path="E:\\java_automation\\Frameworks\\CucumberProject\\src\\test\\data\\infoexcel.xlsx";
//    File f=new File("E:\\java_automation\\Frameworks\\CucumberProject\\src\\test\\data\\datafile.properties");
//    FileInputStream fs=new FileInputStream(f);
//    Properties pr=new Properties();
//    pr.load(fs);
//
//    File fex=new File("E:\\java_automation\\Frameworks\\CucumberProject\\src\\test\\data\\infoexcel.xlsx");
//    FileInputStream fiex=new FileInputStream(fex);
//    Workbook wb=null;
//    wb=new XSSFWorkbook(fiex);
//    Sheet sh=wb.getSheet("one");
//
//
//    int rowCount = sh.getLastRowNum()-sh.getFirstRowNum();
//    for (int i=1;i<rowCount+1;i++){
//        Row row=sh.getRow(i);
//    }

    ExelUtils.setexcel(path,1);
    for(int i=1; i<=3;i++){
    String keyword=ExelUtils.getdata(i,2);
     if(keyword.equals("openbrowser")){
         ActionKeywords.openbrowser();
      }

      else if (keyword.equals("navigate")){
         ActionKeywords.navigate();
     }
        else if (keyword.equals("click_DF")){
         ActionKeywords.click_df();
     }
    else {
         System.out.println("keyword not found");
     }
    }
}
}

package stepdefs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * Created by cguggilam on 6/1/2017.
 */
public class properties_practice {

    public static void main(String[] args) throws IOException {
        File f=new File("E:\\java_automation\\Frameworks\\CucumberProject\\src\\test\\data\\datafile.properties");
        FileInputStream fis=new FileInputStream(f);
//System.out.println("using FileInputStream");
//        while(fis.read()!=-1){
//            System.out.print(fis.read());
//        }

//        FileReader fr=new FileReader(f);
//        System.out.println("using File Reader");
//        while(fr.read()!=-1){
//            System.out.print((char)fr.read());
//        }


        Properties p=new Properties();
        p.load(fis);

        DesiredCapabilities d=DesiredCapabilities.chrome();
        d.setCapability(CapabilityType.BROWSER_NAME,"chrome");
        d.setBrowserName("chrome");
        System.setProperty("webdriver.chrome.driver","F:\\chromedriver\\chromedriver_latest\\chromedriver.exe");
        WebDriver wd=new ChromeDriver(d);

        wd.get(p.getProperty("url"));

        WebElement sbut=wd.findElement(By.id("globalSearchInputField"));
        sbut.sendKeys(p.getProperty("searchbox"));
        sbut.submit();
        //Get data from properties file in form of key value pairs
        Enumeration allkeys=p.keys();
        HashMap hm=new HashMap();
        while (allkeys.hasMoreElements()){
            String key= (String) allkeys.nextElement();
            String value=p.getProperty(key);
            hm.put(key,value);
        }
        System.out.println("Key and values in properties file="+hm);

        Set<Map.Entry<Object, Object>> s=p.entrySet();

        for(Map.Entry<Object, Object> skey : s){
            String key= (String) skey.getKey();
            String value= (String) p.get(key);
            System.out.println("key="+key+"value="+value);
        }



    }


}

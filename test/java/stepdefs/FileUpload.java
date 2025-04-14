package stepdefs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

/**
 * Created by cguggilam on 7/8/2017.
 */
public class FileUpload {

    public static void main(String[] args) throws IOException, Exception {
        System.setProperty("webdriver.chrome.driver", "F:/chromedriver/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("http://toolsqa.com/automation-practice-form/");
        driver.findElement(By.id("photo")).click();

        Runtime.getRuntime().exec("E:/AutoITFiles/FileUpload.exe");
    }

}

package stepdefs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by cguggilam on 7/9/2017.
 */
public class ActionKeywords {

    static WebDriver driver;




    public  static  void openbrowser(){
        System.setProperty("webdriver.chrome.driver", "F:\\chromedriver\\chromedriver_latest\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    public static void navigate(){
        driver.navigate().to("http://www.seleniumframework.com/");
    }
    public static void click_df(){
        WebElement e=driver.findElement(By.id("ui-id-1"));
        WebDriverWait wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOf(e));
        e.click();
    }


}

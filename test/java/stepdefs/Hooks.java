package stepdefs;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
//import org.apache.commons.io.FileUtils;

/**
 * Created by cguggilam on 4/19/2017.
 */
public class Hooks {

    public static ExtentReports report;
    public static ExtentTest logger;

    public String scenarioname;

    public static WebDriver driver;
//    public Date currDate = new Date();
//    public SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
//    public String dateAndTime = dateFormat.format(currDate);
    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
    @Before
    public void openBrowser(Scenario s){
        System.out.println("Called openBrowser");

        Map<String,String> env_details = iGetEnvironmentVariables();
        String url_val=  env_details.get("url");//String value=val==(null) ? null : val;
        String browser_name= (String) env_details.get("browser");
        scenarioname=s.getName();
        report=new ExtentReports("E:\\java_automation\\Frameworks\\CucumberProject\\src\\output\\report.html",false);
        //  report.addSystemInfo("Platform","Win7");
        logger=report.startTest(scenarioname);
        if(browser_name.equalsIgnoreCase("chrome")){
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");
            System.setProperty("webdriver.chrome.driver", "F:\\chromedriver\\chromedriver_latest\\chromedriver.exe");
            driver = new ChromeDriver(capabilities);
            logger.log(LogStatus.INFO, "Browser started ");
        }

        if(url_val!=null || !url_val.isEmpty()){
            driver.get(url_val);
        }
        driver.manage().window().maximize();
    }

    @After
    public void scenarioexecuted(Scenario s) throws Exception {
        File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String dest="E:\\java_automation\\Frameworks\\CucumberProject\\src\\output\\"+timeStamp+".png";
        File reportFile = new File(dest);
        FileUtils.copyFile(src, reportFile);
        String image= logger.addScreenCapture(dest);
        if (s.isFailed()){
        logger.log(LogStatus.FAIL, scenarioname, image);}
        logger.log(LogStatus.PASS,scenarioname,image);
        System.out.println("scenario passed successfully");
      //  RunCukesTest.setup();
        report.endTest(logger);
        report.flush();

        driver.quit();
    }

    public Map<String,String> iGetEnvironmentVariables()  {

        Map<String, String> envvars=System.getenv();
        HashMap hm=new HashMap();
        for(String envname : envvars.keySet()){
            System.out.format("%s=%s%n",envname, envvars.get(envname));
            hm.put(envname,envvars.get(envname));
        }
        return hm;
    }
}

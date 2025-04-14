package stepdefs;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
/**
 * Created by cguggilam on 4/19/2017.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/features/",
        glue = "stepdefs",
       // format = {"pretty", "html:target/Destination"},
//        plugin = {"pretty", "com.cucumber.listener.ExtentCucumberFormatter:output/report.html","html:src/output","json:target/cucumber-reports.json",
//                "junit:target/cucumber-reports/cucumber.xml"},
        plugin = {"pretty", "html:src/output","json:target/cucumber-reports.json",
                "junit:target/cucumber-reports/cucumber.xml"},
        monochrome = true,
        tags = {}
)




public class RunCukesTest {
    //@AfterClass
//    public static void setup() {
//        ExtentHtmlReporter  htmlReporter = new ExtentHtmlReporter("src/output/extentreport.html");
//        htmlReporter.config().setChartVisibilityOnOpen(true);
//        htmlReporter.config().setDocumentTitle("QAV automation report");
//    }
}

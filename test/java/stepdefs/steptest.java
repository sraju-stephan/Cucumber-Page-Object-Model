package stepdefs;

import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import genericMethods.GenericMethods;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static stepdefs.Hooks.logger;

//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;

//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.ParseException;

//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//import java.io.FileReader;
//import java.io.IOException;


/**
 * Created by cguggilam on 4/19/2017.
 */
public class steptest extends GenericMethods {



    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public static String file_path_url="E:\\java_automation\\Frameworks\\CucumberProject\\src\\test";

    public WebDriver driver;

    public steptest() {
            driver = Hooks.driver;
        }

        @Given("^I open seleniumframework website$")
        public void i_Open_Seleniumframework_Website ()throws Throwable {
            // Write code here that turns the phrase above into concrete actions
            System.out.print("entered into method");
            logger.log(LogStatus.INFO, "Navigating to selenium framework site");
            driver.get("http://www.seleniumframework.com/");
            logger.log(LogStatus.PASS, "Succesfully navigated to site");
            List<WebElement> l=driver.findElements(By.tagName("a"));
            for (WebElement g: l) {
                System.out.print(g.getText()+"  ");
            }

        }

        @Then("^I validate title and URL$")
        public void i_Validate_Title_And_URL ()throws Throwable {
            // Write code here that turns the phrase above into concrete actions
            System.out.print("entered into second method");
            logger.log(LogStatus.INFO, "Verifying title");
            assertEquals("Selenium Framework | Senium, Cucumber, Ruby, Java et al.", driver.getTitle());
            assertEquals("http://www.seleniumframework.com/", driver.getCurrentUrl());
            logger.log(LogStatus.PASS, "Title verified");

        }

    @Given("^I navigated to json resource file$")
    public void iNavigatedToJsonResourceFile()  {
        // Write code here that turns the phrase above into concrete actions
           JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("E:\\java_automation\\Frameworks\\CucumberProject\\src\\test\\data\\first.json"));
            JSONObject jsonObject = (JSONObject) obj;
          //  JSONObject JOBJ=(JSONObject) parser.parse(new FileReader("E:\\java_automation\\Frameworks\\CucumberProject\\src\\test\\data\\first.json"));
            System.out.println(jsonObject);
            logger.log(LogStatus.INFO, "Retrieved json object");
            String fname = (String) jsonObject.get("firstName");
            System.out.println(fname);

            String lastName = (String) jsonObject.get("lastName");
            System.out.println(lastName);

            JSONArray js= (JSONArray) jsonObject.get("phoneNumber");
            System.out.println(js.get(0));

            JSONArray ja=(JSONArray) jsonObject.get("phoneNumber");
            for(int i=0;i<ja.size();i++){
                JSONObject jo=(JSONObject) ja.get(i);
                jo.get("type");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        logger.log(LogStatus.PASS, "JSON data passed succesfully");
    }

    @Given("^I have below data tables$")
    public void i_Have_Below_Data_Tables(DataTable table) {
        logger.log(LogStatus.INFO, "Getting data");
        List<List<String>> data=table.raw();
        data.get(0).get(0); // username
        data.get(0).get(1).contains("pass"); //true
        data.get(1).get(1); ///one
        logger.log(LogStatus.INFO, "Printed data table data");
        //mapone=new HashMap<String, String>();
//        System.out.println(mapone);
//        System.out.println(mapone.get("one"));
//        System.out.println(mapone.keySet());
//        System.out.println(mapone.values());
//        System.out.println(mapone.entrySet());


    }

    @Then("^I have below data tables for map$")
    public void i_Have_Below_Data_Tables_For_Map(List<HashMap<String,String>> listmap) {
        logger.log(LogStatus.INFO, "Printing List of HashMap details");
        for (Map<String, String> entry : listmap) {
            for (String key : entry.keySet()) {
                String value = entry.get(key);
                System.out.println("key = " + key);
                System.out.println("value = " + value);
            }
        }
        logger.log(LogStatus.INFO, "Printed List of HashMap data succesfully");
    }

    @Then("^I have below data list for map$")
    public void i_Have_Below_Data_List_For_Map(DataTable arg) {
       // listts.get(0);
        System.out.println(arg);
    }

    @Then("^I performing element action on UI page$")
    public void iPerformingElementActionOnUIPage() throws Throwable {
       // Object fobj = onPage("home_page");
        JSONParser parser = new JSONParser();
        JSONObject obj1 = (JSONObject) parser.parse(new FileReader(file_path_url+"\\elements\\home_page.json"));
      // JSONObject jo= (JSONObject) fobj;
        String ele= (String)  obj1.get("chooselink");

        driver.findElement(By.id(getvalue("chooselink")));

        String locvalue=getlocatorinfo((JSONObject)onPage("home_page"),"chooselink");
        WebElement e=driver.findElement(By.id(locvalue));
        WebDriverWait wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOf(e));
        e.click();

        JavascriptExecutor je=(JavascriptExecutor)driver;

        je.executeScript("arguments[0].scrollIntoView();",e);//scrolled to particular web element(e)


        je.executeScript("window.scrollTo(0,document.body.scrollHeight)");//scroll to the Bottom of the Web Page
        je.executeScript("window.scrollTo(document.body.scrollHeight,0)");//scroll to top of page (or)scroll up in a vertical direction
        je.executeScript("window.scrollBy(2000,0)");//scroll horizontally in the right direction,
        je.executeScript("window.scrollBy(-2000,0)");//scroll horizontally in the left direction,
        je.executeScript("window.scrollBy(200,300)");//scroll at a particular coordinate

        je.executeScript("document.getElementById('lst-ib').value = \"yash\";");//enter value yash
        je.executeScript("document.getElementById('lst-ib').value='value here'");//value here entered

//        je.executeScript("window.location = 'http://www.seleniumframework.com/'");
        WebElement e1=driver.findElement(By.id("ui-id-1"));
        je.executeScript("arguments[0].click();",e1);//to click an web element
        je.executeScript("return document.documentElement.innerText");//to get text of a web page

        je.executeScript("window.history.go(-1)");//navigates to previous using browser back button
        je.executeScript("window.history.forward(-1)");//navigates to pages using browser forward button
        je.executeScript("window.location = 'http://www.google.com'");//navigated to url
        je.executeScript("window.location = '/search");//it will appends to url and redirect to that page
        je.executeScript("return document.domain");//return facebook.com//window url: https://www.facebook.com/
        je.executeScript("return document.URL");//https://www.facebook.com/ //window url: https://www.facebook.com/
        je.executeScript("return document.title");//return Facebook – log in or sign up
        Actions as=new Actions(driver);
        as.sendKeys(Keys.PAGE_DOWN);

        logger.log(LogStatus.INFO, "element is"+locvalue+"clicked");
        Thread.sleep(2000);
    }


    public String getvalue(String key) throws Exception {
        JSONParser parser = new JSONParser();
        JSONObject obj1 = (JSONObject) parser.parse(new FileReader(file_path_url+"\\elements\\home_page.json"));
        String value=obj1.get(key).toString().split(";")[1];
        return value;
    }


    @And("^I get credit cards from$")
    public void iGetCreditCardsFrom() throws IOException, ParseException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("http://jcia6340:8080/api/customer/v1/users/usercard/getusercreditcards/2158945632");
        HttpResponse response = client.execute(request);
        //ContentType.getOrDefault(httpResponse.getEntity()).getMimeType();
        int responseCode = response.getStatusLine().getStatusCode();
        logger.log(LogStatus.INFO, "Sent Get Request and response code="+responseCode);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        StringBuilder result = new StringBuilder();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(String.valueOf(result));
        JSONObject jo = (JSONObject) json.get("userprofile");
        JSONArray js = (JSONArray) (jo.get("creditcards"));

        JSONObject jh;
        HashMap<Integer, JSONObject> hm = new HashMap<Integer, JSONObject>();
        for (int i = 0; i < js.size(); i++) {
            jh = (JSONObject) js.get(i);
            hm.put(i, jh);
        }
        logger.log(LogStatus.INFO, "Credit details of a user="+hm);
        String Master = "Master";
        JSONObject cc=getCreditCards(hm,Master);
        logger.log(LogStatus.INFO, Master+"card details are"+cc);
        System.out.println(cc);
        //System.out.println("hm=" + hm.get(0) + '\n' + hm.get(1));
        // System.out.println("jh="+hm.entrySet());
//        int j ;
//        for (j = 0; j < hm.size(); j++) {
//            if (hm.get(j).toString().contains("Master")) {
//                hm.get(j);
//            }
//        }
        logger.log(LogStatus.PASS, "Passed GET request");
    }

    public JSONObject getCreditCards(HashMap<Integer, JSONObject> hm, String master){
        JSONObject oi = null;
        logger.log(LogStatus.INFO, "retrieving user wallet credit cards");
        for (int j = 0; j < hm.size(); j++) {
            if (hm.get(j).toString().contains(master)) {
                oi = hm.get(j);
            }
        }
        return oi;//return master card details
    }


    @Then("^I verify xapi response$")
    public void iVerifyXapiResponse() throws Throwable {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("http://11.168.56.123:8080/xapi/preferences/v1/notifications");
        request.addHeader("X-Macys-Userguid","780ee418-5801-435c-abd4-89926de6a105");
        request.addHeader("X-Macys-SecurityToken","13_DAP4m9R7+qD5v6G0HrdGybesNb02ziPdIOeuIkxTK6W2QeHG9wrO7JE5wrsFuTve0vL8edZ27ZurWHGA9knSdg==");
        request.addHeader("X-Macys-SignedIn","1");
        HttpResponse response = client.execute(request);
        logger.log(LogStatus.INFO, "Sent Get Request with XPI service and response ="+response);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        StringBuilder result = new StringBuilder();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        JSONParser jo=new JSONParser();
        JSONObject js = (JSONObject) jo.parse(String.valueOf(result));
        js.get("notifications");
        logger.log(LogStatus.INFO, "Response details from JSON response"+js);
    }


    @Then("^I verify xapi post response$")
    public void iVerifyXapiPostResponse() throws IOException {
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost postRequest = new HttpPost("http://jcia6905:8080/api/order/v1/bags?userId=2158819800");
        postRequest.addHeader("content-type","application/xml");
        StringEntity input = new StringEntity("<item> <quantity>1</quantity> <upcId>52582</upcId> </item>");
        postRequest.setEntity(input);
        HttpResponse response = httpClient.execute(postRequest);
        logger.log(LogStatus.INFO, "Sent Post Request and response="+response);
        BufferedReader br=new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line="";
        StringBuilder result= new StringBuilder();

        while((line=br.readLine())!=null){
            result.append(line);
        }
        System.out.println(result);
        logger.log(LogStatus.PASS, "Passed POST request and response="+result);
    }


    @Then("^I add reward to wallet$")
    public void iAddRewardToWallet() throws IOException {
        String card="737194000007354";
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost postRequest = new HttpPost("http://jcia6630:8080/api/customer/v1/customers/2158821030/wallet/rewardcards");
        postRequest.addHeader("content-type","application/xml");
        // postRequest.addHeader("Accept","application/xml");
        postRequest.addHeader("X-Macys-SecurityToken","13_4nKZkDuxlAgXin6r3WOFV5CeZP4QFmnGVCq5ld6U0b8srhXgtFQVtFWp8JEpHD+b5rUOGVtHEZSZ47S46dUz+w==");
//        StringEntity input = new StringEntity("<rewardcards>\n" +
//                "<rewardcard>\n" +
//                "      <cardNumber>"+card+"</cardNumber>\n" +
//                "      <cid>3195</cid>\n" +
//                "</rewardcard>\n" +
//                "</rewardcards>");
        StringEntity input=new StringEntity("<rewardcards><rewardcard><cardNumber>737194000007354</cardNumber><cid>3195</cid></rewardcard></rewardcards>");
        postRequest.setEntity(input);
        logger.log(LogStatus.INFO, "Request parameters sent="+postRequest);
        HttpResponse response = httpClient.execute(postRequest);
        response.getStatusLine().getStatusCode();
        BufferedReader br=new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line="";
        StringBuilder result= new StringBuilder();

        while((line=br.readLine())!=null){
            result.append(line);
        }
        logger.log(LogStatus.INFO, "Post Response="+result);
        JSONObject obj = (JSONObject) JSONValue.parse(result.toString());
        JSONObject jj=(JSONObject) obj.get("errors");
        JSONArray ja= (JSONArray)jj.get("error");
        JSONObject jjj=(JSONObject) ja.get(0);
        System.out.println(jjj.get("errorCode"));
    }





}


package genericMethods;


//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static stepdefs.steptest.file_path_url;

/**
 * Created by cguggilam on 4/24/2017.
 */
public class GenericMethods {

    public String getlocatorinfo(JSONObject page, String ele){
        String el= (String) ((JSONObject) page).get(ele);
        String locatorvalue=el.split(";")[1];
        return locatorvalue;
    }

    public Object onPage(String page) throws FileNotFoundException {
        JSONParser parser = new JSONParser();
        System.out.print("printting");
        Object obj1 = null;
        try {
            obj1 = parser.parse(new FileReader(file_path_url+"\\elements\\"+page+".json"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return obj1;
    }
}

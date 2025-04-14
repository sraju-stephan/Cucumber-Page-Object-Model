package stepdefs;

import java.io.*;

/**
 * Created by cguggilam on 6/1/2017.
 */
public class ReadingWrintgFilePractice {
    public static void main(String[] args) throws IOException {

        File ff=new File("E:\\java_automation\\Frameworks\\CucumberProject\\src\\test\\data\\information.txt");

        System.out.println("using FileInputStream class");
        FileInputStream fis=new FileInputStream(ff);
        int j;
        while ((j=fis.read())!=-1){
            System.out.print((char)j);
        }System.out.println("------------------");

        System.out.println("using FileReader class");
        FileReader fr=new FileReader(ff);
        int i;
        while ((i=fr.read())!=-1){
            System.out.print((char)i);
        }System.out.println("------------------");

        System.out.println("using Buffered Reader class");
        BufferedReader br=new BufferedReader(new FileReader(ff));
        String content="";
        String[] keys=new String[100];
        while ((content=br.readLine())!=null){
            System.out.println(content);
             keys= content.split("=");
            String key= keys[0];
            System.out.println("key="+key);
            String value= keys[1];
            System.out.println("value="+value);

        }System.out.println("------------------");

}
}

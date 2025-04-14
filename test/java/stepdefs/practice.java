package stepdefs;

//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;

import java.util.*;
import java.util.stream.Stream;

public class practice {

    public static void main(String[] args) {

        int a[]={1,2,3,4,2,3};
        int b[]={3,2,1,5,7};
        ArrayList l=new ArrayList();
        for(int i=0;i<a.length;i++){
            for(int j=0;j<b.length;j++){
                if(a[i]==b[j])
                    l.add(a[i]);
                    //System.out.println("common elements"+a[i]);
            }
        }
        System.out.println("common elements"+l);
        System.out.println("removed duplicate elements in 2 arrays");
        Set set = new HashSet(l);
        for(Object h : set){
            System.out.print(h+"  "+"\n");
        }System.out.println("---------------------------------------------");

        String s="chandradrch";

        char[] chr=s.toCharArray();
        ArrayList ll=new ArrayList();
        for(char c : chr){
            if(!ll.contains(c)){
                ll.add(c);
            }
        }
        System.out.println("removed duplicates in string"+ll.toString());
        Set ss=new HashSet(ll);


        String[] rev= {"c","h","a","n","d","r","a"};
        String r="";
        String[] fin=new String[rev.length];
        int count =0;
        for(int i=rev.length-1;i>=0;i--){
          //  r=r+"  "+rev[i];
           fin[count] = rev[i];
//            if(count == rev.length){
//                break;}
//            else {count++;
//            }
            count++;
        }
        System.out.println("revered array string:== ");
        for(String d: fin){
            System.out.print(d);
        }
        System.out.println("---------------------------------------------");
        //System.out.println("reverse string= "+ r);
        //System.out.println("reverse string fin= "+ fin[1]);
        Stream.of(rev)
                .sorted(Collections.reverseOrder())
                .forEach(System.out::print);

        int[] h={5,2,7,2,4,7,8,2,3};

      //  boolean isDistinct = false;
//        for (int i=0;i<h.length-1;i++){
//            boolean isDistinct = false;
//            for(int j=1;j<h.length-1;j++){
//                if(h[i]==h[j]){
//                    isDistinct = true;
//                    break;
//                   // System.out.print(h[i]);
//                }
//                if(!isDistinct){
//                    System.out.print("====="+h[i]+" ");
//                }
//            }
//
//        }

//        JSONParser parser = new JSONParser();
//
//        try {
//
//            Object obj = parser.parse(new FileReader("E:\\java_automation\\Frameworks\\CucumberProject\\src\\test\\data\\first.json"));
//            JSONObject jsonObject = (JSONObject) obj;
//            System.out.println(jsonObject);
//
//            String name = (String) jsonObject.get("name");
//            System.out.println(name);
//
//            long age = (Long) jsonObject.get("age");
//            System.out.println(age);
//
//            // loop array
//            JSONArray msg = (JSONArray) jsonObject.get("phoneNumber");
//            System.out.println(msg.get(0));
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

//        Map<String,String> hmap=new HashMap<>();
//        hmap.put("one","onee");
//        hmap.put("two","twoo");
//        hmap.put("three","threee");
//        hmap.put("four","fourr");
//        hmap.put("five","fivee");
//        hmap.put("six","six");
//
//
//      //  System.out.println(hmap);
//      //  hmap.forEach((k,v) -> System.out.print(k));
//        hmap.forEach((k,v) -> k.equalsIgnoreCase("four"));
//        String l=hmap.entrySet().stream()
//                .filter(m -> "four".equals(m.getKey())).map(m->m.getValue())
//                .collect(Collectors.joining());
//        System.out.println(l+"  "+l.getClass()); //four  class java.lang.String
//
//        List l1=hmap.entrySet().stream()
//                .filter(m -> m.getKey() .equals(m.getValue())).collect(Collectors.toList());
//        System.out.println(l1+"  "+l1.getClass()); //output : [six=six]  class java.util.ArrayList
//
//        Map<String,String> col=hmap.entrySet().stream()
//                .filter(m-> m.getKey()=="three")
//                .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
//        System.out.println(col+"  "+col.getClass()); //output: {three=threee}  class java.util.HashMap



        System.out.println("\nprime numbers");
int n=10;
    for(int i=2;i<n;i++){
        if(n%2==0){
            System.out.println(n+"not prime");break;
        }else {System.out.println(n+"prime");}
    }
        System.out.println("printing numbers without using loops");
        printnumbers(5);


        int g[]={10,2,3,4,5,5,4};

        int smallest= g[0],largest=g[0];
                for(int i=0;i<=g.length-1;i++){
                    if(smallest>g[i]){//3>2 3>4 3>1 10>
                        smallest=g[i];//1
                    }else if(largest<g[i]){//3<2 3<4 4<10
                        largest=g[i];// 4 10
                    }
                }
        System.out.println("\nsmallest="+smallest);
        System.out.println("largest="+largest);


//        1          4
//        1 2        3
//        1 2 3       2
//        1 2 3 4      1
        System.out.println("----------------");
        for(int i=1;i<=4;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j+" ");
            }
            System.out.print("\n");
        }
        System.out.println("----------------");

//        4 3 2 1
//        4 3 2
//        4 3
//        4
        for(int i=1;i<=4;i++){
            for(int j=4;j>=i;j--){
                System.out.print(j+" ");
            }
            System.out.print("\n");
        }

        //1 2 3 4   4       1...4
        //1 2 3      3      1..3
        //1 2        2      1.2
        //1         1       1
        System.out.println("----------------");
        for(int i=4;i>=1;i--){
            for(int j=1;j<=i;j++){
                System.out.print(j+" ");
            }
            System.out.print("\n");
        }
        System.out.println("----------------");
//        *
//       * *
//      * * *

        for(int i=1;i<=3;i++){
            for(int j=i;j<=4;j++){
                System.out.print(" ");
            }
            for(int k=1;k<=i;k++){
            System.out.print("* ");
            }
            System.out.println();
        }

//        1 1 1 1 *
//        1 1 1 * *
//        1 1 * * *
//        1 * * * *
        System.out.println("spaces with stars right");
int noofspaces=4,nofostars=1;
        for(int i=1;i<=4;i++){

            for(int k=1;k<=noofspaces;k++){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
            noofspaces--;
            //nofostars++;

        }

//        1
//        1 1
//        1 1 1
//        1 1 1 1
        System.out.println("print 1s to left");
        int noofones=1;
        for(int i=1;i<=4;i++){
            for(int j=1;j<=noofones;j++){
                System.out.print("1 ");
            }
            System.out.println();
            noofones++;
        }

//        ***1
//        **121
//        *11311
//        1114111
        System.out.println(" with columns difference");
int countspaces=3;
        for(int i=1;i<=4;i++){

            for(int k=1;k<=countspaces;k++){
                System.out.print(" ");
            }

            for(int j=1;j<=i;j++){
                //System.out.print(j);
                if(i<j){
                    System.out.print(i);
                }else{
                    System.out.print(i);
                }
            }
            System.out.println();
            countspaces--;

        }

        System.out.println("removing duplicate elements in array");
        int[] d={3,4,5,3,2,8,5};
        int c=0;
        Set w=new HashSet();
        for(int h1 : d){
            if(!w.contains(h1)){
                w.add(h1);
            }else {
                System.out.println("duplicate element="+h1);
                c++;
            }
        }  System.out.println(w);System.out.println("duplicate elements count="+c);


        int[] f={3,2,5,4,3,2,10,98,6};
        int r1=0;
        ArrayList al=new ArrayList();
        ArrayList dupal=new ArrayList();
        for(int q : f){
            if(!al.contains(q)){
                al.add(q);
            }else {
                dupal.add(q);
                r1++;
            }
        }System.out.println("duplicates are="+dupal+"\n"+"distrinct elements are"+al);

        TreeSet sd=new TreeSet();
        for(int j : f){
            if(!sd.contains(j)){
                sd.add(j);
            }
        }
        System.out.println("Sorted array by using Tree Set="+sd);
        Arrays.sort(f);
        for(int d2 : f){
            System.out.print(d2);
        }

        Integer [] arr = {30, 20, 40, 10};
        Arrays.sort(arr,Collections.reverseOrder());
        System.out.println("descending order=="+Arrays.toString(arr));

        int[] arrr = {2,4,3,7,9,8,4,3};int temp;
        for(int i=0;i<=arrr.length-1;i++){
            for(int j=i+1;j<arrr.length;j++){
                if(arrr[i]>arrr[j]){
                    temp=arrr[i];
                    arrr[i]=arrr[j];
                    arrr[j]=temp;
                }

            }
        }
        System.out.println("Ascending order sorting array using for loop=");
        for(int fe : arrr){
            System.out.print(fe+" ");
        }
        int[] br={4,3,6,34,2};

        for(int i=0;i<=br.length-1;i++){
            for(int j=i+1;j<br.length;j++){
                if(br[i]<br[j]){
                    temp=br[i];
                    br[i]=br[j];
                    br[j]=temp;
                }

            }
        }System.out.println("\n Descending order sorting array using for loop=");
        for(int fee : br){
            System.out.print(fee+" ");
        }

        System.out.println("------removing duplicate in array-------");
        int[] rar={3,2,1,4,5,4,7};
        ArrayList dupeles=new ArrayList();
        ArrayList disteles=new ArrayList();
        for(int i=0;i<=rar.length;i++){
            for(int j=i+1;j<=rar.length-1;j++){
                if(rar[i]==rar[j]){
                    dupeles.add(rar[i]);
                }else {
                    disteles.add(rar[i]);
                }
            }
        }
        System.out.println("duplicate elements="+dupeles);
        System.out.println("distinct elements="+disteles);
//        for(int y: dup){
//            System.out.print(y);
//        }
        System.out.println("------Armstrong-----");
        long n1=113,n2,reve=0,tempp=n1;
        while(n>0){
            n2=n1%10;//1//2
            reve=(reve*10)+n2;//1//1+2
            n1=n1/10;//12
        }
        if (tempp!=reve){System.out.println("not armstring");}
//        Assert.assertFalse("given number"+n1+" is armstrong",n1==reve);
//        System.exit(1);






    }

    private static void printnumbers(int t) {
      if(t<=10){
        System.out.print(t); //5
      //  t++;
        printnumbers(t+1);}
    }

}
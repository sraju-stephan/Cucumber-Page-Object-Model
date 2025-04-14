package stepdefs;

/**
 * Created by cguggilam on 6/7/2017.
 */

enum outsideenum{
    outside1,outside2;

    public int a;
    private int a1;
    protected int a2;
    static  int g;
}

interface x{

}
interface z{

}
enum y implements x,z{

}

public class enum_practice {

    enum data{
        macys,bloomingdales,flipkart,amazon;
        public int a;
        private int a1;
        protected int a2;
        static  int g;
        public void demone(){}
    }

    public  static void main(String[] args){
        outsideenum od=outsideenum.outside1;
        System.out.println(od);//f.toString()
        data f=data.amazon;

        System.out.println(f);//f.toString()
        switch (f){
            case macys:
                System.out.println("macys");break;
            case amazon:
                System.out.println("amazon in switch loop");
                break;
            default:
                System.out.println("enum constant not found");
                break;
        }
        System.out.println(data.valueOf("macys"));
        System.out.println(data.valueOf("amazon"));

        data[] e=data.values();
        for (data d: e) {
            System.out.println(d+"--"+d.ordinal());
        }

    }


}

package MyJavaProject;

import java.util.HashMap;
import java.util.Map;

public class V38_HashMap {

    public static void main(String[] args) {

        HashMap<String,String> hm = new HashMap<>();

        hm.put("Vijay","BigData");
        hm.put("Raji","MBBS");

        System.out.println(hm);

        for(Map.Entry me2: hm.entrySet()){

            System.out.println(me2.getKey()+":"+me2.getValue());

        }
//        for (Integer i = 0;i<=hm.size();i++){
//
//            System.out.println();
//
//        }
    }
}

package MyJavaProject;

import java.util.ArrayList;

public class V26_ArrayList {
    public static void main(String[] args) {
        ArrayList<String> AL = new ArrayList<String>(10);

        AL.add("Vijay");
        AL.add("Raji");
        AL.add("Bhavya");
        AL.add("Aadhya");

        System.out.println(AL);

        for (String item : AL){
            System.out.println(item);
            }

        System.out.println(AL.get(1));
        System.out.println(AL.size());
        System.out.println(AL.indexOf("Aadhya"));

    }
}

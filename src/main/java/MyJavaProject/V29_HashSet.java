package MyJavaProject;

import java.util.HashSet;

public class V29_HashSet {
    public static void main(String[] args) {
        HashSet<String> HS = new HashSet<String>();

        HS.add("a");
        HS.add("b");
        HS.add("c");
        HS.add("d");

        System.out.println(HS);

        for (String item : HS){
            System.out.println(item);
        }
    }
}

package MyJavaProject;

import java.sql.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class V27_LinkedList {
    public static void main(String[] args) {
        int Array1[] = {0,1,2,3,4,5,6,7,8,9};
        String Array2[] = {"a","b","c","d","e"};

        LinkedList<String> LL = new LinkedList<String>();

        LL.add("Element1");
        LL.add("Element2");

//        System.out.println(LL.get(0));

        for (Object item : LL){
            System.out.println(item);
        }

        LL.push("Element3");
        LL.push("Element4");
        LL.remove("Element1");
        System.out.println(LL);
    }
}

package MyJavaProject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class V28_ListIterator {
    public static void main(String[] args) {

        ArrayList<Integer> AL = new ArrayList<Integer>();
        LinkedList<String> LL = new LinkedList<String>();

        AL.add(1);
        AL.add(2);
        AL.add(3);

        LL.add("Vijay");
        LL.add("Raji");
        LL.add("Bhavya");
        LL.add("Aadhya");

        ListIterator<Integer> LI1 = AL.listIterator();
        while(LI1.hasNext()){
            System.out.println(LI1.next());
        }
        System.out.println("======================");
        ListIterator<String> LI2 = LL.listIterator();
        while(LI2.hasNext()){
            System.out.println(LI2.next());
        }
    }
}

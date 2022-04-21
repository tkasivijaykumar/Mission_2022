package MyJavaProject;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Scanner;

public class V7_LogicalOperators {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your value1: ");

        Scanner scan1 = new Scanner(System.in);
        System.out.println("Enter your value2: ");

        if(scan.hasNextInt() && scan1.hasNextBoolean()){
            System.out.println("Entered values are Valid");
        }
        else if ((scan.hasNextBoolean()) || (scan1.hasNextBoolean())) {
            System.out.println("Entered values are having boolean values");
        }
        else{
            System.out.println("Entered values are InValid");
        }


    }
}

package MyJavaProject;

import java.util.Scanner;

public class V8_SwitchProgram {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your value: ");
        Integer val = scan.nextInt();

        switch (val){
            case 90 :
                System.out.println("Distinction");
                break;
            case 60 :
                System.out.println("First class");
                break;
            case 40 :
                System.out.println("Average");
                break;
            default:
                System.out.println("Poor");
                break;
        }
    }
}

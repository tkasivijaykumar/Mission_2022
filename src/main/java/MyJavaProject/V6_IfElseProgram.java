package MyJavaProject;

import java.util.Scanner;

public class V6_IfElseProgram {
    public static void main(String[] args) {
//        int var = 100;

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number: ");
        Integer var = scan.nextInt();

        if (var > 100){
            System.out.println("var is more than 100");
        }
        else if (var < 100){
            System.out.println("var is less than 100");
        }
        else{
            System.out.println("var is equal to 100");
        }
    }
}

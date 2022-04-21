package MyJavaProject;

public class V25_Recursion {

    public static int factorial(int number){

        if (number<=1){
            return 1;
            }
        else {
            return (number*factorial(number-1));
        }

    }
    public static void main(String[] args) {
        V25_Recursion obj = new V25_Recursion();
        System.out.println(obj.factorial(5));
    }
}

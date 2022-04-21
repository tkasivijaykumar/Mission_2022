package MyJavaProject;

public class V11_ForLoop {
    public static void main(String[] args) {
        int[] Array = {0,1,2,3,4,5,6,7,8,9};

        for(int index=0;index < Array.length;index++){
            System.out.println(Array[index]);
        }

        System.out.println("=============================");
        String val = "Vijay Kumar";

        for(int index=0;index < val.length();index++){
            System.out.println(val.charAt(index));
        }

    }
}

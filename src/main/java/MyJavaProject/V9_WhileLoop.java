package MyJavaProject;

public class V9_WhileLoop {
    public static void main(String[] args) {

//        int a = 10;
        int a = 0;
        System.out.println("========== while Loop==========");
        while (a<10){
            System.out.println(a);
            a++;
        }

        System.out.println("==========Do while Loop==========");
        System.out.println(a);
        do{
            System.out.println(a);
            a++;
        }while (a<10);

    }
}

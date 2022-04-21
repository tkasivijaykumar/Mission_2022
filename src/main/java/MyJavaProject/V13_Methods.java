package MyJavaProject;

public class V13_Methods {

    public static void main(String[] args) {
        mymethod();
        mymethod1("Java");
        int return_val=mymethod2(10);
        System.out.println("mymethod2 return value is: "+return_val);
        System.out.println(return_val+100);
        }

    public static void mymethod(){
        System.out.println("In mymethod");
//        System.out.println(System.getenv());
    }

    public static void mymethod1(String var){
        System.out.println("In mymethod1");
        System.out.println(var);
    }

    public static int mymethod2(Integer var){
        System.out.println("In mymethod2");
        int a=10;
        return var*a;
    }
}

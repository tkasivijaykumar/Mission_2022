package MyJavaProject;

public class V24_Interface implements Interface_1 {

    public void method1(){
        System.out.println("Interface method1");
    }

    public String method2(){
        return "Interface method2";
    }

    public Integer method3(){
        return 10;
    }

    public static void main(String[] args) {
        V24_Interface obj = new V24_Interface();
        obj.method1();
        System.out.println(obj.method2());
        System.out.println(obj.method3());
    }
}

package MyJavaProject;

class MO{
    void Method() {
    }
}
class MethodOveriding extends MO{
    String value1;
    String value2;

    String Method(String value1,String value2){
        System.out.println(value1+value2);
        return value1+value2;
    }

//    int val1;
//    int val2;
//
//    int Method(int val1,int val2){
//        System.out.println(val1+val2);
//        return val1+val2;
//    }

}
public class V22_MethodOveriding {
    public static void main(String[] args) {
        MethodOveriding obj=new MethodOveriding();
        obj.Method("Vijay","Kumar");
        System.out.println(obj.Method("Vijay","Kumar"));
//        obj.Method(20,30);
//        System.out.println(obj.Method(20,30));
    }
}

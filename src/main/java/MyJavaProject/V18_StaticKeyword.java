package MyJavaProject;

public class V18_StaticKeyword {

    private static void staticmethod(){
        System.out.println("In static method");
    }

    private void nonstaticmethod(){
        System.out.println("In non static method");
    }

    public static void main(String[] args) {
        V18_StaticKeyword obj = new V18_StaticKeyword();
        obj.nonstaticmethod();
//        It is very clear that static method can only accessible with class name instead of class object
        V18_StaticKeyword.staticmethod();
    }
}

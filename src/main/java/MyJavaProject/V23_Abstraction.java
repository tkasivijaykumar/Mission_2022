package MyJavaProject;

abstract class Abstraction{
    String method(){
        return "default";
    }
}

class Abstract_call extends Abstraction {
    String method(){
        return "Abstract_call";
    }
}
public class V23_Abstraction {
    public static void main(String[] args) {
        Abstract_call obj = new Abstract_call();
        System.out.println(obj.method());

//      Abstract classes can even be instantiated as below:
        Abstraction obj1 = new Abstraction() {
            @Override
            String method() {
                return super.method();
            }
        };

        System.out.println(obj1.method());

    }
}

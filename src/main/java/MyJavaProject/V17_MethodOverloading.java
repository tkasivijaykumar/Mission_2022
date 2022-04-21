package MyJavaProject;

public class V17_MethodOverloading {

    String name;
    int age;
    String address;

    private void info(String name){
        System.out.println("In NameOnly method");
        this.name=name;
        System.out.println(String.format("My Name is %s", name));
        }

    private void info(String name,Integer age){
        System.out.println("In NamewithAge method");
        this.name=name;
        this.age=age;
        System.out.println(String.format("My Name is %s of age %d", name,age));
    }

    private void info(String name,Integer age,String address){
        System.out.println("In NamewithAgeAdd method");
        this.name=name;
        this.age=age;
        this.address=address;
        System.out.println(String.format("My Name is %s of age %d residing at %s", name,age,address));
    }

    public static void main(String[] args) {
        V17_MethodOverloading obj = new V17_MethodOverloading();
        obj.info("Vijay");
        obj.info("Vijay",30);
        obj.info("Vijay",30,"guntur");
    }
}

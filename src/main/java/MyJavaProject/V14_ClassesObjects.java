package MyJavaProject;

class variables{
int age;
String name;
}

public class V14_ClassesObjects {
    public static void main(String[] args) {
        variables vijay = new variables();
        vijay.name="vijay";
        vijay.age=30;
        System.out.println(String.format("My Name is %s of age %s",vijay.name, vijay.age));
        variables raji = new variables();
        raji.name="raji";
        raji.age=25;
        System.out.println(String.format("My Name is %s of age %s",raji.name,raji.age));


    }
}

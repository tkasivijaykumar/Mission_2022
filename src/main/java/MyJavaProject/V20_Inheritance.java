package MyJavaProject;

class NameInfo{
    String Empname;
    void setnamemethod(String Name){
        Empname=Name;
        }
}

class SalInfo extends NameInfo {
    public String returnnamemethod(){
        return Empname;
    }

    int Salary;
    void setsalmethod(int sal){
        Salary=sal;
    }
}

class Info extends SalInfo{

    public int returnsalmethod(){
        return Salary;
    }
}

public class V20_Inheritance {

    public static void main(String[] args) {
//        Info obj = new Info();
//        obj.setnamemethod("Vijay");
//        System.out.println(obj.returnnamemethod());
//        System.out.println(obj.returnsetsalmethod());

        Info obj1 = new Info();
        obj1.setsalmethod(150000);
        System.out.println("Salary is "+obj1.returnsalmethod());

        obj1.setnamemethod("Vijay");
        System.out.println("Name is "+obj1.returnnamemethod());
    }

}

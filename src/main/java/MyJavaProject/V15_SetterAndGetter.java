package MyJavaProject;

class gettersetter{
    private String name;
    private int age;

    public void setname(String name){
        this.name=name;
    }

    public String getname(){
        return name;
    }

    public void setage(int age){
        this.age=age;
    }
    public int getage(){
        return age;
    }
}

public class V15_SetterAndGetter {
    public static void main(String[] args) {

        gettersetter vijay = new gettersetter();
        vijay.setname("vijay");
        vijay.setage(30);
        System.out.println(String.format("My Name is %s of age %s",vijay.getname(), vijay.getage()));

        gettersetter bhavya = new gettersetter();
        bhavya.setname("bhavya");
        bhavya.setage(4);
        System.out.println(String.format("My Name is %s of age %s",bhavya.getname(), bhavya.getage()));
    }
}

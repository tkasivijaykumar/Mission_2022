package MyJavaProject;

public class V16_Constructor {

    int length,bredth;
    V16_Constructor(){
        System.out.println("In Constructor");
        length=10;
        bredth=10;
    }

//    Constructor overiding
    V16_Constructor(String var){
        System.out.println("In Constructor "+var);
    }

//    Constructor overiding
    V16_Constructor(Integer val1,Integer val2){
        System.out.println("Length value "+val1.toString());
        System.out.println("Bredth value "+val2.toString());
        this.length=val1;
        this.bredth=val2;
    }


    public Integer getSquarevalue(){
        return length*bredth;
    }

    public static void main(String[] args) {
        V16_Constructor obj = new V16_Constructor();
        System.out.println(obj.getSquarevalue());

        V16_Constructor obj1 = new V16_Constructor("Updated");

        V16_Constructor obj2 = new V16_Constructor(20,20);
        System.out.println(obj2.getSquarevalue());

    }
}



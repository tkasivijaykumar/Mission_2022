package MyJavaProject;

class V19_AccessModifiers_SubClass {
    final int val = 100;

    public void publicmethod(){
        System.out.println("in Public Method");
    }

    private void privatemethod(){
        System.out.println("in private Method");
    }

    protected void protectedmethod(){
        System.out.println("in protected Method");
    }
}

/*ACCESS LEVELS
Modifier    Class   Package     Sub-Class   World
Public        Y         Y           Y         Y
Protected     Y         Y           Y         N
No Modifier   Y         Y           N         N
Private       Y         N           N         N
 */

public class V19_AccessModifiers{
    public static void main(String[] args) {
        V19_AccessModifiers_SubClass obj = new V19_AccessModifiers_SubClass();
        obj.publicmethod();
        obj.protectedmethod();

//        It is very clear that private method cannot be accessible outside class and final cannot be re-assigned.
//        obj.val=100;
    }

}
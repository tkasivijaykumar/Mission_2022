package MyJavaProject;

public class V12_Strings {
    public static void main(String[] args) {
        String val = "Java Developer";

        System.out.println(val.length());
        System.out.println(val.replace("Java","Python"));

        for (int index=0;index<val.split(" ").length;index++) {
            System.out.println(val.split(" ")[index]);
        }

        System.out.println(val.concat(" Updated"));
        System.out.println(val.indexOf("D"));
        System.out.println(val.toUpperCase());
        System.out.println(val.toLowerCase());

    }
}

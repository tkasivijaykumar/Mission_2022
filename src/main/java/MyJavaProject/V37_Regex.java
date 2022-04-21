package MyJavaProject;

import java.util.regex.*;


public class V37_Regex {
    public static void main(String[] args) {
        String line = "Hi This is vijay";

        String pattern = ".*?\\bvijay\\b.*?";

//        System.out.println(line.matches(".*?\\bvijay\\b.*?"));
//
        Pattern p = Pattern.compile(pattern);

        Matcher m = p.matcher(line);


        System.out.println(m.groupCount());
        System.out.println(m.find());
        System.out.println(m.toMatchResult());
        System.out.println(m.pattern());
        System.out.println(m.matches());
        System.out.println(m.toString());

        Pattern p1 = Pattern.compile("\\d{10}");
        Matcher m1 = p.matcher("9999999999,123456789,0123456789");
        System.out.println(m1.find());


        if(m.find()){

            for (int i=1;i<=m.groupCount();i++){
                System.out.println(m.group(i));
            }

        }
    }
}

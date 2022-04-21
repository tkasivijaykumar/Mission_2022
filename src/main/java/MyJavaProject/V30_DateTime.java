package MyJavaProject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class V30_DateTime {
    public static void main(String[] args) {
        Date date_obj = new Date();

//        System.out.println(date_obj.getTime());
        System.out.println(date_obj.toString());

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy hh:mm:ss");
        System.out.println(sdf.format(date_obj));


    }
}

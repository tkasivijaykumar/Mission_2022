package MyJavaProject;

class date {

    public String date(String date){
        return date;
    }

    //    classdate="13-12-2015";
    String classdate;
    public String setdate(){
        classdate="13-12-2015";
        return classdate;
    }
}

class datewithtimestamp extends date {
    public String date(String date){
        return date+" 00:00";
    }
}

class datewithseconds extends date {
    public String date(String date){
        return date+" 00:00.0000";
    }
}

public class V21_Polymorphism {
    public static void main(String[] args) {
        date obj_dt = new date();
        date obj_ts = new datewithtimestamp();
        date obj_sec= new datewithseconds();

        System.out.println(obj_dt.date("22-05-2020"));
        System.out.println(obj_ts.date("22-05-2020"));
        System.out.println(obj_sec.date("22-05-2020"));
//        when classdate variable value is assigned directly in main class
//        System.out.println(obj_ts.date(obj_ts.classdate));
//        System.out.println(obj_ts.date(obj_sec.classdate));
        System.out.println(obj_ts.date(obj_ts.setdate()));
        System.out.println(obj_sec.date(obj_sec.setdate()));

        System.out.println(obj_ts.date(obj_sec.setdate()));
    }
}

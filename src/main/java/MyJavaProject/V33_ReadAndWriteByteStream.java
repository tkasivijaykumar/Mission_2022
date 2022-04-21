package MyJavaProject;

import java.io.*;

public class V33_ReadAndWriteByteStream {

    public static void main(String[] args) throws IOException {
//        BufferedReader br = null;

        FileInputStream FIS_obj = null;
        FileOutputStream FOS_obj = null;

        try {


            FIS_obj=new FileInputStream("C:\\Users\\kasivijaykt\\Documents\\My Received Files\\Spark\\dept.txt");

            FOS_obj=new FileOutputStream("C:\\Users\\kasivijaykt\\Documents\\My Received Files\\Spark\\javadept.txt");

            int c;
            System.out.println(FIS_obj.read());

            while((c=FIS_obj.read())!=-1){
                FOS_obj.write(c);

//            br = new BufferedReader(new FileReader("C:\\Users\\kasivijaykt\\Documents\\My Received Files\\Spark\\dept.txt"));
//            String lines;
//
//            File deptfile = new File("C:\\Users\\kasivijaykt\\Documents\\My Received Files\\Spark\\javadept.txt");
//            if (!deptfile.exists()){
//                deptfile.createNewFile();
//            }



//            PrintWriter pw = new PrintWriter(deptfile);
//            while ((lines = br.readLine()) != null){
//                System.out.println(lines);
////              PrintWriter pw = new PrintWriter(deptfile);
////              pw.write(lines);
////                pw.println(lines);
////                pw.append(lines);
////                pw.close();
//
////                fw.write(lines);
//                FileWriter fw = new FileWriter(deptfile,true);
//                fw.append(lines);

                }

        System.out.println("Successfully data loaded to file");

        }
//          catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        finally {
//            br.close();
            System.out.println("Done");
            if(FIS_obj!=null){
                FIS_obj.close();
            }
            if(FOS_obj!=null){
                FOS_obj.close();
            }
        }
    }
}

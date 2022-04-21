package MyJavaProject;

import java.io.*;

public class V35_ReadAndWriteFileStreams {
    public static void main(String[] args) {
        InputStream IS = null;
        OutputStream OS= null;

        try{
            IS=new FileInputStream("C:\\Users\\kasivijaykt\\Documents\\My Received Files\\Spark\\dept.txt");

            OS=new FileOutputStream("C:\\Users\\kasivijaykt\\Documents\\My Received Files\\Spark\\javadept2.txt");

            int size = IS.available();
//            System.out.println(size);
            for (int i=0;i<size;i++){
//                System.out.println(IS.read());
                OS.write(IS.read());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

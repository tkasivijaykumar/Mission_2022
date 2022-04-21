package MyJavaProject;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class V32_WritingFile {
    public static void main(String[] args) {


        try {
            File data = new File("C:\\Users\\kasivijaykt\\Documents\\My Received Files\\Spark\\javafile.txt");
            if (!data.exists()) {
                data.createNewFile();
            }

            PrintWriter pw = new PrintWriter(data);
            pw.println("Hi This File is created using java program");
            pw.println("Hi This File is created using java program");
            pw.println("Hi This File is created using java program");
            pw.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        finally {
            System.out.println("Done");
        }
    }
}

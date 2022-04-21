package MyJavaProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class V31_ReadFile {
    public static void main(String[] args) throws IOException {
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader("C:\\Users\\kasivijaykt\\Documents\\My Received Files\\Spark\\emp.txt"));
            String line;
            while ((line = br.readLine()) != null  ){
                System.out.println(line);
            }
        }

        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            br.close();
            System.out.println("Done");
        }
    }
}

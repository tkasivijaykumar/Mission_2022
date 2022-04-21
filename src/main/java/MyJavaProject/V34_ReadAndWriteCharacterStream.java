package MyJavaProject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class V34_ReadAndWriteCharacterStream {
    public static void main(String[] args) throws IOException {
        FileReader FR = null;
        FileWriter FW = null;

        try {
            FR = new FileReader("C:\\Users\\kasivijaykt\\Documents\\My Received Files\\Spark\\dept.txt");

            FW = new FileWriter("C:\\Users\\kasivijaykt\\Documents\\My Received Files\\Spark\\javadept1.txt");

            int c;
            System.out.println(FR.read());

            while ((c = FR.read()) != -1) {
                FW.write(c);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        finally {
//            br.close();
            System.out.println("Done");
            if(FR!=null){
                FR.close();
            }
            if(FW!=null){
                FW.close();
            }
        }
    }
}

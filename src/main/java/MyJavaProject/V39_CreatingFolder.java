package MyJavaProject;

import java.io.File;

public class V39_CreatingFolder {
    public static void main(String[] args) {
        String path = "C:\\Users\\kasivijaykt\\Documents\\My Received Files\\to_be\\Spark\\java";
        File f = new File(path);

        if(f.exists()) {
            System.out.println("Directory Already Exists");
        }
        else {
            boolean bool = f.mkdir();

            if (bool) {
                System.out.println("Directory created successfully");
            } else {
                System.out.println("Sorry couldn’t create specified directory");
            }
        }
    }
}

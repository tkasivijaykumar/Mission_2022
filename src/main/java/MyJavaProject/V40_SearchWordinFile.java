package MyJavaProject;

import java.io.*;

public class V40_SearchWordinFile {

    public static void main(String[] args) throws IOException {

        String file = "C:\\Users\\kasivijaykt\\Documents\\My Received Files\\to_be\\Spark\\javafile.txt";

        File f = new File(file);
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);

        String[] words = null;
        String s;
        String searchword = "java";
        Integer count=0;

        while ((s=br.readLine())!=null){
            words=s.split(" ");
            for(String word: words){
                if(word.equals(searchword)){
                    count++;
                }



            }
        }

        if(count!=0){
            System.out.println(String.format("The given word is present %s times in the file", count));
        }
        else {
            System.out.println("The given word is not present in the file");
        }


    }
}

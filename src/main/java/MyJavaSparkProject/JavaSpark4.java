package MyJavaSparkProject;

import org.apache.spark.sql.*;


public class JavaSpark4 {
    public static void main(String[] args) {
        SparkSession spark = SparkSession.builder().appName("JavaSpark4").master("local").getOrCreate();

        String path = "C:\\Users\\Vijay Kumar\\IdeaProjects\\Mission_2022\\src\\data\\emp.txt";

        Encoder<JavaEmployee> EmpEncoder = Encoders.bean(JavaEmployee.class);

        Dataset<JavaEmployee> empDF = spark.read().csv(path).as(EmpEncoder);

        empDF.show();


    }
}

package MyScalaSparkProject

import org.apache.spark.sql.SparkSession

object SparkProject5 {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().appName("SparkProject5").master("local").getOrCreate()
    import spark.implicits._

    val df = spark.sparkContext.textFile("C:\\Users\\kasivijaykt\\Documents\\My Received Files\\to_be\\Spark\\emp.txt").map(row => row.split(","))
      .map { case Array(a, b, c, d, e, f, g, h) => (a.toInt, b, c, d.trim, e, f.toDouble, g, h.toInt) }
      .toDF("empno", "ename", "job", "mgr", "hiredate", "sal", "comm", "deptno")



    //    val map = Map("mgr" -> "0000","comm" -> "0" )
    //
    //    df.na.fill(map).show()


    //    df.where("mgr='' or comm=''").withColumn("mgr",expr("null"))
    //      .withColumn("comm",expr("null")).show()


    //    df.withColumn("")
    val ds = df.as[(String, String, String, String, String, String, String, String)]
    //    println(ds)
    //    println(ds.show())

    //    println(ds.getClass)

    val ds1 = spark.sparkContext.textFile("C:\\Users\\kasivijaykt\\Documents\\My Received Files\\to_be\\Spark\\emp.txt").map(row => row.split(","))
      .map { case Array(a, b, c, d, e, f, g, h) => (a.toInt, b, c, d.trim, e, f.toDouble, g.trim, h.toInt) }
      .toDS()

    //    ds1.select("_1","_8").show()
  }

  //                                DataFrame             DataSet
  //  Analysis Error                Runtime               Compiletime
  //  safety                        Un-typed              type safe
  //  Apply lambda function         No                    Yes
  //    in filter or map function
  //  Query on non-existent column  Runtime               Complietime
  //  Preserve schema               No                    Yes
}

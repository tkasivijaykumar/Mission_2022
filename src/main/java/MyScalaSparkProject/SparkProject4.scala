package MyScalaSparkProject

import org.apache.spark.sql.functions.collect_list
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}
import org.apache.spark.sql.{Row, SparkSession}

object SparkProject4 {
  def main(args: Array[String]): Unit = {


    val spark = SparkSession.builder.appName("Spark Project 4").master("local").getOrCreate()

    import spark.implicits._

    val schema = StructType(Array(StructField("name", StringType, true), StructField("age", StringType, true)))
    val data = Seq(
      Row("vijay", "30"),
      Row("bhavya", "4")
    )

    val df = spark.createDataFrame(spark.sparkContext.parallelize(data), schema = schema)
    df.show()

    val empdata = Seq(
      Row(1234, "Vijay"),
      Row(1234, "Bhavya")
    )

    val empdf = empdata.map(col => Emp(col(0).toString, col(1).toString)).toDF()
    empdf.show()

    val grpdata = Seq(
      Row(1, "a"),
      Row(1, "b"),
      Row(2, "a"),
      Row(2, "b"),
      Row(3, "a"),
      Row(3, "b")
    )


    val grpschema = StructType(Array(StructField("int", IntegerType, true), StructField("str", StringType, true)))

    val grpdf = spark.createDataFrame(spark.sparkContext.parallelize(grpdata), schema = grpschema)
    grpdf.show()

    grpdf.groupBy("int").agg(collect_list("str")).show()


    val grpdata_1 = Seq(
      (1, "a"),
      (1, "b"),
      (2, "a"),
      (2, "b"),
      (3, "a"),
      (3, "b")
    )

    val grpdf_1 = grpdata_1.toDF("int", "str")
    grpdf_1.groupBy("int").agg(collect_list("str")).show()
    //    grpdf.select("int").groupBy("str").count().show()


  }
}

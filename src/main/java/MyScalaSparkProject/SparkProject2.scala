package MyScalaSparkProject

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions._
import org.apache.spark.sql.internal.SQLConf.SHUFFLE_PARTITIONS
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}

object SparkProject2 {

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().appName("SparkProject2").master("local").getOrCreate()
    //    val spark = SparkSession.builder().appName("MyProject1").master("local")
    //    .config("spark.driver.cores","1").config("spark.executor.memory","1g").getOrCreate()

    //      val conf = new SparkConf().setAppName("app").setMaster("local")
    //        val sc = new SparkContext(conf)


    import spark.implicits._



    //To get all Configurations of default conf
    println(spark.sparkContext.getConf.getAll.toMap)
    //    Map(spark.driver.host -> HDLKASIVIJAYKT.Virtusa.com,
    //    spark.driver.port -> 59128,
    //    spark.app.name -> MyProject1,
    //    spark.executor.id -> driver,
    //    spark.master -> local,
    //    spark.app.id -> local-1576480509594)

    //    After specifying below config
    //      .config("spark.driver.cores","1").config("spark.executor.memory","1g")
    //    println(spark.sparkContext.getConf.getAll.toMap)
    //    Map(spark.driver.host -> HDLKASIVIJAYKT.Virtusa.com,
    //      spark.driver.port -> 59196,
    //      spark.app.name -> MyProject1,
    //      spark.executor.id -> driver,
    //      spark.driver.cores -> 1,
    //      spark.master -> local,
    //      spark.executor.memory -> 1g,
    //      spark.app.id -> local-1576480831886)


    Logger.getLogger("org").setLevel(Level.ERROR)
    Logger.getLogger("org").setLevel(Level.WARN)
    Logger.getLogger("akka").setLevel(Level.ERROR)
    Logger.getLogger("akka").setLevel(Level.WARN)

    //    val list1 = List(1,2,3,4,5,6,7,8,9)
    //    val a1 = spark.sparkContext.parallelize(list1)
    //    a1.foreach(println)

    val path = "C:\\Users\\kasivijaykt\\Documents\\My Received Files\\to_be\\Spark"

    val emp = spark.sparkContext.textFile(path + "\\" + "emp.txt")
    //
    //    //print(emp.getClass)
    val empDF = emp.map(x => x.split(","))
      .map { case Array(a, b, c, d, e, f, g, h) => (a.toInt, b, c, d.trim, e, f.toDouble, g.trim, h.toInt) }
      .toDF("empno", "ename", "job", "mgr", "hiredate", "sal", "comm", "deptno")

    //    String Concatenation
    empDF.groupBy("deptno").agg(collect_list("empno")).show(false)
    //    println(empDF.getClass.getTypeName)



    println(empDF.getClass)

    //    class org.apache.spark.sql.Dataset

    //empDF.select("deptno").distinct().show()
    //val map = Map("mgr" -> "0000","comm" -> "0" )
    //empDF.select("*").where("comm is null").show()
    //empDF.select("*").where("comm==''").show()
    //empDF.select("*").where("mgr == ''").show()

    val maxsal_empDF = empDF.groupBy("deptno").agg(max("sal").alias("max_sal"))
    println("maxsal_empDF Shuffle Partitions")
    println(maxsal_empDF.rdd.getNumPartitions)

    println("maxsal_empDF Shuffle Partitions after setting property")
    spark.sessionState.conf.setConf(SHUFFLE_PARTITIONS, 2)
    val maxsal_empDF_after_config = empDF.groupBy("deptno").agg(max("sal").alias("max_sal"))
    println(maxsal_empDF_after_config.rdd.getNumPartitions)



    /*
    //empDF.withColumn("comm",regexp_replace(col("comm")," ","0")).
      //withColumn("mgr",regexp_replace(col("mgr")," ","0000")).show()
      //empDF.withColumn("Reporting",when(length(col(empDF.mgr))) == "",lit("No Manager").otherwise(empDF.mgr)).show()
    */

    val deptschema: StructType = StructType(Array(StructField("deptno", IntegerType), StructField("dname", StringType), StructField("loc", StringType)))

    val deptDF = spark.read.format("csv").schema(deptschema).option("header", "False")
      .load(path + "\\" + "dept.txt")

    println(deptDF.getClass)

    //print(deptschema)
    deptDF.show()

    //CASTING COLUMNS//
    //    var casted_df=empDF.columns.map(x => col(x).cast("string"))
    //    var castedDf=empDF.select(casted_df:_*)
    //    var castedDf1=empDF.select("*")
    //    castedDf.printSchema()
    //    castedDf1.printSchema()

    //adding a column with timestamp
    var batchtime = System.currentTimeMillis()
    println(batchtime)
    deptDF.withColumn("timestamp", lit(batchtime)).show()


    //Applying rank on sal column
    var ranked = empDF.withColumn("rank", rank().over(Window.partitionBy($"deptno").orderBy($"sal".desc))).orderBy($"deptno".desc, $"rank".asc)
    ranked.show()

    //Collecting data from partitions of RDD manually
    println(emp.getNumPartitions)
    //    emp.mapPartitionsWithIndex((index: Int,it: Iterator[String]) => it.toList.map(x => if (index ==0) {println(x)}).iterator).collect()
    println(emp.mapPartitionsWithIndex((index: Int, it: Iterator[String]) => it.toList.map(x => if (index == 0) {
      println(x)
    }).iterator).count())
    println("####################################")
    emp.mapPartitionsWithIndex((index: Int, it: Iterator[String]) => it.toList.map(x => if (index == 1) {
      println(x)
    }).iterator).collect()

    //Creating a new sequence ID
    empDF.withColumn("ID", monotonically_increasing_id()).show()


    println(empDF.explain())
    println(empDF.rdd.toDebugString)


    //    Broadcast variables
    //    val empDF_s=spark.read.csv(path+"\\"+"emp.txt").toDF("empno", "ename", "job", "mgr", "hiredate", "sal", "comm", "deptno")
    //    empDF_s.show()
    //    val maxsal_empDF_s = empDF.groupBy("deptno").agg(max("sal")).distinct().collect().map(r => r(0)).toArray

    //    val broadcasast_var_max_sal_empDF=spark.sparkContext.broadcast(maxsal_empDF_s)
    //    val broadcasast_var_max_sal_empDF_schema=spark.sparkContext.broadcast(empDF_s.schema)
    //    println(broadcasast_var_max_sal_empDF.value.foreach(println))

    //    val maxsal_empDF_after_broadcasting = spark.createDataFrame(broadcasast_var_max_sal_empDF.value,broadcasast_var_max_sal_empDF_schema.value)
    //    maxsal_empDF_after_broadcasting.show()

    //    Accumulators
    //    val accum1 = spark.sparkContext.doubleAccumulator("accum1")
    //    spark.sparkContext.parallelize(Array(1,2,3,4,5)).foreach(x=>accum1.add(x))
    //    println(accum1.value)

  }

}

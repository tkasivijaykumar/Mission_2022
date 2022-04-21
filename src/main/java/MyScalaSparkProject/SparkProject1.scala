package MyScalaSparkProject

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.types.{StringType, StructField, StructType}
import org.apache.spark.sql.{Row, SparkSession}

object SparkProject1 {

  def main(args: Array[String]): Unit = {

    val spark: SparkSession = SparkSession.builder.appName("SparkProject1").master("local").getOrCreate()

    Logger.getLogger("org").setLevel(Level.ERROR)

    //    val conf = new SparkConf().setAppName("My Spark Project").setMaster("local")
    //    val sc: SparkContext = new SparkContext(conf)
    //    val Sqlcontext = new SQLContext(sc: SparkContext)

    val empstr = "empno ename job mgr hiredate sal comm deptno"
    val empfields = empstr.split(" ").map(col => StructField(col, StringType, nullable = true))
    val empschema = StructType(empfields)
    //    println(empschema.getClass)

    val emprdd = {
      spark.sparkContext.textFile("C:\\Users\\Vijay Kumar\\IdeaProjects\\Mission_2022\\src\\data\\emp.txt")
        .map(x => x.split(","))
        .map(x => Row(x(0), x(1), x(2), x(3), x(4), x(5), x(6), x(7)))
    }


    //println(emprdd.getClass)

    val empDF = spark.createDataFrame(emprdd, empschema)

    //    print(empDF.schema)
    //    print(empDF.getClass)
    //empDF.show()

        val deptstr="deptno,dname,location"
        val deptschema=StructType(deptstr.split(",").map(col=>StructField(col,StringType,true)))
        val deptrdd = spark.sparkContext.textFile("C:\\spark\\dept.txt").
         map(x => x.split(",")).map(x => Row(x(0), x(1), x(2)))
    //
        val deptDF=spark.createDataFrame(deptrdd,deptschema)
    //print(deptDF.schema)
    //deptDF.show()

        val empdeptDF = empDF.join(deptDF,"deptno")
    //    empdeptDF.show()

    //val EDdf = empdeptDF.createTempView("EmpDept")

    //val dd=spark.sql("SELECT * FROM (SELECT EMPNO,ENAME,DNAME,DEPTNO,SAL, DENSE_RANK() OVER(PARTITION BY DNAME ORDER BY SAL) RANK FROM EmpDept) WHERE RANK=1 ")
    //dd.show()
    //empdeptDF.select("*").orderBy("sal").show()
    //empdeptDF.groupBy("sal").max("sal").show() --org.apache.spark.sql.AnalysisException: "sal" is not a numeric column. Aggregation function can only be applied on a numeric column.
    empdeptDF.groupBy("dname").count().show()
    //empdeptDF.where("job = 'MANAGER'").show()
    //empdeptDF.write.csv("C:\\Users\\kasivijaykt\\Documents\\My Received Files\\Spark\\empdept.txt")
    //empdeptDF.repartition(1).write.mode("overwrite").json("C:\\Users\\kasivijaykt\\Documents\\My Received Files\\Spark\\empdept.json")
    //empdeptDF.select("*").groupBy("location").count().show()
    //empdeptDF.groupBy("deptno").agg(avg("""sal""")) //since we have not defined the schema to integer values cannot  be grouped on the string values.


    //    empdeptDF.coalesce(2)

    //    val collect_data=empdeptDF.crossJoin(deptDF).collect()
    //    collect_data.foreach(println)
    //      println(empdeptDF.crossJoin(deptDF).count())

    //    ##############################################################
    //    Compare 2 different dataframes
    val df1 = empDF.filter("ename like 'A%'").select("empno", "ename", "job")
    //    df1.show()

    val df2 = empDF.filter("ename like 'B%'").select("empno", "ename", "job")
    //    df2.show()


    //    println(df1.count())
    //    println(df2.count())
    //    println(df1.except(df2).count())

    //    1.First we need to find the columns in expected and actual dataframes.
    val columns = df1.schema.fields.map(_.name)
    //    columns.foreach(println)

    //    2.Then we have to find difference columnwise.
    val selectiveDifferences = columns.map(col => df1.select(col).except(df2.select(col)))
    //    selectiveDifferences.foreach(println)
    //    println(selectiveDifferences.getClass)


    //    3.At last we need to find out which columns contains different values.
    selectiveDifferences.map(diff => {
      if (diff.count > 0) diff.show
    })
    //    ##############################################################

    //    empDF.createTempView("EMP_T")
    //    deptDF.createTempView("DEPT_T")

    //    spark.sql("SELECT * FROM EMP_T").show()
    //    spark.sql("SELECT * FROM DEPT_T").show()
    //    spark.sql("SELECT * FROM EMP_T JOIN DEPT_T ON EMP_T.DEPTNO=DEPT_T.DEPTNO").show()
    //    spark.sql("SELECT * FROM EMP_T LEFT OUTER JOIN DEPT_T ON EMP_T.DEPTNO=DEPT_T.DEPTNO").show()
    //    spark.sql("SELECT * FROM EMP_T RIGHT OUTER JOIN DEPT_T ON EMP_T.DEPTNO=DEPT_T.DEPTNO").show()
    //    spark.sql("SELECT * FROM EMP_T FULL OUTER JOIN DEPT_T ON EMP_T.DEPTNO=DEPT_T.DEPTNO").show()

    //    println(empDF.getClass.toString())
    //    println(empDF.getClass)

    //    println(empDF.rdd.getNumPartitions)
    //    println(emprdd.getNumPartitions)
    //    println(emprdd.mapPartitions(iter => Array(iter.size).iterator,true))

    //    println(spark.read.format("csv").text("C:\\Users\\kasivijaykt\\Documents\\My Received Files\\Spark\\emp.txt").toDF().getClass.getConstructors)
    //    println(spark.read.format("csv").text("C:\\Users\\kasivijaykt\\Documents\\My Received Files\\Spark\\emp.txt").getClass.getTypeName)
    //    println(spark.read.format("csv").text("C:\\Users\\kasivijaykt\\Documents\\My Received Files\\Spark\\emp.txt").getClass.getMethods)
    //    println(spark.read.format("csv").text("C:\\Users\\kasivijaykt\\Documents\\My Received Files\\Spark\\emp.txt").getClass.getName)
    //    println(spark.read.format("csv").text("C:\\Users\\kasivijaykt\\Documents\\My Received Files\\Spark\\emp.txt").getClass.getPackage )


  }
}

package MyScalaSparkProject

import org.apache.spark.sql.SparkSession

object SparkProject3 {

  //  case class Employee (empno: String, ename: String, job: String, mgr: String, hiredate: String, sal: String, comm: String, deptno: String)

  def main(args: Array[String]): Unit = {

    val spark = SparkSession.builder().master("local").appName("case class").getOrCreate()
    import spark.implicits._

    //    val conf = new SparkConf().setMaster("local").setAppName("case class")
    //    val sc = new SparkContext(conf)
    //    val sparksql = new SQLContext(sc)

    val empDF = spark.sparkContext.textFile("C:\\Spark\\emp.txt").map(x => x.split(","))
      .map(col => Employee(col(0).toInt, col(1), col(2), col(3).trim.replaceAll("''", null), col(4), col(5).toDouble, col(6).trim.replaceAll("''", null), col(7).toInt)).toDF()
    //      .toDF("empno", "ename", "job", "mgr", "hiredate", "sal", "comm", "deptno")
    //    Date.valueOf(col(4))
    val deptDF = spark.sparkContext.textFile("C:\\Spark\\dept.txt")
      .map(x => x.split(",")).map(col => Department(col(0).toInt, col(1).toString, col(2).toString)).toDF()

    empDF.cache()
    //    empDF.show()
    //    deptDF.show()

    //    println(empDF.getClass)
    //    class org.apache.spark.sql.Dataset

    //    val nullMap = Map("comm" -> "0", "mgr" -> "0000")

    //    empDF.where("comm='' or mgr = '' ").show()
    //    empDF.where("(comm is null) or (mgr is null)").show()
    //    empDF.groupBy("deptno").sum("sal").alias("sal_sum").show()

    //    empDF.select("deptno","sal").filter("sal > 3000").show()

    //    empDF.createTempView("Employee")
    //
    //    spark.sqlContext.sql("SELECT count(*) as tab_count FROM EMPLOYEE").show()

    //    Sql Queries
    //    1.SELECT * FROM EMP
    //    empDF.select("*").show()
    //    2.select distinct job from emp;
    //    empDF.select("job").distinct().show()
    //    3.select * from emp order by sal asc;
    //    empDF.orderBy(desc("sal")).show()
    //    empDF.orderBy($"sal".desc).show()
    //    4.select * from emp order by deptno asc,job desc;
    //    empDF.orderBy($"deptno".asc).orderBy($"job".desc).show()
    //    5.select distinct job from emp order by job desc;
    //    empDF.select("job").distinct().orderBy(desc("job")).show()

    //    6.Select * from emp where empno in ( select mgr from emp) ;
    //    val distinct_mgr=empDF.select("mgr").distinct().collect().map(r => r(0)).toList
    //    empDF.select($"empno").where($"empno".isin(distinct_mgr:_*)).show()

    //    7.select empno ,ename ,sal,sal/30,12*sal annsal from emp order by annsal asc;
    //    empDF.withColumn("dailysal",expr("sal/30")).withColumn("annualsal",expr("sal*30")).orderBy(asc("annualsal")).show()

    //    8.Display the Empno, Ename, job, Hiredate, Exp of all Mgrs
    //    select empno,ename ,job,hiredate, months_between(sysdate,hiredate) exp from emp where empno in (select mgr from emp);

    //    val var_date=java.time.LocalDate.now.toString()
    //    println(var_date)
    //    val date_df=empDF.withColumn("cd", current_date ).withColumn("to_date_hd",datediff(current_timestamp(),col("hiredate"))).show()
    //  .withColumn("to_date_hd",col("hiredate").cast("date"))
    //    date_df.withColumn("difmonths",datediff())

    //    9.select * from emp where comm. > sal;
    //    empDF.where("comm > sal").show()
    //    10. List the emps along with their Exp and Daily Sal is more than Rs.100.
    //    empDF.where("sal/30>100").show()
    //    11. select * from emp where job = ‘CLERK’ or job = ‘ANALYST’ order by job desc;
    //    empDF.where("job in ('CLERK','ANALYST')").orderBy("job").show()
    //    12.select * from emp where deptno = 10  or deptno = 20 ;
    //    empDF.where("deptno in (10,20)").show()
    //    13.select * from emp where 12*sal between 22000 and 45000;
    //    empDF.where("sal*12 between 22000 and 45000").show()
    //    14.select  ename from emp where  length (ename) = 5;
    //    empDF.where("length(ename) = 5").show()
    //    15.select  * from emp where length(ename) = 4 and ename like ‘__R%’;
    //    empDF.where("length(ename)=4 and ename like '__R%'").show()
  }

}

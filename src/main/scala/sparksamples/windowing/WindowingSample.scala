package sparksamples.windowing

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.functions.{col, lag, lead, when}
import org.apache.spark.sql.types.{DateType, DoubleType, IntegerType, StringType, StructField, StructType}

object WindowingSample extends App{

  val spark:SparkSession = SparkSession.builder()
    .master("local[1]")
    .appName("ReadCSV")
    .getOrCreate()
  spark.sparkContext.setLogLevel("ERROR")
  val filePath="src/main/resources/csv/employee.csv"
  val schema = StructType(Array(StructField("EmpId", IntegerType, false),
    StructField("EmpName", StringType, false),
    StructField("Salary", DoubleType, false),
    StructField("SalaryDate", DateType, false)))
  val df = spark.read.option("header",true)
    .option("dateFormat", "MM/dd/yyyy")
    .schema(schema)
    .csv(filePath)
  df.show(false)

  /* LAG is a function in SQL which is used to access previous row values in current row.
  *  This is useful when we have use cases like comparison with previous value.
  * LAG in Spark dataframes is available in Window functions
  */
  val window = Window.orderBy("SalaryDate")
  //use lag to get previous row value for salary, 1 is the offset
  val lagCol = lag(col("Salary"), 1).over(window)
  df.withColumn("LagCol", lagCol).show()

  /**
   * LEAD is a function in SQL which is used to access next row values in current row.
   * This is useful when we have use cases like comparison with next value.
   * LEAD in Spark dataframes is available in Window functions
   */
  //use lag to get previous row value for salary, 1 is the offset
  val leadCol = lead(col("Salary"), 1).over(window)
  df.withColumn("LeadCol", leadCol).show()

  /**
   * Trend analysis with window functions Now, let us put window function LAG to use with a simple trend analysis.
   * If salary is less than previous month we will mark it as "DOWN",
   * if salary has increased then "UP".
   * The code use Window function to order by, lag and then do a simple if else with WHEN.
   */
  val laggingCol = lag(col("Salary"), 1).over(window)
  //Use derived column LastSalary to find difference between current and previous row
  val salaryDifference = col("Salary") - col("LastSalary")
  //Calculate trend based on the difference
  //IF ELSE / CASE can be written using when.otherwise in spark
  val trend = when(col("SalaryDiff").isNull || col("SalaryDiff")===(0), "SAME")
    .when(col("SalaryDiff")>(0), "UP")
    .otherwise("DOWN")
  df.withColumn("LastSalary", laggingCol)
    .withColumn("SalaryDiff",salaryDifference)
    .withColumn("Trend", trend).show()

}

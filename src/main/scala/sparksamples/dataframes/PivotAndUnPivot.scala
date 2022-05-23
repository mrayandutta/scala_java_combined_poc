package sparksamples.dataframes

import org.apache.spark.sql.SparkSession

object PivotAndUnPivot extends App{

  val spark:SparkSession = SparkSession.builder()
    .master("local[1]")
    .appName("ReadCSV")
    .getOrCreate()
  spark.sparkContext.setLogLevel("ERROR")
  val data = Seq(("Banana",1000,"USA"), ("Carrots",1500,"USA"), ("Banana",400,"China"),
    ("Carrots",1200,"China"),("Banana",2000,"Canada"),("Carrots",2000,"Canada"))

  import spark.sqlContext.implicits._
  val df = data.toDF("Product","Amount","Country")
  df.show()
  /**
   * Pivot Spark DataFrame
   * Spark SQL provides pivot() function to rotate the data from one column into multiple columns (transpose row to column).
   * It is an aggregation where one of the grouping columns values transposed into individual columns with distinct data.
   * From the above DataFrame, to get the total amount exported to each country of each product
   * will do group by Product, pivot by Country, and the sum of Amount.
   */
  val pivotDF = df.groupBy("Product").pivot("Country").sum("Amount")
  pivotDF.show()


}

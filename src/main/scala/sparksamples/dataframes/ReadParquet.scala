package sparksamples.dataframes

import org.apache.spark.sql.SparkSession

object ReadParquet extends App{

  val spark:SparkSession = SparkSession.builder()
    .master("local[1]")
    .appName("ReadParquet")
    .getOrCreate()
  spark.sparkContext.setLogLevel("ERROR")
  val filePath="src/main/resources/parquet/userdata1.parquet"
  val df = spark.read.option("header",true).parquet(filePath)
  df.show(false)

}

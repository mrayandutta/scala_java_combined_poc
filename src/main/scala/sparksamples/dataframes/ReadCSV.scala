package sparksamples.dataframes

import org.apache.spark.sql.SparkSession
object ReadCSV extends App{

  val spark:SparkSession = SparkSession.builder()
    .master("local[1]")
    .appName("ReadCSV")
    .getOrCreate()
  spark.sparkContext.setLogLevel("ERROR")
  //val filePath="src/main/resources/csv/sample.csv"
  val filePath="src/main/resources/csv/product/*"
  val df = spark.read.option("header",true).csv(filePath)
  df.show(false)
  df.createOrReplaceTempView("v1")
  val byteToMB = 1024*1024
  val byteToGB = byteToMB*1024
  val fileSize = (df.queryExecution.optimizedPlan.stats.sizeInBytes/byteToMB).toDouble
  println("Dataframe size (MB) :"+fileSize)

}

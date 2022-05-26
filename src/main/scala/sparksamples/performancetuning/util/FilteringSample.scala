package sparksamples.performancetuning.util

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.col

object FilteringSample extends App{

  val spark:SparkSession = SparkSession.builder()
    .master("local[1]")
    .appName("FilteringSample")
    .getOrCreate()
  spark.sparkContext.setLogLevel("ERROR")
  spark.conf.set("spark.sql.autoBroadcastJoinThreshold", -1)

  val bigFilePath="src/main/resources/csv/product/product1.csv"
  val smallFilePath="src/main/resources/csv/product/product2.csv"
  val largeDF = spark.read.option("header",true).csv(bigFilePath)
  val smallDF = spark.read.option("header",true).csv(smallFilePath)
  val joinedDFWithoutFilter = largeDF.join(smallDF,largeDF("id") === smallDF("id"),"inner" )
  joinedDFWithoutFilter.explain()
  //Thread.sleep(100000000)
  val joinedDFWithFilter = largeDF.select("id").as("t1").join(smallDF.select("id").as("t2"),col("t1.id")===col("t2.id"))
  joinedDFWithFilter.explain()
  Thread.sleep(100000000)




}

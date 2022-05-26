package sparksamples.performancetuning.util

import org.apache.spark.sql.SparkSession

object ClusterDetails extends App{

  val spark:SparkSession = SparkSession.builder()
    .master("local[4]")
    .appName("DataGenerator")
    .getOrCreate()
  import spark.implicits._
  spark.sparkContext.setLogLevel("ERROR")
  val noOfExecutors = spark.sparkContext.statusTracker.getExecutorInfos.length -1
  print("noOfExecutors:"+noOfExecutors)

}

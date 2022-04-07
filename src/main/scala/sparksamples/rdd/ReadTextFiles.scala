package sparksamples.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession

object ReadTextFiles extends App {

  val spark:SparkSession = SparkSession.builder()
    .master("local[1]")
    .appName("ReadTextFiles")
    .getOrCreate()
  spark.sparkContext.setLogLevel("ERROR")
  println("##spark read text files from a directory into RDD")
  val rddFromFile = spark.sparkContext.textFile("src/main/resources/csv/data.csv")
  val rdd = rddFromFile.map(f=>{
    f.split(",")
  })
  rdd.foreach(f=>{
    println("Col1:"+f(0)+",Col2:"+f(1))
  })

  /*
  rddFromFile.collect().foreach(f=>{
    println(f)
  })
  */

}


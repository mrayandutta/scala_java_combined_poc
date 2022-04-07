package sparksamples.basics

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
object Test {
  def main(args: Array[String]): Unit = {
    val sc = new SparkContext(new SparkConf().setAppName("Hello World")
      .setMaster("local[2]"))
    println("Hello World!")
    sc.stop()
  }

}

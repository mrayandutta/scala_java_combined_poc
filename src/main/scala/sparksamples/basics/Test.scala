package sparksamples.basics

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
object Test {
  def main(args: Array[String]): Unit = {
    val sc = new SparkContext(new SparkConf().setAppName("Hello World")
      .setMaster("local[2]"))
      //.setMaster("spark://localhost:7077"))
      //.setMaster("spark://host.docker.internal:4040"))
      //.setMaster("spark://10.1.0.4:4040"))
      //.setMaster("spark://127.0.0.1:7077"))
    println("Hello World!")
    sc.stop()
  }

}

package sparksamples.basics

import org.apache.spark.{SparkConf, SparkContext}

object WordCount {
  def main(args: Array[String]): Unit = {
    val sc = new SparkContext(new SparkConf().setAppName("WordCount")
      .setMaster("local[2]"))
    val data=sc.textFile("src/main/resources/text/data.txt")
    val splitData = data.flatMap(line => line.split(" "))
    val mapData = splitData.map(word => (word,1));
    val reduceData = mapData.reduceByKey(_ + _)
    val finalOutput = reduceData.collect
    finalOutput.foreach(x=> println(x))

    sc.stop()
  }
}

package sparkstreaming.basics
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.functions._
object ReadFromTopic {

  val spark = SparkSession.builder()
    .appName("Integrating Kafka")
    .master("local[2]")
    .getOrCreate()
  spark.sparkContext.setLogLevel("ERROR")

  def readFromKafka() = {
    // Subscribe to 1 topic
    val kafkaDF: DataFrame = spark.readStream
      .format("kafka")
      .option("kafka.bootstrap.servers", "127.0.0.1:9092")
      .option("subscribe", "test")
      .option("startingOffsets", "earliest") // From starting
      .load()

    kafkaDF.printSchema()

    kafkaDF.selectExpr("CAST(value AS STRING)")
      .writeStream
      .format("console")
      .outputMode("append")
      .start()
      .awaitTermination()
  }

  def main(args: Array[String]): Unit = {
    readFromKafka()
  }

}

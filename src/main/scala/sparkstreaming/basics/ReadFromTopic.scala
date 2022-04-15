package sparkstreaming.basics
import org.apache.spark.sql.{DataFrame, SparkSession, functions}
import org.apache.spark.sql.functions._
import org.apache.spark.sql.streaming.{OutputMode, Trigger}
import org.apache.spark.sql.types.{IntegerType, StructField, StructType}
object ReadFromTopic {

  val spark = SparkSession.builder()
    .appName("Integrating Kafka")
    .master("local[2]")
    .getOrCreate()
  spark.sparkContext.setLogLevel("ERROR")
  import spark.implicits._

  def readFromKafka() = {
    // Subscribe to 1 topic
    val inputStream: DataFrame = spark.readStream
      .format("kafka")
      .option("kafka.bootstrap.servers", "127.0.0.1:9092")
      .option("subscribe", "event123")
      .option("startingOffsets", "earliest") // From starting
      .load()

    inputStream.printSchema()

    val inputKafkaRecordSchema = StructType(
      List(
      StructField("id", IntegerType, true),
       StructField("value", IntegerType, true)
    )
    )
    val inputStreamDF =inputStream
      .selectExpr("CAST(value AS STRING) as message")
      .select(from_json(col("message"),inputKafkaRecordSchema).as("record"))
      .selectExpr(
        "record.*")
      //.withWatermark("eventTime","1 Minute")
      .groupBy("id")
      .agg(sum("value"))
      .writeStream
      .format("console")
      .outputMode(OutputMode.Complete())
      //.trigger(Trigger.ProcessingTime("1 Minute"))
      .start()
      .awaitTermination()

    /*
    val window = inputStream.selectExpr("CAST(value AS STRING)")
      .select(functions.from_json($"value", inputKafkaRecordSchema).as("record"))
      .selectExpr("record.*")
      //.withWatermark("event_time", "25 minutes")
      //.groupBy(functions.window($"event_time", "10 minutes"))
      .writeStream
      .format("console")
      .outputMode("append")
      .start()
      .awaitTermination()
*/
    /*
    val writeQuery = window.sum("count")
      .writeStream
      .option("checkpointLocation", s"/tmp/test-watermark${System.currentTimeMillis()}")
      //.outputMode(OutputMode.Update)
      .outputMode(OutputMode.Append())
      .format("console")
      .start()
      .awaitTermination()


     */
      //.option("truncate", false)
    //aggregation.printSchema()
/*
    kafkaDF.selectExpr("CAST(value AS STRING)")
      .writeStream
      .format("console")
      .outputMode("append")
      .start()
      .awaitTermination()
 */

  }


  def main(args: Array[String]): Unit = {
    readFromKafka()
  }

}

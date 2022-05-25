package sparksamples.performancetuning.util

import org.apache.spark.sql.SparkSession

object DataGenerator extends App{

    val spark:SparkSession = SparkSession.builder()
      .master("local[1]")
      .appName("DataGenerator")
      .getOrCreate()
  import spark.implicits._
    spark.sparkContext.setLogLevel("ERROR")
    def randomInt1to100 = scala.util.Random.nextInt(100)+1
    def idFrom1To10 = scala.util.Random.nextInt(10)+1
    val largeDFRowCount = 10000000
    val smallDFRowCount = 100000
    val byteToMB = 1024*1024
    val byteToGB = byteToMB*1024

  val sc =spark.sparkContext
  val largeDF = sc.parallelize(
    Seq.fill(largeDFRowCount){(idFrom1To10,randomInt1to100,randomInt1to100,randomInt1to100,randomInt1to100)}
  ).toDF("id", "col2", "col3","col4", "col5")
  val smallDF = sc.parallelize(
    Seq.fill(smallDFRowCount){(idFrom1To10,randomInt1to100,randomInt1to100)}
  ).toDF("id", "col2", "col3")

  spark.conf.set("spark.sql.autoBroadcastJoinThreshold", -1)
  spark.conf.set("spark.sql.shuffle.partitions",100)

  val joinedDFWithoutFilter = largeDF.join(smallDF,largeDF("id") === smallDF("id"),"inner" )
  println("Big Dataframe size :"+largeDF.queryExecution.optimizedPlan.stats.sizeInBytes/byteToMB)
  val bytes = spark.sessionState.executePlan(largeDF.queryExecution.logical).optimizedPlan.stats.sizeInBytes
  println("Big Dataframe size :"+bytes/byteToMB)
  //println("output count:"+joinedDFWithoutFilter.count())
  //largeDF.cache()
  //println("caching complete")
  //largeDF.count()
  //joinedDFWithoutFilter.cache.foreach(_ => ())
  val catalyst_plan = largeDF.queryExecution.logical
  val df_size_in_bytes = spark.sessionState.executePlan(
    catalyst_plan).optimizedPlan.stats.sizeInBytes
  println("Big Dataframe size :"+df_size_in_bytes/byteToMB)
  joinedDFWithoutFilter.count()
  val namesStatsCboOff = largeDF.queryExecution.analyzed.stats
  println(namesStatsCboOff)
  Thread.sleep(100000000)




}

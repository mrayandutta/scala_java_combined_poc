package sparksamples.performancetuning.util

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession
import org.apache.spark.storage.StorageLevel

object KryoTest extends App{
  //class which needs to be registered
  case class Person(name: String, age: Int)
  //class which is not registered
  case class PersonNotRegistered(name: String, age: Int)
  //Create spark conf
  private lazy val sparkConf = new SparkConf()
    .setAppName("kyroExample")
    .setMaster("local[*]")
    //.set("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
    //.set("spark.kryo.registrationRequired", "true")
    /*
    .registerKryoClasses(
      Array(classOf[Person],classOf[Array[Person]],
        Class.forName("org.apache.spark.internal.io.FileCommitProtocol$TaskCommitMessage"))
    )
     */

  val spark:SparkSession = SparkSession.builder()
    .config(sparkConf)
    .getOrCreate()
  import spark.implicits._
  spark.sparkContext.setLogLevel("ERROR")
  val personList: Array[Person] = (1 to 9999999)
    .map(value => Person("p"+value, value)).toArray
  val unregisteredPersonList: Array[PersonNotRegistered] = (1 to 9999999)
    .map(value => PersonNotRegistered("p"+value, value)).toArray

  //creating RDD of Person
  val sparkContext = spark.sparkContext
  val personDF = sparkContext.parallelize(personList,5).toDF()
  val unregisteredPersonDF = sparkContext.parallelize(unregisteredPersonList,5).toDF()

  //persisting evenAgePerson RDD into memory
  personDF.persist(StorageLevel.MEMORY_ONLY_SER)
  unregisteredPersonDF.persist(StorageLevel.MEMORY_ONLY_SER)
  println("Completed persist")
  personDF.take(50)
  unregisteredPersonDF.take(50)
  println("Completed take")
  Thread.sleep(100000000)

}

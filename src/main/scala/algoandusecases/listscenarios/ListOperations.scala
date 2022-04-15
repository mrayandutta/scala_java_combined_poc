package algoandusecases.listscenarios

object ListOperations {
  def main(args: Array[String]): Unit = {
    val numbers = List (1,2,3)
    numbers.foreach(println)
    println(numbers(0))
    val changedList = 100 :: numbers
    changedList.foreach(println)
  }

}

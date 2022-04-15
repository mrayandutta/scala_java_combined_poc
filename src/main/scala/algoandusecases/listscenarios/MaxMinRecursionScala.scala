package algoandusecases.listscenarios

object MaxMinRecursionScala {

  def main(args: Array[String]): Unit = {
    val numbers = List(4,22,65,2,19)
    val max = maxRec(numbers,numbers(0))
    println(max)
  }

  def maxRec(numbers : List[Int],max : Int): Int = {

    //println("list size "+numbers.size)
    var result = max
    if (numbers.isEmpty)
    {
      //println("inside if  "+numbers.size)
      return max
    }
    else {
      if (numbers(0) >= result)
      {
        result = numbers(0)
      }
      result= maxRec(numbers.slice(1,numbers.size),result)
    }
    return result
  }

}

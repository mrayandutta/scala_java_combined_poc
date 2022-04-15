package algoandusecases.listscenarios

object SortWithScala {
  def main(args: Array[String]): Unit = {
    var numbers = List(45,7,12,8,26)
    numbers = bubbleSort(numbers,numbers.size)
    println(numbers)

  }

  def bubbleSort(numbers: List[Int],n: Int): List[Int] = {

    if(n==0)
      return numbers

    var changedList = numbers
    println("changedList "+numbers)
    for (i <- 0 to n-1) {
      for (j <- 0 to i) {
        if (j< n-1)
        {
          //println(i)
          val firstItem = changedList(j)
          val secondItem = changedList(j+1)

          if (firstItem > secondItem)
          {
            changedList = changedList.updated(j,secondItem)
            changedList = changedList.updated(j+1,firstItem)
          }
        }

      }


      println("after "+changedList)

  }
    changedList = bubbleSort(changedList,n-1)

    return changedList
  }

}

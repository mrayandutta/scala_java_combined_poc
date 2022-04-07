package basics.listscenarios

object ReverseWithScala {
  def main(args: Array[String]): Unit = {
    var numbers = List(45,7,12,8,26)
    numbers = reverseWithRec(numbers,numbers.size)
    println(numbers)

  }

  def reverseWithRec(numbers: List[Int],n: Int): List[Int] = {
    val size = numbers.size
    var changedList = numbers
    if (n >= size / 2) {
      return changedList

    }
    else
    {
      val firstItem = numbers(n)
      val lastItem = numbers(size - 1 - n)
      changedList = changedList.updated(size - 1 - n, firstItem)
      changedList = changedList.updated(n, lastItem)
      return reverseWithRec(changedList,n)
  }

  }

}

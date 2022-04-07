package basics.forloop

object ForLoopSamples {
  def main(args: Array[String]): Unit = {
    val numbers = List (1,2,5,33,6)
    //numbers.foreach(println)
    //for (x <- numbers) println(x)

    numbers.zip(0 until numbers.size).
      foreach{ case (elem, idx) => println(s"original element: ${elem} => index: ${idx}")}
    numbers.zipWithIndex.foreach{ case (item, index) =>
      println(s"$index => $item")
    }

  }

}

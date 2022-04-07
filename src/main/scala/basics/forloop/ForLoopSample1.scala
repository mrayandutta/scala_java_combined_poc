package basics.forloop

object ForLoopSample1 {
  def main(args: Array[String]): Unit = {
    for (i <-1 to 5)
      println(i)
    for (i <-1 until 5)
      println(i)
  }
}

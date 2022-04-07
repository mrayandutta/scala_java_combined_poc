package basics.operations

object MapSamples {
  def main(args: Array[String]): Unit = {
    val names = List("steve","peter","mark")
    // the long form
    names.map(x=> x.capitalize).foreach(println)
    // the short form
    names.map(_.capitalize).foreach(println)
    val numbers = List(1,2,3)
    numbers.map(_*10).foreach(print)
  }

}

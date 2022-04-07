package basics.operations

object ReduceSample {
  def main(args: Array[String]): Unit = {
    val numbers = List(100,200,43,270)
    val smallest = numbers.reduce((first,second)=> if (first < second) first else second)
    println("Smallest number:"+smallest)
  }

}

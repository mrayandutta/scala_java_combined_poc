package basics.closure

object ClosureSample {
  def main(args: Array[String]) {
    println( "multiplier(1) value = " +  multiplier(1) )
    println( "multiplier(2) value = " +  multiplier(2) )
  }
  var factor = 10
  val multiplier = (i:Int) => i * factor
}

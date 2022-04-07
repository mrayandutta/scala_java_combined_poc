package basics.patternmatching

object PatternMatchingSample {
  def main(args: Array[String]): Unit = {
    println(patternMatching("One"))
  }

  def patternMatching(candidate: String): Int = {
    candidate match {
      case "One" => { println("Its one !! "); return 1}
      case "Two" => { println("Its two !! "); return 2}
      case _ => -1
    }
  }

}

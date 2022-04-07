package basics.currying

object Currying {
  def main(args: Array[String]): Unit = {
    //def function name(argument1, argument2) = operation
    //def function name(argument1)(argument2) = operation
    //def function name(argument1) = (argument2) => operation

    def addUsingCurrying1(a: Int)(b: Int) = a + b;

    def addUsingCurrying2(a: Int) = (b: Int) => a + b;
    println(addUsingCurrying1(10)(20))
    println(addUsingCurrying2(10)(20))

    val addOne = addUsingCurrying1(1) _
    val addOneAndTwo = addOne(2)
    println(addOneAndTwo)

  }

}

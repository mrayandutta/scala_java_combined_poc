package algoandusecases.listscenarios

object SumOfDigits {
  def main(args: Array[String]): Unit = {
    val number = 1234;
    //println(sumOfDigits(number))
    println(sumOfDigitsRec(number,0))

  }
  def sumOfDigits(number:Integer):Integer=
  {
    var sum=0
    var n = number
    while(n>0)
      {
        sum = sum + n%10
        n=n/10
      }
      return sum

  }
  def sumOfDigitsRec(number:Integer,sum:Integer):Integer=
  {
    var localSum = sum
    var localNumber = number

    if(localNumber > 0)
      {
        localSum = localSum + localNumber%10
        localNumber=localNumber/10
        return sumOfDigitsRec(localNumber,localSum)
      }
    else
      return localSum

  }


}

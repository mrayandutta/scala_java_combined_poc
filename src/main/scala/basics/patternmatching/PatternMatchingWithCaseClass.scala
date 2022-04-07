package basics.patternmatching

object PatternMatchingWithCaseClass {

  abstract class Employee
  case class Developer(name:String) extends Employee
  case class Manager(name:String) extends Employee

  def caseClassPatternMatch(employee: Employee): String = {
    employee match {
      case Developer(name) => s"I'm $name, a Developer"
      case Manager("Steve") => s"I'm Steve, a Manager"
      case Manager("Peter") => s"I'm Peter, a Manager"
      case _ => "I'm an unknown type"
    }
  }
  def main(args: Array[String]): Unit = {
    val developer = Developer("David ")
    val manager = Manager("Peter ")
    println(caseClassPatternMatch(developer))
    println(caseClassPatternMatch(manager))
  }

}



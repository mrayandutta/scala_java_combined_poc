package basics.caseclass

object CaseClasses {

  case class Employee(name: String, age: Int, designation: String, salary: Int, ZipCode: Int)

  def main(args: Array[String]): Unit = {
    val employee1 = Employee("Peter", 21, "Software Engineer", 2000, 56798)
    val employee2 = employee1.copy(name = "Steve", age = 30, salary = 3000)
    println("employee1: " + employee1)
    println("employee2: " + employee2)
  }

}

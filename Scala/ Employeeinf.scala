package ScalaHandsOn

object  Employeeinf {
  def main(args: Array[String]) {
    var emp = new Employee(123, "Sara", "London")
    println(emp)
    Employee.saveToDb(emp) //Saving: Sara to db
  }
}

class Employee(id: Int, name: String, address: String) {
  val empId = id
  val n = name
  val place = address
  
  override def toString() =
    this.empId + " " + this.n + " " + this.place
}

//Companion object
object Employee {
  def saveToDb (emp: Employee) {
    println("Saving: " + emp.n + " to db")
  }
}
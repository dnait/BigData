package ScalaHandsOn

object PatternMatching {
  def main(args: Array[String]) {
    println(matchTest(3))              //many
    
    println(matchAgain("two"))         //2
    println(matchAgain("pet"))         //many
    println(matchAgain(1))             //one
    println(matchAgain(200))           //scala.Int
    
    
    //using Case classes
    val alice = new Person("Alice", 23)
    val bob = new Person("Bob", 32)
    val charlie = new Person("Charlie", 32)
    val mike = new Person("Mike", 50)
    
    for (person <- List(alice, bob, charlie, mike)) {
      person match {
        case Person("Alice", 23) => println("A girl")
        case Person("Bob", 32) => println("Hi, Bob")
        case Person(name, age) => println("Age:" + age + ", name: " + name + "?")
      }
    }
    /*
     * A girl
     * Hi, Bob
     * Age:32, name: Charlie?
     * Age:50, name: Mike?
     */

  }
  
  case class Person(name: String, age: Int)
  
  def matchTest(x: Int): String = x match {
    case 1 => "one"
    case 2 => "two"
    case 3 => "many"
  }
  
  def matchAgain(x: Any): Any = x match {
    case 1 => "one"
    case "two" => 2
    case y: Int => "scala.Int"
    case _ => "many"
  }
  
}
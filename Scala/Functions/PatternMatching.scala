package ScalaHandsOn

object PatternMatching {
  def main(args: Array[String]) {
    println(matchTest(3))              //many
    
    println(matchAgain("two"))         //2
    println(matchAgain("pet"))         //many
    println(matchAgain(1))             //one
    println(matchAgain(200))           //scala.Int
  }
  
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
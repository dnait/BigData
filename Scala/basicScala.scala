package ScalaHandsOn

object basicScala {
  def main(args: Array[String]) {
    val s = "I love Yahoo"
    println(s.length)           //12
    println(s.substring(2,4))      //lo
    println(s.replace("o", "x"))    //I lxve Yahxx
    
    //Strings can be dynamically constructed using interpolation. 
    //Scala uses the prefix s for this.
    //Note that usage of s before the string. 
    //The dynamic variables are substituted using the ${variable} syntax.
    val y = "phone"
    val g = s"I want a new ${y}"
    println(g)   //g: String = i want a new phone
    
    val d = sum(1, 10)
    println(d)      //11
    
    val d1 = sum1(2, 10)
    println(d1)
    
    //Anonymous Functions
    val c = (x: Int) => x * x
    println("Result is " + c(10))
    
    val fruits = Array( "apple", "orange", "grapes", "guava")
    println(fruits(2))     //grapes
    
    val a = Map("apple" -> "fruit", "cabbage" -> "vege", "peanut" -> "nut")
    //a: scala.collection.immutable.Map[String,String] = Map(apple -> fruit, cabbage -> vegetable, peanut -> nuts)
    //a("g") will result in exception java.util.NoSuchElementException: key not found g
    
    println(a("apple"))      //fruit
  }
  //Functions
  def sum(a: Int, b: Int): Int = { a + b }
  def sum1(a: Int, b: Int): Int = a + b
  


}
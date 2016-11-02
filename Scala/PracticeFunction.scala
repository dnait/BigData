package ScalaHandsOn

object PracticeFunction {
  def main(args: Array[String]) {
    println(squareIt(2))
    println(cubeIt(3))
    
    val res = transformInt(2, cubeIt)
    val res1= transformInt(3, x => x * x * x)
    val res2 = transformInt(10, x => x / 2)
    val res3 = transformInt(2, x => {val y = x * 2; y * y})
    println(res)
    println(res1)
    println(res2)
    println(res3)
  }
  def squareIt(x: Int) : Int = {x * x}  //function need extra space before Int
  def cubeIt(x: Int) : Int = {x * x * x}
  def transformInt(x:Int, f:Int => Int) : Int = {f(x)}   //result  : Int = 8
  
   // EXERCISE
  // Strings have a built-in .toUpperCase method. 
  //For example, "foo".toUpperCase gives you back FOO.
  // Write a function that converts a string to upper-case, 
  //and use that function of a few test strings.
  // Then, do the same thing using a function literal instead of a separate, named function.
  def UpperCase(x : String) : String = {x.toUpperCase}
  val s1 = UpperCase("hellotoyou")
  println(s1)
  
  def StringToUpperCase(x: String, f:String => String) : String = {f(x)}
  val s2 = StringToUpperCase("hellonewyork",UpperCase)
  println(s2)
  
  def lowerCase(x:String) : String = {x.toLowerCase()}
  def StringToLowerCase(x: String, f: String => String) : String = {f(x)}
  val s3 = StringToLowerCase("YOU MADE MY DAY!", lowerCase)
  println(s3)
  
}

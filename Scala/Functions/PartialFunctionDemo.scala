package ScalaHandsOn

/*
 * A partial function is a function that does not provide an answer for every possible 
 * input value it can be given. It provides an answer only for a subset of possible data, 
 * and defines the data it can handle.
 */

object PartialFunctionDemo {
  def main(args: Array[String]) {
    val divide = (x: Int) => 42 / x
    //divide(0)  java.lang.ArithmeticException: / by zero
    
    
    //anonymous function has no "=" before {}
    //has to be PartialFunction (capitalized)
    val divide1 = new PartialFunction[Int, Int] {
      def apply(x: Int) = 42 / x
      def isDefinedAt(x: Int) = x != 0
    }
    
    println(divide1.isDefinedAt(1))                      //true
    if (divide1.isDefinedAt(1)) println(divide1(1))      //42
    println(divide1.isDefinedAt(0))                      //false
    
    
    //List(41,"cat").map{case i: Int => i * 10} 
    //MatchError: cat (of class java.lang.String), change to collect
    List(41,"cat").collect{case i: Int => i * 10}      //420
    
    
    val fraction: PartialFunction[Int, Int] ={
      case x: Int if x != 0 => 42 / x
    }    
    println(fraction(42))
//    println(fraction(0))        //scala.MatchError: 0 (of class java.lang.Integer)
   
    
    val incAny: PartialFunction[Any, Int] = {
      case x: Int => x + 1
    }
    println(incAny(1))
//    println(incAny("cat"))     //scala.MatchError:  (of class java.lang.String)
    println(incAny.isDefinedAt(41))     //true
    println(incAny.isDefinedAt("cat"))  //false
    
    //"collect" expects a partial function.    
    List(1980, "Dec", 41,"cat").collect(incAny)     // List[Int] = List(1981, 42)
    
    
    //lift also makes a handy case for using partial application 
    //(and teaching or recalling the difference between partial functions 
    //and partial application!):
    val pets = List("cat", "dog", "frog")
    val maybePet = pets lift _    //life + space + _    Int => Option[String] = <function1>
    println(maybePet(0))      //Some(cat)
    println(maybePet(42))      //None
    
    //You can "lift" a method invocation into a function. 
    //This is called eta-expansion (thanks to Ben James for this)
    val l = List(80,41, "cat")
    val lx = l lift _
    //l.map(_ * 10) error
    
    Seq(1,2,3).lift(2)        //Option[Int] = Some(3)
    
    Seq(1,2,3).lift(22)       //Option[Int] = None

    Seq(1,2,3).lift(2).getOrElse(-1)      //Int = 3

    Seq(1,2,3).lift(22).getOrElse(-1)      //Int = -1

  }
  
}
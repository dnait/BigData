package ScalaHandsOn

object Practice {
   def main(args: Array[String]) {
     val hello:String = "HELLO"
      println(hello)
      
      var concate:String = hello //cannot be val
      concate=hello + "end"
      println(concate)
      
      val One:Int = 1
      val flag:Boolean = true
      val LetterA:Char = 'a'
      val pi:Double = 3.14159265
      val piSinglePrecision:Float = 3.14159265f
      val bigNumber:Long = 1234567890l 
      val smallNumber:Byte = 127
      
      val isGreater = 1 > 2
      val isLesser = 1 < 2
      
      if (1 > 3) print("Impossible") else print("make sense")
      if (1 > 3) {
        print("Impossible again")
      } else {
        println("Makes sense again")
      }
      
      val num = 3
      num match{
        case 1 => println("One")
        case 2 => println("Two")
        case 3 => println("Something else")
      }
      
      for (x <- 1 to 4) {
        val square = x * x
        println(square)
      }
      
      var x = 5
      while(x >= 2) {
        print(x)
        x -= 1       //Scala cannot support x--
      }
      while (x >= 2) {print(x); x -= 1}
      
      x = 0
      do {
        println(x)
        x += 1
       }while (x <= 2)
     //or 
      do {println(x); x += 1}while (x <= 3)   //";" is required
      
      //Expressions
      //Return the final value in a block automatically
      {val x = 11; x + 20}
      println({val x =10; x + 20})
      
   // Write some code that prints out the first 10 values of the Fibonacci sequence.
	 // This is the sequence where every number is the sum of the two numbers before it.
	 // So, the result should be 0, 1, 1, 2, 3, 5, 8, 13, 21, 34
      
      var a1 =0  //cannot use val
      var a2 = 1
      println(a1); println(a2)
      for (x <- 2 to 9) {
        var a3 = a1 + a2
        println(a3)
        a1 = a2
        a2 = a3             
      }      
    }
}

package ScalaHandsOn

object Practice {
   def main(args: Array[String]) {
     val hello:String = "HELLO"
      println(hello)
      
      var concate:String=hello
      concate=hello+"end"
      println(concate)
      
      val One:Int=1
      val flag:Boolean=true
      val LetterA:Char='a'
      val pi:Double= 3.14159265
      val piSinglePrecision:Float = 3.14159265f
      val bigNumber: Long = 1234567890l 
      val smallNumber:Byte = 127
      
      val isGreater= 1>2
      val isLesser = 1<2
      
      if (1>3) print("Impossible") else print("make sense")
      if (1>3) {
        print("Impossible again")
      } else {
        print("Makes sense again")
      }
      
      val num =3
      num match{
        case 1=>println("One")
        case 2=>println("Two")
        case 3=>println("Something else")
      }
      
    }
}
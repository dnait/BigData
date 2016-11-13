package ScalaHandsOn

object RandomGenerator {
  def main(args: Array[String]) {
    
    val ran = scala.util.Random.nextInt        //-1798253479
    
    val ran1 = scala.util.Random.nextInt(10)    //3
    
    //generate a random number between (min and max)
    val max = 20
    val min = 1
    val randomNum = scala.util.Random.nextInt((max - min) + min);        //16..8..
    println(randomNum)
    
    //generate a random Float
    val ranFloat = scala.util.Random.nextFloat      //Float = 0.035637796
    
    //generate a random Double
    val ranDouble = scala.util.Random.nextDouble    //Double = 0.5338066086578603
    
    //generate a random char
    val ranChar = scala.util.Random.nextPrintableChar  //could be 1, or z or [ or @
    val ranCharList = List.fill(10)(scala.util.Random.nextPrintableChar)    //List(J, <, *, _, N, l, 5, ., b, @)
    
         
    //How to randomly generate 10 random Integers bellow 100
    val list = List.fill(10)(scala.util.Random.nextInt(100))
    //List(55, 25, 95, 36, 11, 20, 74, 43, 87, 60)
    
    val seq = Seq.fill(10)(scala.util.Random.nextInt(100))
    //Seq[Int] = List(59, 84, 78, 11, 43, 72, 47, 26, 25, 69)
    
    
    //create a random range
    val range01 = 0 to scala.util.Random.nextInt(10)
    println(range01)      //Range(0, 1) or Range(0, 1, 2, 3, 4, 5, 6, 7, 8)
    
    
    //yield was used for complex case
    val r = scala.util.Random
    for (i <- 0 to r.nextInt(10)) yield r.nextPrintableChar
    //possible results:
    //scala.collection.immutable.IndexedSeq[Char] = Vector(G, +, {)
    //scala.collection.immutable.IndexedSeq[Char] = Vector(K)
    
    //Attention: let's just yield a collection that is identical to the collection we are looping over
    
    val a = Array(1, 2, 3, 4, 5)       //a: Array[Int] = Array(1, 2, 3, 4, 5)
    for (e <- a if e > 2) yield e      //Array[Int] = Array(3, 4, 5)

    //if nothing, then it is Vector
    for (i <- 1 to 5) yield i * 2     //IndexedSeq[Int] = Vector(2, 4, 6, 8, 10)
    
    
    
  }
}
package ScalaHandsOn

object yieldDemo {
  
//scala> (for (i <- 1 to 5) yield {i * 2}).sum
//res129: Int = 30
  
  def main(args: Array[String]) {
    println(evalPolyYield(Array(3,2,-5),1))
    println(evalPoly(Array(3,2,-5),1))
    
    
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
    
    //calculate for loop yield sum
    val sum = (for (i <- 1 to 5) yield {i * 2}).sum
    println(sum)
    //or combine into one sentense
    println((for (i <- 1 to 5) yield {i * 2}).sum)
    
  }
  //delete sum completely, use yield to replace sum.
  //But curly braces
  def evalPolyYield(coeffs: Array[Double], x: Double): Double = {
    var sum = 0.0   //sum cannot be sum = 0
    (for (i <- coeffs.indices) yield {
      coeffs(i) * math.pow(x, coeffs.length - 1 - i)
    }).sum

  }
  
  def evalPoly(coeffs: Array[Double], x: Double): Double = {
    var sum = 0.0   //sum cannot be sum = 0
    for (i <- coeffs.indices) {
      sum += coeffs(i) * math.pow(x, coeffs.length - 1 - i)
    }
    sum
  }
  
}
/*ans:
 * 0.0
 * 0.0
 */

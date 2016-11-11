package ScalaHandsOn

object yieldDemo {
  
  def main(args: Array[String]) {
    println(evalPolyYield(Array(3,2,-5),1))
    println(evalPoly(Array(3,2,-5),1))
    
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

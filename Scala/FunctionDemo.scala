package ScalaHandsOn

object FunctionDemo {
  def main(args: Array[String]) {
    val m: Int = add(1,2)
    println(m)      //3
    
    val n: Int = fun(10)
    
    //There is no explicit “return” statement! 
    //The value of the last expression in the body is automatically returned
    println(n)      //30  Because a will not be changed
    
    val i = 3
    val p = if ( i > 0) -1 else -2
    val q = if (true) "No.1" else "No.2"
      
    println(p)      //-1
    println(q)      //No.1
    
    println(errorMsg(2))    //Permission denied
    
    val b = sum1(10)
    println(b)      //55
    
    var r = sum2(5,0)
    println(r)    //15
    
    println(sum3(identity, 1, 10))  //55
    println(sum3(sqr,1, 10))    //385
    println(sum3(cube, 1, 10))    //3025
       
  }
  
  def add(a: Int, b: Int): Int = a + b
  
  def fun(a: Int): Int = {
    a + 1   
    a - 2
    a * 3
  }
  
  def errorMsg(errorCode: Int) =errorCode match {
    case 1 => "File not found"
    case 2 => "Permission denied"
    case 3 => "Invalid operation"
  }
  
  //sum n + (n - 1) + (n - 2) + (n - 3) + ... + 0
  def sum1(n: Int): Int = if (n == 0) 0 else n + sum1(n - 1)
  
  //tail recursion
  def sum2(n: Int, acc: Int): Int =
    if (n == 0) acc else sum2(n - 1, acc + n)
    
  def identity(x: Int) = x
    
  def sqr(x: Int) = x * x
  def cube(x: Int) = x * x * x
  
  def sum3(f: Int => Int, a: Int, b: Int): Int =
    if (a == b) f(a) else f(a) + sum3(f, a + 1, b)
  
  def sumSimple(a: Int, b: Int): Int = 
    if (a == b) a else a + sumSimple(a + 1, b)
    
    
  def sumSquare(a: Int, b: Int): Int = 
    if (a == b) sqr(a) else sqr(a) + sumSquare(a + 1, b)
    
  def sumCubes(a: Int, b: Int): Int = 
    if (a == b) cube(a) else cube(a) + sumCubes(a + 1, b)
  
}
package ScalaHandsOn

object Factor {
  def main(args: Array[String]):Unit={
    println(factorial(4))
  }
  
  def factorial(x:Int):Int= {
    def cal(pre:Int, cur:Int):Int = {
      if (cur == 0) pre else cal(pre * cur, cur - 1)
    }
    cal(1,x)
  }
}
//ans: 24
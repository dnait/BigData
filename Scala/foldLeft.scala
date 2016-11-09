package ScalaHandsOn

object foldLeft {
  def main(args: Array[String]) {
    val list = List(1,2,3,4)
    println(list.sum)        //10
    println(sum1(list))      //10
    println(sum2(list))      //10
    
    
  }
  
  def sum1(list: List[Int]): Int = list.foldLeft(0)(_+_)
  def sum2(list: List[Int]): Int = list.foldLeft(0)((a,b) => a + b)
}


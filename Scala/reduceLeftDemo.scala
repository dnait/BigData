package ScalaHandsOn

/*
 * The reduceLeft method words by applying the function/operation you give it, 
 * and applying it to successive elements in the collection. 
 * The result of the first comparison is used in the second comparison,
 * and so on. It works from left to right, beginning with the first element in the collection
 */


object reduceLeftDemo {
  def main(args: Array[String]) {
    val a = Array(20, 12, 6, 15, 2, 9)
    val res1 = a.reduceLeft(_+_)    //64
    println(res1)
    
    val res2 = a.reduceLeft(_*_)    //388800
    println(res2)
    
    val res3 = a.reduceLeft(_ min _)    //2
    println(res3)
    
    val res4 = a.reduceLeft(_ max _)    //20
    println(res4)
    
    
    //Use a function
    val func = (x: Int, y: Int) => x max y
    val res5 = a.reduceLeft(func)
    println(res5)
    
    //Use more complex function
    val findMax = (x: Int, y: Int) => {
      val winner = x max y
      println("compared %d to %d, %d was larger".format(x,y,winner))
      winner
    }
    println(a.reduceLeft(findMax))
    
    val b = Vector("al", "hannah", "emily", "christina", "aleka")
    b.reduceLeft((x,y) => if (x.length > y.length) x else y)
    println(b)  //Vector(al, hannah, emily, christina, aleka)
    //so Vector is immutable
    
    val b1 = b.reduceLeft((x,y) => if (x.length > y.length) x else y)
    println(b1)
    
   // val b2 = b.reduceLeft((x,y) => x.length > y.length) wrong Boolean cannot match String
    

    
    
  }
}
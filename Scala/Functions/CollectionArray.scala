package ScalaHandsOn

//About Array and List
object Collection1{

  def main(args: Array[String]): Unit = {
    val numbers = Array(1, 2, 3, 4, 5, 1, 2, 3, 4, 5)
    val first = numbers(0)
    numbers(3) = 100
    println(numbers.map(_*2).deep.mkString(" "))
    val numbersReverse = numbers.reverse
    val seqReversed: Seq[Int] = numbers.reverse
    //seqReversed: Seq[Int] = WrappedArray(5, 4, 3, 2, 1, 5, 4, 3, 2, 1)
    
    //create Array
    val arr = new Array[Int](3)
    arr(0) = 100
    println(arr.deep.mkString(" "))
    
    //multiple type in one array will makes this all Double,i.e, Array[Double]
    val a = Array(1, 2.0, 33D, 400L)
    val a1 = Array[Number](1, 2.0, 33D, 400L)
    
    println(a.deep.mkString(" "))
    println(a1.deep.mkString(" : "))
    
    a(0) = 100
    a.update(1,200)
    
    //But I want to override the type    
    //manually override the type
    println(a.deep.mkString(","))
      
    
    val fruits = new Array[String](3)   
    fruits(0) = "Orange"
    fruits(1) = "Banana"
    fruits(2) = "Apple"
    
    //Sorting Arrays
    //Sorting.quickSort can also sort arrays with the base numeric types like Double, Float, and Int
    scala.util.Sorting.quickSort(fruits)
    println("QuickSort => " + fruits.deep.mkString(","))
   
    // var fruits1: Array[String] = _  is wrong, 
    //local variables need to be initialized
    
    
    //Use .range(start, end[exclusive]) to create a large number of elements in the array
    val range1 = Array.range(1, 10)
    val range2 = Array.range(1, 10, 2)
    val range3 = Array.fill(3)("foo")
    
    
    //Use Array.ofDim to create a multidimensional array. 
    val rows = 2
    val cols = 3
    val matrix = Array.ofDim[String](rows, cols)
    matrix(0)(0) = "a"
    matrix(0)(1) = "b"
    matrix(0)(2) = "c"
    matrix(1)(0) = "d"
    matrix(1)(1) = "e"
    matrix(1)(2) = "f"
    
    //print matrix
    for { i <- 0 until rows
          j <- 0 until cols  
    } println(s"($i)($j) = ${matrix(i)(j)}")
    
   
    //more dimensions
    //Don't forget .ofDim[Int] or .ofDim[String]
    val x, y, z = 3
    val matrix3 = Array.ofDim[Int](x,y,z)
    for {
      i <- 0 until x
      j <- 0 until y
      k <- 0 until z
    } println(s"($i)($j)($k) = ${matrix3(i)(j)(k)}")
    
    
    val l = List("apple", "oh", "app", "apple", "oh","abcde")
    val nums = List(1,1,2,2,3,3,4,4,5,5)
    println(nums.partition(_%2 == 0))
    println(nums.grouped(2).toList)
    println(nums.grouped(2).toBuffer)
    
  }

}
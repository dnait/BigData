package ScalaHandsOn

object LC1TwoSum {
  def main(args: Array[String]) {
    var myList = Array(11, 7, 2, 15)
    val target = 9
    val result: Array[Int] = TwoSum(myList,target)
    
    val seq = (1 to 10).toList
    println( twoSum2(seq, 13) )
    println( twoSum2(seq, 27) )

    //mkString will convert collections (including Array) element-by-element to string representations.
    //println(a.mkString(" "))
    print("result= " + result.mkString(","))
    
    println("test 1 is " + twoSum2(myList, target))
  }
   
  def TwoSum(x: Array[Int], target: Int) : Array[Int] = {
    var res = new Array[Int](2)     
    var maps = collection.mutable.Map[Int, Int]()
    
    for ( i: Int <-  x.indices) {
      var j = target - x(i)
      if (maps.contains(j)) {
        res(0) = maps(j)
        res(1) = i
      } else 
        maps += (x(i) -> i)
    }    
    return res
  }
  
   def twoSum2(as: List[Int], sum: Int, cache: Map[Int, Int] = Map.empty): Option[(Int, Int)] =
    as match {
      case Nil => None
      case a :: tail =>
        cache.get(a) match {
          case Some(b) => Some(a, b)
          case _ => twoSum2(tail, sum, cache.updated(sum - a, a))
        }
    }
   
  def twoSum3(arr: Array[Int], target: Int): Boolean = {
    if(arr == null || arr.length == 0) false
	  val hs = new java.util.HashSet[Int]
	  for(ele <- arr) if(hs.contains(target - ele)) return true else hs.add(ele)
	  false
	  
  }

}

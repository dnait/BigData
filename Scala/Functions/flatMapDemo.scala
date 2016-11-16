package ScalaHandsOn

/*
 * Because flatMap treats a String as a sequence of Char, 
 * it flattens the resulting list of strings into a sequence of characters (Seq[Char]). 
 * flatMap is a combination of map and flatten
 */

object flatMapDemo {
  def main(args: Array[String]) {
    
    val a1 = List(1,2,3)
    val a2 = List(4,5,6)
    println(List(a1,a2))      //List[List[Int]] = List(List(1, 2, 3), List(4, 5, 6))
    println(List(a1,a2).map(a => a))   //List[List[Int]] = List(List(1, 2, 3), List(4, 5, 6))  
    
    //An important thing to understand about flatMap is that anything 
    //that looks like an empty array will disappear, like so:
    val afterflatMap = List(None, Some(1), None, Some(2)).flatMap(x => x)
    println(afterflatMap)     //List[Int] = List(1, 2)
    
    
    var l = List[Int](1,2,3,4,5)
    l.map(_*2)
    
    
    def f1(x: Int) = if (x > 2) x else None   //also return Option[Int]
        
    //But .flatten will help to return the original type
    def f(x: Int):Option[Int] = if(x > 2) Some(x) else None

    //  l = l.map(x => f(x)) failed   since List[Option] = List[Int]   
    l=l.map(x => f(x)).flatten
    println(l)                       //List(3, 4, 5)
    
    
    //map vs flatMap
    def g(v: Int) = List( v - 1, v, v + 1) 
    println(l.map(x => g(x)))        //List(List(2, 3, 4), List(3, 4, 5), List(4, 5, 6))   
    println(l.flatMap(x => g(x)))    //List(2, 3, 4, 3, 4, 5, 4, 5, 6)
    
    
    //get key or value by using flatMap tuples
    val m = Map(1 -> "one", 2 -> "two", 3 -> "three")
    println(m.toList)                      //List[(Int, String)] = List((1,one), (2,two), (3,three))
    println(m.flatMap(e => List(e._2)))    //List(one, two, three)
    println(m.flatMap(e => List(e._1)).sum) //List(1,2,3).reduceLeft(_+_) = 6
    println(m.flatMap(e => List(e)))      //Map(1 -> one, 2 -> two, 3 -> three)
    //Cannot be m.flatMap(e => e)
	  //<console>:error: type mismatch;
    //found   : (Int, String)
    //required: scala.collection.GenTraversableOnce[?]
    //    m.flatMap(e => e)
    
    
    //Attention: tuple index starts from 1, NOT 0
    val t = (1,3,5,7,9,10)
    println(t._3)                  //Int = 5
    println(t._5)                  //Int = 9
    
    
    //Map vs flatMap
    val m1 = Map(1 -> 2, 2 -> 4, 3 -> 6, 4 -> 8)    
    val m2 = m1.mapValues(_*2)      //immutable.Map[Int,Int] = Map(1 -> 4, 2 -> 8, 3 -> 12, 4 -> 16)
    //
    val m3 = m1.mapValues(f(_))     //immutable.Map[Int,Option[Int]] = Map(1 -> None, 2 -> Some(4), 3 -> Some(6), 4 -> Some(8))

    
    //Use flatMap to swap key value
    //val m1 = Map(1 -> 2, 2 -> 4, 3 -> 6, 4 -> 8)  
    def h(k: Int, v: Int) = if (v > 2) Some(k -> v) else None
    println(m1.flatMap(e => h(e._2, e._1)))    // Map(6 -> 3, 8 -> 4)
    
    
    //map key value swap with flatMap, Don't miss match with tuples
    //PartialFunction, which in scala is most easily defined as a case statement.
    //val m1 = Map(1 -> 2, 2 -> 4, 3 -> 6, 4 -> 8) 
    def p(k: Int, v: Int) = v -> k //return tuple, will go wrong m1.flatMap{case (k,v) => l(k,v)}
   //v->k，will return tuple2的function which is a implicit conversion
    
    
    //need to return Map[Int,Int]
    def p1(k: Int, v: Int) = Map(v -> k)
    println(m1.flatMap{case (k,v) => p1(k,v)})  //Map(2 -> 1, 4 -> 2, 6 -> 3, 8 -> 4)
    
      
    
    //  def f(x: Int):Option[Int] = if(x > 2) Some(x) else None
    m1.filter(e => f(e._2) != None)             // Map(2 -> 4, 3 -> 6, 4 -> 8)
    m1.filter{ case(k,v) => f(v) != None}       // Map(2 -> 4, 3 -> 6, 4 -> 8)    
    m1.filter{case (k,v) => f(v).isDefined}     //Map(2 -> 4, 3 -> 6, 4 -> 8)
 
    
    //ReduceLeft(double+), 0.5 difference by flatMap,very smart to use 
    List(1, 2, 3).flatMap(x => List(x, x + 0.5))   //List(1.0, 1.5, 2.0, 2.5, 3.0, 3.5)
    List(1, 2, 3).map(x => List(x, x + 0.5)).reduceLeft(_ ++ _)   //List[Double] = List(1.0, 1.5, 2.0, 2.5, 3.0, 3.5)
    
    //reduceLeft(_++_) can merge the list
    
    
    
    val fruits = Seq("apple", "banana", "orange")
    fruits.map(_.toUpperCase)       //Seq[String] = List(APPLE, BANANA, ORANGE)
    fruits.flatMap(_.toUpperCase)   //List(A, P, P, L, E, B, A, N, A, N, A, O, R, A, N, G, E)
    
    //flaMap = Map + flatten
    val mapResult = fruits.map(_.toUpperCase)
    val res = mapResult.flatten
    
    val strs = Seq("1","2","foo","3","bar")
    println(strs.map(toInt))        //List(Some(1), Some(2), None, Some(3), None)
 
    def toInt(s: String): Option[Int] = {
      try {
        Some(Integer.parseInt(s.trim))
      } catch {
        //catch exception to catch null 's'
        case e: Exception => None
      }
    }
  }
}
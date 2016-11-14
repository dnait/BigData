package ScalaHandsOn

object AdvancedDemo {
  def main(args: Array[String]){
    val names = List("Al", "Christina", "Kim")
    val firstTen = (1 to 10).toList
    val fiveToFifteen = (5 to 15).toList
    val evens = List(2, 4, 6)
    val odds = List(1, 3, 5)
    
    evens.exists(_ > 2)           // true
    evens.find(_ > 2)             //find the fist ele > 2 , return Option[Int] = Some(4)
    evens.forall(_ >= 2)          //true
    List("Joe","Kim").flatten     //List[Char] = List(J, o, e, K, i, m)
    List("Joe","Kim").flatMap(_.toUpperCase)    //List[Char] = List(J, O, E, K, I, M)
    
    //groupBy return Map[Boolean, List]
    firstTen.groupBy(_ > 5)
    //Map[Boolean,List[Int]] = Map(false -> List(1, 2, 3, 4, 5), true -> List(6, 7, 8, 9, 10))
    
    //try to groupBy and change the values, all values are * 10
    firstTen.groupBy(_ > 5).transform((k, v) => v.map(_*10)) 
    //Map[Boolean,List[Int]] = Map(false -> List(10, 20, 30, 40, 50), true -> List(60, 70, 80, 90, 100))
    
    
    //how to make the >5 part * 10
    (firstTen.groupBy(_ > 5) - false).transform((k, v) => v.map(_*10)) 
    //Map[Boolean,List[Int]] = Map(true -> List(60, 70, 80, 90, 100))
    
    (firstTen.groupBy(_ > 5) - false).transform((k, v) => v.map(_*10)).foreach(x => println(x + " "))
    //(true,List(60, 70, 80, 90, 100)) 
    
    //find all the words has length 6
    val cats = List("Tiger", "Lion", "Puma", "Leopard", "Fold",
                  "Jaguar", "Cheetah", "Bobcat")
    cats.filter(_.length ==6)      //List(Jaguar, Bobcat)
    
    //find high frequencies words, and tell me the length
    val groupedLength = cats.groupBy(_.length).mapValues(_.size)  // Map(5 -> 1, 4 -> 3, 7 -> 2, 6 -> 2)
    val sortedbyValue_groupedLength = List(groupedLength.toSeq.sortWith(_._2 > _._2):_*).take(1)
    //List[(Int, Int)] = List((4,3), (7,2), (6,2), (5,1))
    
    println(sortedbyValue_groupedLength.take(1))   //List[(Int, Int)] = List((4,3)) 4length has the most words
   

    firstTen.grouped(2)                     //non-empty iterator
    firstTen.grouped(2).toList              //List(List(1, 2), List(3, 4), List(5, 6), List(7, 8), List(9, 10))
    firstTen.hasDefiniteSize                //true
    firstTen.toStream.hasDefiniteSize       //false
    firstTen.indexOf(5)                     //Int = 4
    firstTen.indexOfSlice(Seq(5,6,7))       //Int = 4
    firstTen.indexWhere(_ == 9)             //Int = 8
    firstTen.indices                        //Range(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    
    List(1,2,10).last                       //Int = 10
    List(1,1,2,2,1,1,3,3).lastIndexOfSlice(Seq(1,1))     //4
    List(1,1,2,2,1,1,3,3).lastIndexWhere(_ == 1)         //5
    List(1,2,10).lastOption                              //Option[Int] = Some(10)

    firstTen.reduce(_ + _)             // 55
    firstTen.reduceLeft(_ - _)         // -53
    firstTen.reduceRight(_ - _)       // Int = -5
    
    //scanLeft(10)(_+_)
    
    
    //segmentLength (predicate, index)
    //The length of the longest uninterrupted segment of 
    //elements in xs, starting with xs(i), that all satisfy the predicate p.

    List(1,2,3,4,5,4,3,2,1).segmentLength(_ > 3, 0)   // 0
    List(1,2,3,4,5,4,3,2,1).segmentLength(_ > 3, 1)   // 0
    List(1,2,3,4,5,4,3,2,1).segmentLength(_ > 3, 2)   // 0
    List(1,2,3,4,5,4,3,2,1).segmentLength(_ > 3, 3)   // 3
    List(1,2,3,4,5,4,3,2,1).segmentLength(_ > 3, 4)   // 2
    
    //slide
    firstTen.sliding(2).toList    //List(List(1, 2), List(2, 3), List(3, 4), List(4, 5), List(5, 6), List(6, 7), List(7, 8), List(8, 9), List(9, 10))
    firstTen.sliding(4).toList    //List(List(1, 2, 3, 4), List(2, 3, 4, 5), List(3, 4, 5, 6), List(4, 5, 6, 7), List(5, 6, 7, 8), List(6, 7, 8, 9), List(7, 8, 9, 10))
  
    firstTen.sliding(2,2).toList  //List[List[Int]] = List(List(1, 2), List(3, 4), List(5, 6), List(7, 8), List(9, 10))
    
    firstTen.sliding(2,3).toList  //List(List(1, 2), List(4, 5), List(7, 8), List(10))
  
    firstTen.sliding(2,4).toList  //List(List(1, 2), List(5, 6), List(9, 10))
    
    firstTen.span(_ < 5)   //same as firstTen.partition(_ < 5)
    //(List[Int], List[Int]) = (List(1, 2, 3, 4),List(5, 6, 7, 8, 9, 10))
    
    
    //Seq can .update like Vector
    Seq(1,2,3).updated(0,10)       //Seq[Int] = List(10, 2, 3)
    
    
    
    firstTen.withFilter(_ > 5)  //scala.collection.generic.FilterMonadic[Int,List[Int]] = scala.collection.TraversableLike$WithFilter@3925bd0f
    
    firstTen.withFilter(_ > 5).map(_ * 1)   //List[Int] = List(6, 7, 8, 9, 10)
    
  }
}
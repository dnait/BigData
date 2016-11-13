package ScalaHandsOn

object SetDemo {
  def main(args: Array[String]) {
    
    //create set
    var set = scala.collection.mutable.Set[Int]()
    
    //add elements
    set += 1
    set += (2,3)
    set += 2
    set ++= Vector(4,5)
    //scala.collection.mutable.Set[Int] = Set(2, 1, 4, 3, 5)
    
    
    //.add(x) return Boolean 
    set.add(6)        //true, Set(1, 5, 2, 6, 3, 4)
    set.add(5)        //false
    
    set.contains(5)    //true  
    
    //delete
    set -= 1           //scala.collection.mutable.Set[Int] = Set(5, 2, 6, 3, 4)
    set --= Array(4,5)  //scala.collection.mutable.Set[Int] = Set(2, 6, 3)
    
    //.remove(x) return Boolean
    println(set.remove(2))          //true
    
    //retain : keeps only those elements in xs that satisfy predicate p.
    //like delete function
    println(set.retain(_ > 2))   //only print()
    println(set)          //but set = Set(6, 3)
    
    
    
    
  }
}
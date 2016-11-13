package ScalaHandsOn

import scala.collection.SortedSet

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
    
    
    //merge usign ++
    val positive = Set(10, 11, 15)
    val negative = Set(-2, -3, -15)
    println(positive ++ negative)        //immutable.Set[Int] = Set(10, -3, -15, 11, -2, 15)
    
    
    //Intersect is Case Sensitive
    val codes1 = Set("java", "python", "c++", "scala", "SQL")
    val codes2 = Set("Java", "Python","abc", "bcd", "efd")
    println(codes1.intersect(codes2))        //Set()
    
    //Set use map to convert words to LowerCase, then compare
    println(codes1.map(_.toLowerCase).intersect(codes2.map(_.toLowerCase)))   //Set(java, python)
    
    
    //use SortedSet
    val s = scala.collection.SortedSet(10,4,8,2)
    println(s)      //TreeSet(2, 4, 8, 10)
    
    val s1 = scala.collection.SortedSet("cherry", "kiwi", "apple")
    println(s1)     //TreeSet(apple, cherry, kiwi)
    
    //use LinkedHashSet saves elements in the order in which they were inserted
    var s2 = scala.collection.mutable.LinkedHashSet(10, 4, 8, 2)
    println(s2)
    
    
    //Customized object sort
    //need to import scala.collection.SortedSet    
     val mike = new Person("Mike")
     val chris = new Person("Chris")
     val molly = new Person("molly")
     val tyler = new Person("Tyler")
     val s3 = SortedSet(molly, tyler, chris,mike)
     println(s3)    //TreeSet(Chris, Mike, Tyler, molly)
    
  }
  
}

class Person(val name: String) extends Ordered [Person] {
  override def toString = name
  //return 0 if the same, negative if this < that, positive if this > that
  def compare(that: Person) = {
    if (this.name == that.name)
      0
    else if (this.name > that.name)
      1
    else 
      -1
  }

}
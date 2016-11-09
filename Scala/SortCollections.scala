package ScalaHandsOn

object SortCollections {
  def main(args: Array[String]) {
    val a = List(10,5,8,1,7).sorted
    //a: List[Int] = List(1, 5, 7, 8, 10)

    val b = List("banan", "apple","pear","grapes")
    //b: List[String] = List(banan, apple, pear, grapes)

    List(10,5,8,1,7).sortWith(_<_)
    //res0: List[Int] = List(1, 5, 7, 8, 10)

    List(10,5,8,1,7).sortWith(_>_)
    //res2: List[Int] = List(10, 8, 7, 5, 1)

    b.sortWith(_.length < _.length)
    //res4: List[String] = List(pear, banan, apple, grapes)

    b.sortWith(_.length > _.length)
    //res5: List[String] = List(grapes, banan, apple, pear)
  
    val c = b.sortWith(sortByLength)
    println("sortByLength = " + c)
    //sortByLength = List(grapes, banan, apple, pear)
    
    
    val ty = new Person("Tyler")
    val al = new Person("Al")
    val paul = new Person("Paul")
    val dudes = List(ty, al, paul)
    //println(dudes.sorted)  compile error
    
    //This means that you can’t use sorted with the Person class as it’s written, 
    //but you can write a simple anonymous function to sort the Person elements 
    //by the name field using sortWith:
    
    val sortedDudes = dudes.sortWith(_.name < _.name)
    val sortedDudes1 = dudes.sortWith(_.name > _.name)
    
    println(sortedDudes)
    println(sortedDudes1)
  
  }
  
  def sortByLength(s1: String, s2: String) = {
    s1.length > s2.length
  }
  
  

  
}

class Person(var name: String) {
  override def toString = name
}


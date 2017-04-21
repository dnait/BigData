package ScalaHandsOn

object ListArrayTailRecursion {
  def main(args: Array[String]) {
    val listA = List(1,2,3)
    val array = Array(1,2,3)
    val first = array(0)
    val listB = array.toList
    
    val head = listA.head   //return 1
    println("head = " + head)
    val tail = listA.tail   //return List(2,3)
    println("tailoflistA = " + tail)
    
    //calculate factorial
    println(cal(3))  
    
    val l1 = listA.map(a => a + 1)
    println(l1)
    
    val l2 = listA.map(a => cal(a))
    println(l2)
    
    sumList(listA)
    
    // Make a list via the companion object factory
    val days = List("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")

    // Make a list element-by-element in a new List()
    val when = "AM" :: "PM" :: List()  //output: List(AM, PM)
    //val when2 = "AM"::"PM" ERROR- value :: is not a member of String
    
    println(days)
    println(when)
    println("sumListTailRec")
    println(sumListTailRec(listA, 0))

    // Pattern match
    days match {
      case firstDay :: otherdays =>
        println("The first day of the week is: " + firstDay)
      case List() =>
        println("There don't seem to be any week days.")
    }
    
    //:: put the ele on the head of the list
    val mainList = List(3, 2, 1)
    val with4 =    4 :: mainList  // re-uses mainList, costs one :: instance
    val with42 =   42 :: mainList // also re-uses mainList, cost one :: instance
  
    println(with4)
    println(with42)
    
  }

  
  
  //have to have "="
   def cal(x: Int): Int={
      if (x <= 0) 1 else x * cal(x - 1)
   }
   
   //standard recursion
   def sum(ls: List[Int]): Int = {
     ls match {
       case x::tail => x + sum(tail)
       case Nil => 0
     }
   }
   
   def sumList(ls: List[Int]): Int = {
     //tailrec
     def inner(xs: List[Int], accum: Int): Int = {
       xs match {
         case x :: tail => inner(tail, accum + x)
         case Nil => accum
       }
       
     }
     inner(ls,0)
  }
   
   def sumListTailRec(ls: List[Int], sum: Int): Int = {
     if (ls.isEmpty) 0 else sum + ls.head + sumListTailRec(ls.tail, sum)
   }
}

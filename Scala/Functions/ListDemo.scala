package ScalaHandsOn

/*
 * List versus Vector. 
 * In my testing, a Vector is slower than a List for small element counts.
 * The Vector is an immutable collection similar to a list.
 */
 
object ListDemo {
  def main(args: Array[String]) {
    val list1 = 1 :: 2 :: 3 :: Nil
    
    // A list cannot be updated.
    // error: value update is not a member of List[String]
    //list1(0) = 200
    //^
    //one error found
    
    //empty List
    val emptyList1: List[Nothing]= List()
    
    //cannot just initialize like this, or when we add new item, the list cannot recoginze
    //cannot emptyList2 += "cat" fail even var emptyList2
    val emptyList2 = List()
    val emptyList3 = "cat" :: emptyList2
    
      //use List.empty to initialize, and also use var
    var strs1 = List.empty[String]
    strs1 = "cat" :: strs1
    println(strs1)        //List(cat)
    
    

    
    //remove duplicates with toSet.toList or .distinct
        //use .distinct
    val furniture = List("chair", "bed", "table", "table", "couch")
    println(furniture.distinct)        //List(chair, bed, table, couch)
    
        //use .toSet.toList
    println(furniture.toSet.toList)    //List(chair, bed, table, couch)
      
        //Convert to lowercase then get distinct strings
    val codes = List("abC", "Abc", "ABC", "xyz", "XyZ")
    println(codes.map(x => x.toLowerCase()).distinct)      //List(abc, xyz)
    
    //Cannot update
    //codes(2) = "aa" failed, but ListBuffer is fine
    
    //But Vector can be .update
    val vec = Vector(100, 5, 10, 20)
    //vec(2) = -100  failed
    val vec2 = vec.updated(2, -100)
    println(vec2)        //immutable.Vector[Int] = Vector(100, 5, -100, 20)
    
    
    //2D list, List has no ofDim[Int] usage
    val matrix = List(List(20,30), List(40,50), List(60,70))    //matrix: List[List[Int]] = List(List(20, 30), List(40, 50))
    println(matrix.size)   //3 = rows' number
    println(matrix.length)   //3 = rows' number
    
    //Access top left element
    val topLeft = matrix(0)(0)    //20
    
    //Loop over all elements with a foreach call.
    matrix.foreach(_.foreach(println))
    //20
    //30
    //40
    //50
    //60
    //70
    
    
    
    val list2 = List(1,2,3)
    val list3 = List(1, 2.0, 33D, 400L)
    val list4 = List[Number](1, 2.0, 33D, 400L)
    val list5 = List.range(1,10)
    val list6 = List.range(1,10,2)    //List(1, 3, 5, 7, 9)
    
    //print the first and the last element
    println(list6(0))                //1
    println(list6.head)              //1
    
    println(list6(list6.length - 1)) //9
    
    //tail is the rest
    println(list6.tail)              //List(3, 5, 7, 9)
    
    //tail's length
    println(list6.tail.length)       //4
    
    
    //Add elements at the head
    val addHeadList = 0 :: list2      //List(0, 1, 2, 3)
    
    //Add elements at the end
    val addEndList1 = List(1,2,3) :+ 4      //List(1, 2, 3, 4)
    val addHeadList1 = 0 +: List(1,2,3)     //List(0, 1, 2, 3)
    val addEndList2 = List(1,2,3) ::: List(4)      //List(1, 2, 3, 4)

    //merge two lists
    val positions1 = List("top", "bottom")
    val positions2 = List("left", "right")
    
      //with ::
    val positions3 = positions1 :: positions2    
    println(positions3)             //List(List(top, bottom), left, right)
    println(positions3.length)      //3, Attention: is not 4
    
      //with ++
    val positions4 = positions1 ++ positions2
    println(positions4)            //List(top, bottom, left, right)
    println(positions4.length)      //4
    
      //with :::
    val positions5 = positions1 ::: positions2
    println(positions5)            //List(top, bottom, left, right)
    println(positions5.length)     //4
    
      //concat
    val positions6 = List.concat(positions1, positions2)
    println(positions6)            //List(top, bottom, left, right)
    println(positions6.length)     //4
    
    
    
    //.slice(start, end(Exclusive))
    val nums = List(0,1,2,3,4,5)
    println(nums.slice(0,4))      //List(0, 1, 2, 3)
    
    //.splitAt(start[Inclusive]) split the list into two lists
    val (left, right) = nums.splitAt(2)
    println("left = " + left + " right = " + right)    //left = List(0, 1) right = List(2, 3, 4, 5)

    //or directly print the two lists   
    println(nums.splitAt(2))    //(List(0, 1),List(2, 3, 4, 5))
    
    
    //foreach to print in UpperCase()
    val companies = List("ibm", "yahoo", "ms", "google")
    companies.foreach(x => print(x.toUpperCase() + " "))    //IBM YAHOO MS GOOGLE 
    
    //loop over two lists at once by using until() method
    val lista = List(10,20,30)
    val listb = List("a","b","c")
    val listc = List('x','y')
    
    //loop1: for (i <- start.until(end))
    for (i <- 0.until(lista.length)) {
      val e1 = lista(i)
      val e2 = listb(i)
      println(e1 + "~~" + e2)
    }
    //10~~a
    //20~~b
    //30~~c
    
    //loop2: for ( i <- start until end)
    for (i <- 0 until lista.length) {
      val e1 = lista(i)
      val e2 = listb(i)
      println(e1 + "~~" + e2)
    }
    
//   for (i <- 0.until(lista.length)) {
//      val e1 = lista(i)
//      val e2 = listc(i)
//      println(e1 + "~~" + e2) //IndexOutOfBoundsException: 2
//    }
    
    
    //fill List with 5 random numbers, Doubles
    val list7 = List.fill(5)(math.random)      
    //List(0.3161905805428106, 0.9469353634000441, 0.30012858337459647, 0.9855596750663962, 0.3758192758154536)

    val list8 = List.fill(3)("foo")
    
    //tabulate(size, could be 2D)(element function)
    val list9 = List.tabulate(5)(n => n * n)    //List(0, 1, 4, 9, 16)   
    
    //tabulate initialized value is 0
    val list10 = List.tabulate(5)(_ + 1)        //List(1, 2, 3, 4, 5)
    
    //tabulate used in 2D matrix
    val list2d1 = List.tabulate(3,3)((x,y) => (x,y))
    //List(List((0,0), (0,1), (0,2)), List((1,0), (1,1), (1,2)), List((2,0), (2,1), (2,2)))
    
    val list2d2 = List.tabulate(3,3)(_ * _) // x indx * y index 
    //List(List(0, 0, 0), List(0, 1, 2), List(0, 2, 4))
    
    //var vs val
    var ori = List(1,2,3)
    ori = List('a','b','c')
            //ori = List("abc","bcd","ded") must match type
    println(ori)    //List(97, 98, 99)
    
    //Tuple List
    val customer = List("Mike", "Flynn", 50, "08854", true)
    
    //get one element of the tuple
    println(customer(3))        //08854
    
    
    //Tuple with pairs
    val pairs = List((10, "ten"), (20, "twenty"), (30, "thirty"))
    
    //loop over the tuple pairs
    pairs.foreach(x => println(x + " "))
    //(10,ten) 
    //(20,twenty) 
    //(30,thirty)
    
    for (x <- pairs) {println(x._1 + " ~  " + x._2)}
    //10 ~  ten
    //20 ~  twenty
    //30 ~  thirty
    
    
    //map() to apply a function on each ele on the list
    val colors = List("blue", "yellow", "green")
    colors.foreach(x => print(x.toUpperCase() + " "))      //BLUE YELLOW GREEN
    
    val res = colors.map(_.toUpperCase())
    println(res)        //List(BLUE, YELLOW, GREEN)
    
    
    //Arguments: 
    //we pass a List as an argument to a function. 
    //Here we introduce a function that receives a List of Ints. 
    //We pass a list instance to this function and print its result.
    val input = List(10,0,5)
    println(lengthDoubled(input))          //6
    println(lengthDoubledwithInt(input))   //6 
    
    
    
    
    
    
    
  }
  def lengthDoubled(input: List[Int]) = input.length * 2
  
  //with or without return Int type are both right
  def lengthDoubledwithInt(input: List[Int]): Int = input.length * 2
  
  
}

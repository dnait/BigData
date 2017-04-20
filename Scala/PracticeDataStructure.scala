package ScalaHandsOn

object PracticeDataStructure {
  
  //def main(args: Array[String]) = {} is also correct
  // Tuples (Also really common with Spark!!)
  // Immutable lists
  // Often thought of as database fields, or columns.
  // Useful for passing around entire rows of data.
  
  def main(args: Array[String]) { 
    val Stringlist = ("Apple", "Microsoft", "Google")  //output: (Apple,Microsoft,Google)
    println(Stringlist)
    println(Stringlist._1)
    println(Stringlist._2)
    println(Stringlist._3)
    
    val maps = "IamKey" -> "IamValue"
    println(maps._2)
    
    //mix different types in a tuple
    val BunchOfStuff = ("Trump", 2016, true)
    println(BunchOfStuff)
    
    //Lists: like a tuple, but it's an actual Collection object that has more functionality.
    val employeeInf = List("ID", "Name", "DateOfBirth", "Address")
    println(employeeInf.head)
    println(employeeInf.tail)
    println(employeeInf(0))
    println(employeeInf(1))
//    println(employeeInf(4)) //java.lang.IndexOutOfBoundsException: 4
    
    
    //Iterating
    for(x <- employeeInf) {println(x)}   
    
    val s = "eggs, milk, butter, Coco Puffs"
    val res = s.split(",").map(_.trim)
    for (x <- res)
            print(x + " ")
    //eggs milk butter Coco Puffs
    
    
    //map(x:String => {f(x)})
    val reverseInf = employeeInf.map((x:String) => {x.reverse})
    val rev2 = employeeInf.map(_.reverse)
    println(rev2)  //same as reverseInf
    println(reverseInf)  //output: List(DI, emaN, htriBfOetaD, sserddA)
    for (x <- reverseInf) {print(x + " ; ")}
    
    
    //reduce() can be used to combine together all the items in a collection
    val numList = List(2,1,5,4,3)
    val sum = numList.reduce((x: Int, y: Int) => x + y)
    println("Sum = " + sum)    //output: Sum = 15
    
    
    //filter() keep conditions. Here we'll use wildcard syntax
    val numberList = List(11,12,13,14,15)
    //those three are all correct
    val ILoveNoThirteen = numberList.filter { x => x != 13 }
    val ILoveNoThirteen1 = numberList.filter { (x: Int) => x != 13 }
    val ILoveNoThirteen2 = numberList.filter ((x: Int) => x != 13 )
    //use wildcard
    val ILoveNoThirteen3 = numberList.filter(_!=13)
    
//    output: ILoveNoThirteen = List(11, 12, 14, 15)
//    output: ILoveNoThirteen3 = List(11, 12, 14, 15)
    
    val moreNumbers = List(2,3,4)
    val moreStrings = List("Bad","Good", "Excellent")
    val LotsOfNum = numberList ++ moreNumbers //double add sign
    val mix = numberList ++ moreStrings
//    output: LotsOfNum = List(11, 12, 13, 14, 15, 2, 3, 4)
//    output: mix = List(11, 12, 13, 14, 15, Bad, Good, Excellent)
    
    
    //More fun list
    val reverse = numList.reverse   //output: List(3, 4, 5, 1, 2)
    val reverseStr = moreStrings.reverse    //output: List(Excellent, Good, Bad)
    
    val sortNum = numList.sorted     //output: List(1, 2, 3, 4, 5)
    val sortStr = moreStrings.sorted        //output: List(Bad, Excellent, Good)
    
    val duplicates = numList ++ numList           //output: List(2, 1, 5, 4, 3, 2, 1, 5, 4, 3)
    val distinct = duplicates.distinct            //output: List(2, 1, 5, 4, 3)
    val maxValue = numList.max                    //output: 5
    val total = numberList.sum                    //output: 65
    val hasEleven = ILoveNoThirteen.contains(11)    //output: true
    
    //Create the List
    val x1 = List.range(1, 10)        //x1: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    val x2 = List.range(0, 10, 2)     //x2: List[Int] = List(0, 2, 4, 6, 8)
    val x3 = List.fill(3)("foo")       //x3: List[java.lang.String] = List(foo, foo, foo)
    
    
    //Maps
    val scalaMap = Map("sca" -> "scale", "la" -> "language")
    println(scalaMap("sca"))     //output: scale
//    println(scalamap("abc"))   //java.util.NoSuchElementException: key not found: abc
    
    val findValue = util.Try(scalaMap("abc")) getOrElse "No found"
    println(findValue)           //No found
    
    //Another way to write map
    //https://www.dotnetperls.com/map-scala
    val animalmatches = Map(("bird", "blue"), ("fox", "red"))
    
    // EXERCISE
    // Create a list of the numbers 1-20; your job is to print out numbers that are evenly divisible by three.
    //Say "evenly divisible" they mean that it will not return a float.
    //(Scala's modula operator, like other languages, is %, which gives you the remainder after division. For example, 9 % 3 = 0
    // because 9 is evenly divisible by 3.) Do this first by iterating through all the items in the list and testing each
    // one as you go. Then, do it again by using a filter function on the list instead.
    
    val numsList = List.range(1,20)
    for (x <- numsList) {if (x % 3 == 0) print(x + " ")}   //output: 3 6 9 12 15 18
    
    val res = numsList.filter((x: Int) => x % 3 == 0)  
    println(res)          //output: List(3, 6, 9, 12, 15, 18)

  }
  
  
  
}


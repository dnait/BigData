package ScalaHandsOn

/*Because a List is immutable, if you need to create a list that is constantly changing, 
 * the preferred approach is to use a ListBuffer while the list is being modified, 
 * then convert it to a List when a List is needed.
 * The ListBuffer Scaladoc states that a ListBuffer is "a Buffer implementation backed by 
 * a list. It provides constant time prepend and append. Most other operations are linear." 
 * So, don’t use ListBuffer if you want to access elements arbitrarily, 
 * such as accessing items by index (like list(10000)); use ArrayBuffer instead.
*/
object ListBufferDemo {
  def main(args: Array[String]) {
    
        //How to randomly generate 10 random Integers bellow 100
    val list = List.fill(10)(scala.util.Random.nextInt(100))
    //List(55, 25, 95, 36, 11, 20, 74, 43, 87, 60)
    
    val seq = Seq.fill(10)(scala.util.Random.nextInt(100))
    //Seq[Int] = List(59, 84, 78, 11, 43, 72, 47, 26, 25, 69)
    
    //use List.newBuilder[String] to create, by addition operator and result() to get the final list
    //.newBuilder[String] 
    val builder = List.newBuilder[String]
    //scala.collection.mutable.Builder[String,List[String]] = ListBuffer()
    
    builder += "first"
    builder += "second"
    builder += "third"
    println(builder.result())    //List(first,  second,  third)
    
    
    val x = collection.mutable.ListBuffer("cat","dog","hamster")
    val y = collection.mutable.ListBuffer("cat","dog","hamster").toList
    println(x)      //ListBuffer(cat, dog, hamster)
    println(y)      //List(cat, dog, hamster)
    
    var fruits = new collection.mutable.ListBuffer[String]()

    // add one element at a time to the ListBuffer
    fruits += "Apple"
    fruits += "Banana"
    fruits += "Orange"
    // add multiple elements
    fruits += ("Strawberry", "Kiwi", "Pineapple")
    
    // remove one element
    fruits -= "Apple"
    
    // remove multiple elements
    fruits -= ("Banana", "Orange")
    
    // remove multiple elements specified by another sequence
    fruits --= Seq("Kiwi", "Pineapple")
    
    // convert the ListBuffer to a List when you need to
    val fruitsList = fruits.toList
    
    //sum of List, work for both List and ListBuffer
    var sum = 0
    val nums = List(1,2,3)
    nums.foreach(sum +=_)
    println(sum)
    
 //~~~~~~~~~~~~~~~~~~~~~~~~~~ more about List ~~~~~~~~~~~~~~~~~~~~~~~   
    val name = List("Bob", "Fred", "Joe", "Julia", "Kim")
    
    //.init consiting all eleements except the last one, opposite to tail
    println(name.init)    //List(Bob, Fred, Joe, Julia)
    
    //loop with if condition
    for (x <- name if x.startsWith("J")) print(x + " ")
    
    //Filter(x => condition)
    val arr = List(1,2,3,4,5,6,7,8,9,10)
    
    //get the only even
    arr.filter(x => x % 2 == 0).foreach(x => print(x + " "))
    
    //takeWhile(x => condition)   
    println(arr.takeWhile(x => x < 6))    //List(1, 2, 3, 4, 5)
    
    //take and takeRight
    println(arr.take(3))             //List(1, 2, 3)
    println(arr.takeRight(3))        //List(8, 9, 10)
    
    
    //map with HTML format
    //A very nice example in the book Beginning Scala demonstrates how to 
    //convert a List into something useful in the HTML world, a list of <li> elements 
    //using the map function    
    val names = List("Fred", "Joe", "Bob")

    //If error: object xml is not a member of package scala
    //In scala Eclipse Project ->Properities -> Add External JARs
    //then go to local scala\lib\ and find scala-xml_2.11-1.0.4.jar    
    val li = names.map(x => <li>{x}</li>)
    println(li)
    
    
    val a = List(10,2,5,1,0)
    
    //init    - returns a List consisting of all elements except the last one
    println(a.init)        //List(10, 2, 5, 1)
    println(a.sorted)      //List(0, 1, 2, 5, 10)
    println(a.reverse)     //only sequence reverse, not ordered
    //real desc
    println(a.sortWith(_>_))      //List(10, 5, 2, 1, 0)
    
    //min and max
    println(a.min)
    println(a.max)
    
    //Iterator and .hasNext
    val it = Iterator("a", "number", "of", "words")
    
    //Attention: .hasNext has no brackets, or error
    while(it.hasNext) println(it.next)
    println(a.toArray)        ///[I@7a81197d it works
    
    
    //map vs flatMap
    //Because flatMap treats a String as a sequence of Char, 
    //it flattens the resulting list of strings into a sequence of characters
    //(Seq[Char]). flatMap is a combination of flatten and map
    val veggi = Seq("apple", "banana", "orange")
    //val veggi = List("apple", "banana", "orange") has the same map/flatmap results
    
    println(veggi.map(_.toUpperCase()))     //List(APPLE, BANANA, ORANGE)
    println(veggi.flatMap(_.toUpperCase()))  //List(A, P, P, L, E, B, A, N, A, N, A, O, R, A, N, G, E)
    //more case to see flatMapDemo.scala
   
    //.forall(x => condition) return Boolean
    println(List(1,2,3,4,5).forall(_<3))        //false
    println(List(1,2,3,4,5).forall(x => x<3))   //false
    
    println(veggi.forall(_.equals("aa")))    //false

    
    //exists
    println(List(1,2,3,4,5).exists(_ < 6))      //true
    println(List(1,2,3,4,5).exists(x => x < 6))      //true
    
    
    
  }
}
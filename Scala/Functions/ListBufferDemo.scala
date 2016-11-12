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
    
  }
}
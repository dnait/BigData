package ScalaHandsOn
//no need to add import scala.collection.mutable.ArrayBuffer in IDE, only in Terminal

object ArrayBuffer {
  def main(args: Array[String]) {
    //under Terminal first will import scala.collection.mutable.ArrayBuffer
    //second: val ab = ArrayBuffer("a","b","c","d","e")
    // val abuffer = new ArrayBuffer[String]("a","b","c","d","e") error
    val ab = collection.mutable.ArrayBuffer.fill(5)(-1)    
    val x = collection.mutable.ArrayBuffer('a','b','c','d','e')
    val nums = collection.mutable.ArrayBuffer.range(1,10,2) //ArrayBuffer(1, 3, 5, 7, 9)
    println(nums)
    
    //remove one element, has to match type
    x -= 'a'
    
    //remove multiple elements, has to be brackets
    x-= ('b','c')
    
    println(x)
    
    
    //Use --= to remove multiple elements that are declared in another collection 
    //(any collection that extends TraversableOnce)
    //With duplicated 'd'
    val y = collection.mutable.ArrayBuffer('a','b','c','d','e','d')
    y --= Seq('a')           //seq = ArrayBuffer(b, c, d, e, d)
    println("seq = " + y)
    y --= Array('c')         //Array = ArrayBuffer(b, d, e, d)
    println("Array = " + y)
    y --= Set('d')           //Set = ArrayBuffer(b, e, d)
    println("Set = " + y)
    
    
    //remove (start, end(Inclusive))  multiple elements
    //ArrayBuffer can be "println" directly
    val z = collection.mutable.ArrayBuffer('a','b','c','d','e','d')
    z.remove(0)   //ArrayBuffer(b, c, d, e, d)

    z.remove(1,3)  //ArrayBuffer(b, d)
    println(z)  
    
    
    //clear all elements
    z.clear
    println(z)     //ArrayBuffer()
    
    
    //Create ArrayBuffer
    var strs1 = collection.mutable.ArrayBuffer[String]()
    strs1 += "Ben"
    strs1 += "Jerry"
    strs1 += "Dale"
    
    val strs2 = collection.mutable.ArrayBuffer[String]("apple","ibm","yahoo","ibm")
    
    //add one element
    strs2 += "fb"    //ArrayBuffer(apple, ibm, yahoo, ibm, fb)
    
    //add two elements
    strs2 += ("google", "ms")    //ArrayBuffer(apple, ibm, yahoo, ibm, fb, google, ms)

    //add multiple elements with any TraversableOnce type
    strs2 ++= Seq("123","xyz")    //ArrayBuffer(apple, ibm, yahoo, ibm, fb, google, ms, 123, xyz)

    //append one or more elemetns(uses a varargs parameters)
    strs2.append("The","End")    //ArrayBuffer(apple, ibm, yahoo, ibm, fb, google, ms, 123, xyz, The, End)

  }
}
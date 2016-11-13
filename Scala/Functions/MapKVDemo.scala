package ScalaHandsOn

import scala.collection.immutable.TreeMap
import scala.collection.immutable.ListMap

object MapKVDemo {
  def main(args: Array[String]) {
    
    //Two ways to create Map
    var weights = Map("cat" -> 10, "dog" -> 20, "bird" -> 5)
    val weights2 = Map(("cat",10), ("dog",20),("bird",5))
    
    //create empty map
    val nums: Map[String, Int] = Map()
 
    
    //since nums is immutable, so need to creata a new map
    val nums1 = nums + ("one" -> 1)
    val nums2 = nums1 + ("two" -> 2) + ("three" -> 3) + ("four" -> 4)
    println(nums2)            //Map(one -> 1, two -> 2, three -> 3, four -> 4)

    //var
    var A:Map[Char,Int] = Map()
    A += ('I' -> 1)
    A += ('J' -> 5)
    A += ('K' -> 10)
    A += ('L' -> 100)
    
    
    //remove key-value pair by using "-"
    val minusnums = nums2 - "two"
    val lessnums = nums2 - "two" - "three"
    println(minusnums)         //Map(one -> 1, three -> 3, four -> 4)
    println(lessnums)          //Map(one -> 1, four -> 4)
    
    
    //find dog weight
    println(weights("dog"))        //20
    
    //add new pair to the map, can only use key->value.
    //val newWeights2 = weights2 + ("hamster",1) failed
    //val newWeights2 =  weights2.put("hamster",1) failed
    
    //Attention: Need to add bracket to the new pair
    weights +=  ("hamster" -> 1)
    val newWeights1 =  weights2 + ("hamster" -> 1)
    
    //wrong result
    val newWeights2 =  weights2 + "hamster" -> 1
    
    //only the first two are what we need
    println(weights)             //Map(cat -> 10, dog -> 20, bird -> 5, hamster -> 1)
    println(newWeights1)         //Map(cat -> 10, dog -> 20, bird -> 5, hamster -> 1)
    println(newWeights2)         //(Map(cat -> 10, dog -> 20, bird -> 5)hamster,1)
    
    //.keys to get keys
    weights.keys.foreach(x => print(x + " "))      //cat dog bird hamster 
    
    //.keySet will get a set of keys
    println(weights.keySet)    //Set(cat, dog, bird, hamster)
    
    //.values to get values
    weights.values.foreach(x => print(x + " "))    //10 20 5 1 
    
    //When "aa" is not in the map, java.util.NoSuchElementException: key not found: aa
    //weights("aa") is not safe, so we use .get(key) or getOrElse 
    //or withDefaultValue when creating map
    println(weights.get("aa"))      //None since it returns a Option
    println(weights.getOrElse("xyz", "Cannot Find"))    //return Cannot find
    
    //creating map withDefaultValue(with customized value)
    val state = Map("AL" -> "Alabama").withDefaultValue("Not Found")
    println(state("abc"))          //Not Found
    println(state.get("abc"))      //still None when using .get(key)
    
    
    //only var can update the pair
    var x = Map("AL" -> "Alabama")
    x = Map("AL" -> "allrigh") 
    println(x)        //Map(AL -> allrigh)
    
    x = Map("CO" -> "Colorado")
    println(x)        //Map(CO -> Colorado)

   
    //Iterate the map
    val rating = Map("A" -> 4.0, "B" -> 3.0, "C" -> 2.0, "D" -> 1.0)
    
    //Attention: foreach will follow {} curly bracket
    rating.foreach{case(grade,rating) => println(grade + ":" + rating)}   
    //A:4.0
    //B:3.0
    //C:2.0
    //D:1.0
    rating.foreach{case(grade,rating) => println(s"grade: $grade, rating: $rating")}
    //grade: A, rating: 4.0
    //grade: B, rating: 3.0
    //grade: C, rating: 2.0
    //grade: D, rating: 1.0
    
    //use the Tuple syntax to access the key and value fields:
    rating.foreach(x => println(x._1 + " " + x._2))
    //A:4.0
    //B:3.0
    //C:2.0
    //D:1.0
    
     //directly print
    rating.foreach(println)
    //(A,4.0)
    //(B,3.0)
    //(C,2.0)
    //(D,1.0)
    
    
    println(rating.keysIterator)      //non-empty iterator
    println(rating.valuesIterator)    //non-empty iterator
    
    //Reversing Keys and Values
    //Being sure to assign the result to a new variable
    val reverseRating = for ((k,v) <- rating) yield (v,k)
    println(reverseRating)        //Map(4.0 -> A, 3.0 -> B, 2.0 -> C, 1.0 -> D)
    
    //contains
    if (rating.contains("A")) println(rating("A")) else println("Not Found")  //4.0
    
    //test a value exists in a map, use the valuesIterator with exists and contains
    val states = Map("AK" -> "Alaska","IL" -> "Illinois","KY" -> "Kentucky")
    println(states.valuesIterator.exists(_.contains("ucky")))      //true
    
    // error : println(rating.valuesIterator.exists(_.contains(3.0)))
    //error: value contains is not a member of Double

    
    //Map merge by using ++ or map1.++() which will remove the dupliated keys
    val rating1 = Map("A" -> 4.0, "B" -> 3.0)
    val rating2 = Map("C" -> 2.0, "D" -> 1.0, "B" -> 3.0)
    var ratings = rating1 ++ rating2
    println(ratings)    //Map(A -> 4.0, B -> 3.0, C -> 2.0, D -> 1.0)
    
    //error: ratings = ratings + rating1.++(rating2)
    ratings = rating1.++(rating2)
    println(ratings)    //Map(A -> 4.0, B -> 3.0, C -> 2.0, D -> 1.0)
    
    //retain a map in mutable map
    var mumap = collection.mutable.Map(1 -> "a", 2 -> "b", 3 -> "c")
    println(mumap.retain((k,v) => k > 1))      //Map(2 -> b, 3 -> c)
    
    //transform a map in a mutable map
    println(mumap.transform((k, v) => v.toUpperCase))   //Map(2 -> B, 3 -> C)
    
    //equals
    val map1 = Map((10, true), (20, false))
    val map2 = Map((20, false), (10, true))
    val map3 = Map((20, true), (10, true))
    if (map1.equals(map2)) println("Maps equal")         //Maps equal
    if (!map1.equals(map3)) println("Maps not equal")    //Maps not equal
    
    //sort map by creating sortedMap
    val scores = scala.collection.immutable.SortedMap(("Bob", 8), ("Alice", 21), ("Fred", 17), ("Cindy", 15)) 
    scores.foreach(x => print(x._1 + " " + x._2 + " "))  //Alice 21 Bob 8 Cindy 15 Fred 17 
    
    //sort with TreeMap, .toSeq.sortBy, .toSeq.sortWith(condition)
    val employee = Map(("Bob", 28), ("Alice", 62), ("Fred", 44), ("Cindy", 20)) 
    
        //sort by key, using TreeMap, need to import scala.collection.immutable.TreeMap
    val sortedMap = TreeMap(employee.toSeq:_*)
    println(sortedMap)    //Map(Alice -> 62, Bob -> 28, Cindy -> 20, Fred -> 44)
    
        //sort the map by key, from low to high, using ListMap and sortBy
    val sortedListMap = ListMap(employee.toSeq.sortBy(_._1):_*)
    println(sortedListMap)    //Map(Alice -> 62, Bob -> 28, Cindy -> 20, Fred -> 44)
    
        //.toSeq.sortWith(condition):_*
    val sortedListMap1 = ListMap(employee.toSeq.sortWith(_._1 > _._1):_*)
    println(sortedListMap1)    //Map(Fred -> 44, Cindy -> 20, Bob -> 28, Alice -> 62)
    
    //find max 
    val grades = Map("Al" -> 80, "Kim" -> 95, "Teri" -> 25, "Julia" -> 90)
    println(grades.max)          //(Teri,85)
    println(grades.min)          //(Al,80)
    
    //find key max, keysIterator is keys, plural
    println(grades.keysIterator.max)        //Teri
    println(grades.keysIterator.min)        //Al
    
    //find max with keysIterator.reduceLeft
    println(grades.keysIterator.reduceLeft((x,y) => if (x > y) x else y))    //Teri
    
    //find the “largest” is the longest string in the key
    println(grades.keysIterator.reduceLeft((x,y) => if (x.length > y.length) x else y))  ////Julia
    
    
    //find max with valueIterator.max
    println(grades.valuesIterator.max)        //90
    println(grades.valuesIterator.min)        //25
    
    //find max with valuesIterator.reduceLeft
    println(grades.valuesIterator.reduceLeft((x,y) => if (x > y) x else y))   //95
    println(grades.valuesIterator.reduceLeft(_ max _))    //95
      
  }
}
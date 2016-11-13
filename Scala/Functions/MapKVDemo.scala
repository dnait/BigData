package ScalaHandsOn

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

  }
}
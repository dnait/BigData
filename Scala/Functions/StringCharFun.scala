package ScalaHandsOn

object StringCharFun {
  def main(args: Array[String]) {
        
    //create a list of alphanumeric characters
    val chars = 'a' to 'z'    //NumericRange.Inclusive[Char] = NumericRange(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z)
    val chars2 = ('a' to 'z') ++ ('A' to 'Z')  //immutable.IndexedSeq[Char] = Vector(a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z)
  
    //first letter will be capitalized
    val name = "this is my day"
    println(name.capitalize)        //String = This is my day
    
    //.toUpperCase
    println(name.toUpperCase())
    
    //repeat string for multiple times  str * times
    val letters = "abc" * 3        //String = abcabcabc
    val sign = "-" * 30            //String = ------------------------------
    
    //reverse
    val id = "x100"
    println(id.reverse)            //String = 001x
    
    //equal
    val id1 = "x100"
    val id2 = "x" + "100"
    println(id1.equals(id2))       //Boolean = true
    
    //complex equal function
    iscombineequals("abcd", "ab", "cd")        //abcd, true
    iscombineequals("catdog", "cat", "dog")    //catdog, true
    iscombineequals("xxyy", "ef", "gh")        //xxyy, false
    
    //split, String, return Array[String]
    val res = "brick,cement,concrete".split(",")    //Array[String] = Array(brick, cement, concrete)
     
    //size
    println(res.length)        //3
    println(res.size)          //3
    
    //split with multiple delimiters
    val codes = "abc;def,ghi:jkl".split(Array(';',',',':'))
    println(codes.deep.mkString(" "))      //abc def ghi jkl
    
    //take, head and foreach
    val timestamp = "2016-Nov-13T21"
    timestamp.foreach {println}
    /*2
			0
			1
			6
			-
			1
			1
      -
      1
      3
      T
      2
      1
      */
    
    println(timestamp.take(4))                   //String = 2016
    println(timestamp.take(9).toLowerCase)      //String = 2016-nov-
    
    
    //.line, like iterator
    val pet = "cat\nbird\nfish and dog"
    for (line <- pet.lines) println(line)
    //cat
    //bird
    //fish and dog
    
    //Slice(start, end(exclusive)) vs substring
    //Slice can be used in String and List
    //Performace has no difference
    //"substring" makes it clearer what we are trying to do. 
    val phrase = "a-soft-orange-cat"
    println(phrase.slice(2, 6))         //String = soft
    println(phrase.substring(2, 6))     //String = soft
    println(phrase.slice(2, 6) == phrase.substring(2, 6))    //Boolean = true
    
    val points = List(1.5, 3.5, 10.3, 11.3)
    println(points.slice(2,points.length))  //List(10.3, 11.3)
    
    val a1 = "scala"
    val res1 = a1(0)            //Char = s
    val res2 = a1.slice(0, 1)   //String = s
    //println(res1 == res2)  Char compare to String will always return false
    //scala> res1 == res2
    //<console>:39: warning: comparing values of types Char and String using `==' will always yield false
    //   res1 == res2
    //      ^
    //res309: Boolean = false

    
    //Test slice and substring's performance
    val data = "abcdef"

    // Warm up the JIT.
    val test = data.slice(3, 5)
    val test2 = data.substring(3, 5)
    
    val t1 = System.currentTimeMillis()
    
    // Version 1: use slice.
    for (i <- 0 to 100000000) {
        val part = data.slice(3, 5)
        if (part != "de")
    	println(false)
    }
    
    val t2 = System.currentTimeMillis()
    
    // Version 2: use substring.
    for (i <- 0 to 100000000) {
        val part = data.substring(3, 5)
        if (part != "de")
    	println(false)
    }
    
    val t3 = System.currentTimeMillis()
    
    // Print times.
    println(t2 - t1)        //969 ms,    slice
    println(t3 - t2)        //967 ms,    substring

    //equals
    val a = "foo"
    val b = "foo"
    val c = "bar"
    a == b       // true
    a == c       // false
    
    //f,s is to print with variables
    val nameId = "Joe"
    val age = 42
    val weight = 180.5
    println(f"$nameId is $age years old, and weighs $weight%.1f pounds.")
    //Joe is 42 years old, and weighs 180.5 pounds.
    
    //raw: to print original string
    println(raw"foo\nbar")        // foo\nbar
    
    
    //Treating a String as an Array[Char]
    //Attention: Char has only .toUpper, not .toUpperCase
    (for (c <- "hello") yield c.toUpper).foreach(print)      //HELLO
    
    "hello".getBytes.foreach(println)
    //104
    //101
    //108
    //108
    //111
    
    //Use Map for Char
    println("HELLO".map(_.toLower))        //hello
    
    
    //customize function in map
    // a custom method
    println("HELLO".map(chartoLower))      //hello

        
    //Transforming arrays to a String
    //mkString("startsign", "deli", "endsign")
    val arr = Array(1,2,3)
    println(arr.mkString)                     //123
    println(arr.mkString(" "))                //1 2 3
    println(arr.mkString("<", ",", ">"))      //<1,2,3>
    
    //string to number
    val strnum = "12345"
    val strFloat = "100.456"
    println(strnum.toInt)            //12345
    println(strFloat.toFloat)        //100.456
    
    //string(index) to get position
    println("watch X-man"(6))      //X
    
    //.distinct
    println("roffor".distinct)     //rof
    
    //.intersect
    val s1 = "Alvin"
    val s2 = "Alexander"
    println(s1.intersect(s2) == s2.intersect(s1))      //true
        
    //.diff, to find the change of the file
    val b1 = "Four score and six years ago"
    val b2 = "Four score and seven years ago"
    print(b1.diff(b2))                                //ix
    println(b2.diff(b1))                              //"vene"
    println(b1.split(" ").diff(b2.split(" ")))        //Array[String] = Array(six)
    println(b1.split(" ").intersect(b2.split(" ")))   //Array(Four, score, and, years, ago)
    
    //more function
    val str = "I love Yahoo"
    //str.collect
    //str.reduce
    
    str.count(_ == 'o')          // 3
    str.diff("Yahoo")            // I lve o
    "I love Yahoo".diff("I love")    //String = " Yahoo"
    str.dropWhile(_ != " ")    // Attention: "" will return empty; ' ' will return String = " love Yahoo"
    str.dropWhile(_ != ' ')    //String = " love Yahoo"
    str.head                    //Char = I
    str.headOption              //Option[Char] = Some(I)
    str.indexOf('o')            //Int = 3
    str.endsWith("hoo")         //true
    str.filter(_ != 'o')        //I lve Yah
    str.isEmpty                 //false
    str.lastIndexOf('o')        //Int = 11
    str.lastIndexOf("Ya")       //Int = 7
    
    str.par        //a parallel array, ParArray(I,  , l, o, v, e,  , Y, a, h, o, o)
    str.partition(_ > 'e')      //(String, String) = (lovhoo,I e Ya)
    str.replace("Yahoo","Google")      //String = I love Google
    "I love love Yahoo".replace("love", "LOVE")  //String = I LOVE LOVE Yahoo
    str.replace('o', 'x')        //I lxve Yahxx
    str.replace("o", "x")        //I lxve Yahxx
    str.replaceFirst("o", "x")   //I lxve Yahoo
    "I love LOVE Yahoo".replaceAll("o","x")   //I lxve LOVE Yahxx
    str.reverse            //oohaY evol I
    str.slice(0,5)
    str.substring(0,5)
    str.sortBy { _ > 'e' }      //String = I e Yalovhoo ???
    str.sortWith(_ > _)         //String = "vooolheaYI  "
    str.sortWith(_ < _)         //String = "  IYaehlooov"
    str.sorted                  //String = "  IYaehlooov"
    str.split(" ")              //Array[String] = Array(I, love, Yahoo)
    str.splitAt(3)              //(String, String) = (I l,ove Yahoo)
    val (left, right) = str.splitAt(3)   //left: String = I l
                                         //right: String = ove Yahoo
    str.tail                    //String = " love Yahoo"
    str.take(3)                 //String = I l
    str.takeRight(3)            // String = hoo
    str.takeWhile(_ != 'Y')     //String = "I love "
    str.toArray                 //Array[Char] = Array(I,  , l, o, v, e,  , Y, a, h, o, o)
    str.toBuffer                //ArrayBuffer(I,  , l, o, v, e,  , Y, a, h, o, o)

    str.toList                  //List(I,  , l, o, v, e,  , Y, a, h, o, o)
    str.toSet                   //Set[Char] = Set(e, Y, a, I,  , v, l, h, o)
    str.toStream                //immutable.Stream[Char] = Stream(I, ?)
    str.toVector                //Vector[Char] = Vector(I,  , l, o, v, e,  , Y, a, h, o, o)
    str.view                    //scala.collection.SeqView[Char,String] = SeqView(...)
    
    
    "Coca".zip(0 to 10)        //immutable.IndexedSeq[(Char, Int)] = Vector((C,0), (o,1), (c,2), (a,3))
    "Coca".zip(0 to 2)         //Vector((C,0), (o,1), (c,2))

    "Coca".zipWithIndex        //Vector((C,0), (o,1), (c,2), (a,3))

    "Coca".zipWithIndex.unzip   //(Vector(C, o, c, a),Vector(0, 1, 2, 3))
    val (item, index) = "Coca".zipWithIndex.unzip    //item Vector(C, o, c, a)
                                                     //index: Vector(0, 1, 2, 3)
    
    
    //Attention: str.sortWith(- _ > _) will return no change
    
    
    //leetcode
    str.split(" ").reverse.mkString(" ")  //String = Yahoo love I
    str.split(" ").reverse.toString       //String = [Ljava.lang.String;@23676416
    //remove multiple space using +
    "I     love  yahoo".split(" +")       //Array(I, love, yahoo) 
    
    
    
    //.byteValue
    
  }
  def chartoLower(c: Char):Char = (c.toByte+32).toChar
  
  def iscombineequals(combine: String, left: String, right: String): Unit = {
    if (combine == left + right) println(s"$combine, true") else println(s"$combine, false")
  }
}
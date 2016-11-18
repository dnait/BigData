package ScalaHandsOn

object OnelineScala {
  def main(args: Array[String]) {
    
      //1. Multiple Each Item in a List by 2
    (1 to 10)map(_*2)    //Vector(2, 4, 6, 8, 10, 12, 14, 16, 18, 20)
    (1 to 10) map(_*2)    //is also correct
    (1 to 10).map(_*2)    //is also correct
    
    //2. Sum of a List of Number
    (1 to 1000).reduceLeft(_+_)      //Int = 500500
    (1 to 1000).sum                  //Int = 500500
    
    //3. Verify if Exists in a String
    // I used this example for checking if a tweet contains a word I'm interested in
    val wordList = List("scala", "kafka", "sbt", "hadoopstreaming")
    val tweet = "This is a tweet talking about sala and sbt"
    wordList.exists { tweet.contains }        //true
    wordList.foldLeft(false)((x:Boolean,y:String) => x || tweet.contains(y))
    
    
    //4. Read in a File
    // error: object Source is not a member of package io
    //val fileTet = io.Source.fromFile("/Users/grace/data.txt")
   
    import scala.io.Source

    val filename = "/Users/grace/data.txt"
    for (line <- Source.fromFile(filename).getLines()) println(line)
    //CONTENTS
    //Disclaimer
    //Preface
    //Part I: Making the Big Decision
    
    val fileContents = Source.fromFile("/Users/grace/data.txt").getLines.mkString
    //String = CONTENTSDisclaimerPrefacePart I: Making the Big Decision

    
    //5. Happy Birthday to You!
    val name = "Amy"
    (1 to 4).map{i => "Happy Birthday" + (if (i == 3) s"dear $name" else "to You")}.foreach(println)
    //Happy Birthdayto You
    //Happy Birthdayto You
    //Happy Birthdaydear Amy
    //Happy Birthdayto You
    
    
    //6. Filter list of numbers
    val (passed, failed) = List(49, 58, 76, 82, 88, 90) partition ( _ > 60 )
    //passed: List[Int] = List(76, 82, 88, 90)
    //failed: List[Int] = List(49, 58)
    
    
    //7. Fetch and Parse an XML web service
    //val results = val results = XML.load("http://search.twitter.com/search.atom?&q=scala") is error
    val results = scala.xml.XML.load("http://search.twitter.com/search.atom?&q=scala")

    
    //8. Max & Min
    List(14, 35, -7, 46, 98).reduceLeft ( _ min _ )      //Int = -7
    List(14, 35, -7, 46, 98).min                         //Int = -7

    List(14, 35, -7, 46, 98).reduceLeft ( _ max _ )      //Int = 98
    List(14, 35, -7, 46, 98).max                         //Int = 98
    
    
    //9. Parallel Processing
    //Scala 2.9 introduced a new collection type called "parallel collections" which utilize 
    //multi-core processors when performing bulk operations such as foreach, map, filter, etc... 
    //Here's a video of Aleksandar Prokopec explaining parallel collections at Scala Days 2010.
    //This example is not quite a copy-and-paste into the REPL, 
    //but it illustrates how to use parallel collections. 
    //Imagine you had a set of data defined in a list dataList and a function processItem which was 
    //very cpu intense. The following one-liner would give you parallel processing over the list.
    //val dataList = List(1, 2.0, 33D, 400L)
    //val result = dataList.par.map( line => processItem(line) ) error
    
    
    //crazy 10.
    //Sieve of Eratosthenes
    //Daniel Sobral created the Sieve of Eratosthenes which is a algorithm used to determine if a number is prime.
    //(n: Int) => (2 to n) |> (r => r.foldLeft(r.toSet)((ps, x) => if (ps(x)) ps -- (x * x to n by x) else ps))
    //is error
  }
}
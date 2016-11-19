package ScalaHandsOn

//Edited from Learning Spark by O'Reilly
//Before import, remember to import all external jar files from spark-2.0.1-bin-hadoop2.7/jar folder first

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._


object wordCountStandalone {
  def main(args: Array[String]) {
    
    val conf = new SparkConf().setMaster("local").setAppName("wordCount")
    val sc = new SparkContext(conf)
    
    //load input data, need to put input files under current packages
    //Input path does not exist: file:/Users/grace/Scalaworkspace/ScalaHandson/data.txt
    val input = sc.textFile("data.txt")  
    val words = input.flatMap(line => line.split(" ")).map(word => word.toLowerCase())
    //cannot println(words) since it is transformation
  
//    //transform into pairs and count
    val counts = words.map(word => (word, 1)).reduceByKey(_+_)
    
    //cannot println(counts.collect)   //[Lscala.Tuple2;@4cb0a000
    //But scala-shell works for counts.collect
    for ((word, count) <- counts) {
        println(word + " " + count)
    }
    
    //Will save as a part-00000 under target folder: data_output
    counts.saveAsTextFile("data_output")
    sc.stop()

  }
}

/*scala> counts.collect
res1: Array[(String, Int)] = Array((So,5), (two,3), ('Cause,1), (is,1), (Alice,,5), 
* (one,3), ("",5), (Alice,19), (boom!,5), (three,3), (hump.,3), (ride,,5), (camel,18), 
* (five,3), (ride.,5), (has,18), (four,3), (course.,1), (song,1), (Boom,,5), 
* (a,1), (no,3), (horse,,1), (humps.,15), (of,1), (boom,,10), (Children�s,1), (the,18))
*/

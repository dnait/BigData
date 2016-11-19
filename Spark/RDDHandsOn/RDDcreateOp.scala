package ScalaHandsOn

//create RDD from local or hdfs

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._

object RDDcreateOp {
  def main(args: Array[String]) {
    
    val conf = new SparkConf().setMaster("local").setAppName("RDDApp")
    val sc = new SparkContext(conf)
    
    val rdd = sc.parallelize(1 to 10)
    
    println(rdd.collect)    //[I@6c4f9535
    println(rdd.collect.mkString(" "))      //1 2 3 4 5 6 7 8 9 10
    
    println(rdd.partitions.size)            //1
    
    //Under shell, the result is different
    //scala> rdd.partitions.size
    //res16: Int = 8
    
    val rdd2 = sc.parallelize(1 to 10, 3)
    println(rdd2.partitions.size)  
    
    //under shell, the result is the same now
    //scala> rdd2.partitions.size
    //res17: Int = 3
    
    
    
    //parallelize with location will help optimize for the next steps
    
    
    //val rdd3 = sc.textFile("hdfs:///tmp/lxw1234/1.txt")
    //println()
    
    //Craete RDD from local files
    val rdd3 = sc.textFile("data.txt")
    println(rdd3.count)            //Long = 35
    
    
    
  }
  
}
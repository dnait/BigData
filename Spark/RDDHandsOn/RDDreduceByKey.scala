package ScalaHandsOn
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._

object RDDreduceByKey {
  def main(args: Array[String]) {
    val conf = new SparkConf().setMaster("local").setAppName("groupByKey")
    val sc = new SparkContext(conf)
    
    
    //groupByKey
    //def groupByKey(): RDD[(K, Iterable[V])]
    val rdd1 = sc.makeRDD(Array(("A",0),("A",2),("B",1),("B",2),("C",1)))
    val res1 = rdd1.groupByKey()
    println(res1.collect.mkString(","))       //(B,CompactBuffer(1, 2)),(A,CompactBuffer(0, 2)),(C,CompactBuffer(1))
    
    
    //reduceByKeyLocally, return Map[K, V], not RDD[K,V]
    //def reduceByKeyLocally(func: (V, V) => V): Map[K, V]
    
    val rdd2 = sc.makeRDD(Array(("A",0),("A",2),("B",1),("B",2),("C",1)))
    val res2 = rdd2.reduceByKeyLocally(_+_)
    println(res2.mkString(","))  
    //since return Map, so cannot use collect
    //A -> 2,B -> 3,C -> 1
    
    //reduceByKey
    val rdd3 = sc.makeRDD(Array(("A",0),("A",2),("B",1),("B",2),("C",1)))
    val res3 = rdd3.reduceByKey(_+_)
    println(res3.collect.mkString(","))    //Array[(String, Int)] = Array((A,2), (B,3), (C,1))
    
    println(res3.partitions.size)      //1, but under spark-shell is 8
    
    val res33 = rdd3.reduceByKey(new org.apache.spark.HashPartitioner(2),(x,y) => x + y)
    println(res33.partitions.size)      //2
    
    

  }
  
}
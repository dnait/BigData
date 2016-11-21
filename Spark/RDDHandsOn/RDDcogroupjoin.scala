package ScalaHandsOn

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._

object RDDcogroupjoin {
  def main(args: Array[String]) {
    val conf = new SparkConf().setMaster("local").setAppName("RDDcogroupApp")
    val sc = new SparkContext(conf)
    
    //cogroup
    //cogroup is similar with full outer join，return null if cannot relationship
    val rdd1 = sc.makeRDD(Array(("A","1"),("B","2"),("C","3")),2)
    val rdd2 = sc.makeRDD(Array(("A","a"),("C","c"),("D","d")),2)
    
    val res = rdd1.cogroup(rdd2)
    println(res.collect.mkString(","))
    //Array((B,(CompactBuffer(2),CompactBuffer())), (D,(CompactBuffer(),CompactBuffer(d))), 
    //(A,(CompactBuffer(1),CompactBuffer(a))), (C,(CompactBuffer(3),CompactBuffer(c))))
    
    val res1 = rdd1.cogroup(rdd2,3)
    println(res1.collect.mkString(","))
    //(B,(CompactBuffer(2),CompactBuffer())),(C,(CompactBuffer(3),CompactBuffer(c))),
    //(A,(CompactBuffer(1),CompactBuffer(a))),(D,(CompactBuffer(),CompactBuffer(d)))
    
    val rdd3 = sc.makeRDD(Array(("A","A"),("E","E")),2)
    val res2 = rdd1.cogroup(rdd2,rdd3)
    println(res2.collect.mkString(","))
    //(B,(CompactBuffer(2),CompactBuffer(),CompactBuffer())),(D,(CompactBuffer(),CompactBuffer(d),CompactBuffer())),
    //(A,(CompactBuffer(1),CompactBuffer(a),CompactBuffer(A))),(C,(CompactBuffer(3),CompactBuffer(c),CompactBuffer())),
    //(E,(CompactBuffer(),CompactBuffer(),CompactBuffer(E)))
    
    
    //join is similar to SQL inner join
    //Only for 2 RDD join
    //val rdd1 = sc.makeRDD(Array(("A","1"),("B","2"),("C","3")),2)
    //val rdd2 = sc.makeRDD(Array(("A","a"),("C","c"),("D","d")),2)
    val res3 = rdd1.join(rdd2)
    println(res3.collect.mkString(","))
    //Array[(String, (String, String))] = Array((A,(1,a)), (C,(3,c)))
    
  }
    
  
}
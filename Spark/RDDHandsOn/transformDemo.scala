package ScalaHandsOn

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.rdd.RDD

object transformDemo {
  def main(args: Array[String]) {

      val conf = new SparkConf().setMaster("local").setAppName("squaredata")
      val sc = new SparkContext(conf)
      
      val input = sc.parallelize(List(1,2,3,4))
      val result = input.map(x => x * x)

//      result.saveAsTextFile("output")
      
      //result.collect() will not show results      
      println(result.collect().mkString(","))      //1,4,9,16
      
      
      val lines = sc.makeRDD(List("apple is not veggi", "yahoo","ibm"))
      val words = lines.flatMap(line => line.split(" "))
      println(words.first())                    //apple
      //RDD cannot use for makeRDD('char')
      val rdd1 = sc.makeRDD(List("apple","ibm"))     
      println(words.subtract(rdd1).collect().mkString(","))      //not,veggi,yahoo,is
      //val left = words - "ibm"
     //println(left)
      
      List(1,2,3,4) filterNot List(1,2).contains        //List[Int] = List(3, 4)      
      List(1,2,3,4) diff List(1,2)                      //List[Int] = List(3, 4)
      
      
      //remove, RDD has no "-" , use "filter"  
      //val res = lines - "apple"
      //error: value - is not a member of org.apache.spark.rdd.RDD[String]
      val res = lines.filter(_!="apple")
      println(res.collect.mkString(" | "))      //apple is not veggi | yahoo | ibm
      
      val res1 = lines.filter(!_.contains("apple"))
      println(res1.collect.mkString(" | "))    //yahoo | ibm
      
      
      
  }
}
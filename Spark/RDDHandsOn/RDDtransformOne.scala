package ScalaHandsOn
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._

object RDDtransformOne {
  def main(args: Array[String]) {
    val conf = new SparkConf().setMaster("local").setAppName("mapValuesApp")
    val sc = new SparkContext(conf)
    var rdd1 = sc.makeRDD(Array((1,"A"),(2, "B"), (3, "C"), (4, "D")),2)
    
    //Like map, mapValues only works for values
    rdd1.mapValues(x => x + "_").collect    
    //Array[(Int, String)] = Array((1,A_), (2,B_), (3,C_), (4,D_))
    
    print(rdd1.mapValues(x => x + "_").collect.mkString(","))  //(1,A_),(2,B_),(3,C_),(4,D_)
    
    //Like flatMap, faltMapValues only works for values
    rdd1.flatMapValues(x => x + "_").collect          
    //Array[(Int, Char)] = Array((1,A), (1,_), (2,B), (2,_), (3,C), (3,_), (4,D), (4,_))
    
    print(rdd1.flatMapValues(x => x + "_").collect.mkString(","))
    
  }
  
  
}
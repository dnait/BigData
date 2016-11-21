package ScalaHandsOn
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._

/*
 * foldByKey is different in IDE and Spark-shell
 */

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
    
    //combineByKey
    val rdd2 = sc.makeRDD(Array(("A",1),("A",2),("B",1),("B",2),("C",1)))
    val res2 = rdd2.combineByKey(
                                  (v: Int)=> v+ "_",
                                  (c:String, v:Int) => c + "@" + v,
                                  (c1:String, c2: String) => c1 + "$" + c2
                                 )
     println(res2.collect.mkString(","))                         
      //Array[(String, String)] = Array((A,1_$2_), (B,1_$2_), (C,1_))
     
     val res22 = rdd2.combineByKey(
                                    (v : Int) => List(v),
                                    (c : List[Int], v : Int) => v :: c,
                                    (c1 : List[Int], c2 : List[Int]) => c1 ::: c2
                                   )
      println(res22.collect.mkString(","))   
      //Array[(String, List[Int])] = Array((A,List(1, 2)), (B,List(1, 2)), (C,List(1)))
      
      
      //foldByKey, no foldbyvalue~~lol
      val rdd3 = sc.makeRDD(Array(("A",0),("A",2),("B",1),("B",2),("C",1)))
      val res3 = rdd3.foldByKey(0)(_+_)
      
      //accumulate values by key, such as 
      //("A",0), ("A",2)，will get ("A",0+0), ("A",2+0), then ("A",0), ("A",2)
      // then finally get (A,2)
      
      println(res3.collect.mkString(","))
      //(B,3),(A,2),(C,1)
      
      val res33 = rdd3.foldByKey(1)(_+_)
      println(res33.collect.mkString(","))
      //(B,4),(A,3),(C,2)
      
      val res34 = rdd3.foldByKey(2)(_+_)
      println(res34.collect.mkString(","))
      //(B,5),(A,4),(C,3)
      
      
      //scala> rdd3.foldByKey(0)(_+_).collect
      //res50: Array[(String, Int)] = Array((A,2), (B,3), (C,1))
      
      
//Attention: each value has added the initial value so A will be 4
      //scala> rdd3.foldByKey(1)(_+_).collect
      //res48: Array[(String, Int)] = Array((A,4), (B,5), (C,2))
    
      
      //scala> rdd3.foldByKey(2)(_+_).collect
      //res49: Array[(String, Int)] = Array((A,6), (B,7), (C,3))
  }
  
  
}
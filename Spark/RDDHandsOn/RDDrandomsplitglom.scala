package ScalaHandsOn

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._

/*def randomSplit(weights: Array[Double], seed: Long = Utils.random.nextLong): Array[RDD[T]]
 * Will split RDD into multiple RDDs according to weights
 * 
 */


object RDDrandomsplitglom {
  def main(args: Array[String]) {
    
    val conf = new SparkConf().setMaster("local").setAppName("randomsplitglomApp")
    val sc = new SparkContext(conf)
    
    val rdd = sc.makeRDD(1 to 10,10)
    
    val splitRdd = rdd.randomSplit(Array(1.0,2.0,3.0,4.0,5.0))
    //randomSplit(Array[Double]) will return Array
    //Under shell: 
    //splitRdd: Array[org.apache.spark.rdd.RDD[Int]] = Array(MapPartitionsRDD[20] at randomSplit 
    //at <console>:26, MapPartitionsRDD[21] at randomSplit at <console>:26, MapPartitionsRDD[22] 
    //at randomSplit at <console>:26, MapPartitionsRDD[23] at randomSplit at <console>:26, 
    //MapPartitionsRDD[24] at randomSplit at <console>:26)

    
    println(splitRdd.size)          //5
    /*
     *  scala> splitRdd(0).collect
			  res21: Array[Int] = Array(10)

				scala> splitRdd(1).collect
				res22: Array[Int] = Array(2)

				scala> splitRdd(2).collect
				res23: Array[Int] = Array()

				scala> splitRdd(3).collect
				res25: Array[Int] = Array(1, 5, 8)

				scala> splitRdd(4).collect
				res26: Array[Int] = Array(3, 4, 6, 7, 9)

				scala> splitRdd(5).collect
				java.lang.ArrayIndexOutOfBoundsException: 5
  			... 48 elided
     */
    
    //Attention: more elements with higher weights
    //Attention: sum of weight == 1, or something wrong will happen
    
    
    //glom
    //def glom(): RDD[Array[T]], convert [T] into Array[T], and put into serveral partitions
    var rdd1 = sc.makeRDD(1 to 10, 3)
    println(rdd1.partitions.size)        //3
    
    rdd1.glom().collect
    //res30: Array[Array[Int]] = Array(Array(1, 2, 3), Array(4, 5, 6), Array(7, 8, 9, 10))
    
    
    
    
    
  }
}
package ScalaHandsOn

import org.apache.spark._
import org.apache.spark.rdd._
import org.apache.spark.SparkContext._
import org.apache.spark.mllib.feature.Word2Vec

object synonymsfinder {
  def main(args: Array[String]) {
      // Set up a SparkContext named WordCount that runs locally using
      // all available cores.

      val conf = new SparkConf().setAppName("WordCount")
      conf.setMaster("local[*]")
      val sc = new SparkContext(conf)

      // Create a RDD of lines of text in our book
      val input = sc.textFile("text8").map(line => line.split(" ").toSeq)
  
      val word2vec = new Word2Vec()
      
      val model = word2vec.fit(input)
      
      val synonyms = model.findSynonyms("china", 40)
      
      for((synonym, cosineSimilarity) <- synonyms) {
        println(s"$synonym $cosineSimilarity")
      }
      
      sc.stop()

  }
}

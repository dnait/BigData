package com.sundogsoftware.sparkstreaming

import org.apache.spark._

object TextWordCount {
  
  def main(args: Array[String]) {
    
    //Set up a SparkContext named TextWordCount that runs locally
    //using all available cores
    val conf = new SparkConf().setAppName("TextWordCount")
    //cannot reverse .setMaster and new SparkContext, or new SparkContext(conf) will fail.
    conf.setMaster("local[*]")
    val sc = new SparkContext(conf)
    
    
    //Create a RDD of lines of text in the book
    //val input = sc.textFile("/Users/grace/downloads/MapReduceCourse/book.txt")
    //error:Input path does not exist: file:/Users/grace/Scalaworkspace/SparkstreamingTweet/book.txt
    //then move the book.txt to the required path
    val input = sc.textFile("book.txt")
    val words = input.flatMap { input => input.split(" ") }
    val lowerCaseWords = words.map(word => word.toLowerCase())
    //count up the occurrence of each unique word
    val wordsCount = lowerCaseWords.countByValue()
    
    //print the first 20 results
    val sample = wordsCount.take(20)
    for ((word, count) <- sample) {
      println(word + " " + count)
    }
    sc.stop()   
  }
  
}

/*
output:
foolproof 1
precious 1
inflammatory 1
referrer, 1
hourly 3
embedded 1
way). 1
touch, 1
of. 3
salesperson 5
expansion. 1
rate 7
appropriate. 2
2014 2
amazon.com 1
plugin 3
headache 1
purchasing 9
eric. 1
looks 2
*/
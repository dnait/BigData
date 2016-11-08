package com.sundogsoftware.sparkstreaming

import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.spark.sql._
import org.apache.log4j._

object SparkSQL {
  
  case class Person(ID:Int, name:String, age:Int, numFriends:Int)
  
  def mapper(line:String): Person = {
    val fields = line.split(',')  
    
    val person:Person = Person(fields(0).toInt, fields(1), fields(2).toInt, fields(3).toInt)
    return person
  }
  
  /** Our main function where the action happens */
  def main(args: Array[String]) {
    
    // Set the log level to only print errors
    Logger.getLogger("org").setLevel(Level.ERROR)
    
    // Use new SparkSession interface in Spark 2.0
    val spark = SparkSession
      .builder
      .appName("SparkSQL")
      .master("local[*]")
      //.config("spark.sql.warehouse.dir", "file:///C:/temp") // Necessary to work around a Windows bug in Spark 2.0.0; omit if you're not on Windows.
      .getOrCreate()
    
     //Exception in thread "main" org.apache.hadoop.mapred.InvalidInputException: 
      //Input path does not exist: file:/Users/grace/Scalaworkspace/SparkstreamingTweet/fakefriends.csv
    val lines = spark.sparkContext.textFile("fakefriends.csv")
    val people = lines.map(mapper)
    
    // Infer the schema, and register the DataSet as a table.
    // import spark.implicits._ is to convert a structured RDD into a dataset
    import spark.implicits._
    val schemaPeople = people.toDS
    
    schemaPeople.printSchema()
    
    schemaPeople.createOrReplaceTempView("people")
    
    // SQL can be run over DataFrames that have been registered as a table
    val teenagers = spark.sql("SELECT * FROM people WHERE age >= 13 AND age <= 19")
    
    val results = teenagers.collect()
    
    results.foreach(println)
    
    spark.stop()
  }
}
/*
Using Spark's default log4j profile: org/apache/spark/log4j-defaults.properties
root
 |-- ID: integer (nullable = false)
 |-- name: string (nullable = true)
 |-- age: integer (nullable = false)
 |-- numFriends: integer (nullable = false)

[21,Miles,19,268]
[52,Beverly,19,269]
[54,Brunt,19,5]
[106,Beverly,18,499]
[115,Dukat,18,397]
[133,Quark,19,265]
[136,Will,19,335]
[225,Elim,19,106]
[304,Will,19,404]
[341,Data,18,326]
[366,Keiko,19,119]
[373,Quark,19,272]
[377,Beverly,18,418]
[404,Kasidy,18,24]
[409,Nog,19,267]
[439,Data,18,417]
[444,Keiko,18,472]
[492,Dukat,19,36]
[494,Kasidy,18,194]
*/

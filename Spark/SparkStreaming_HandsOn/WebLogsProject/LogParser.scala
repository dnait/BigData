
package com.suncatsoftware.sparkstreaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.storage.StorageLevel

import java.util.regex.Pattern
import java.util.regex.Matcher

import Utilities._

/** Maintains top URL's visited over a 5 minute window, from a stream
 *  of Apache access logs on port 9999.
 *  max osx 10.0 need to run terminal: $ nc -kl 9999 < access_log.txt
 *  Need to Ctrl^c to break the stream and restart it again if you want to make changes in this scala file
 */
object LogParser {
 
  def main(args: Array[String]) {

    // Create the context with a 1 second batch size
    val ssc = new StreamingContext("local[*]", "LogParser", Seconds(1))
    
    setupLogging()
    
    // Construct a regular expression (regex) to extract fields from raw Apache log lines
    val pattern = apacheLogPattern()

    // Create a socket stream to read log data published via netcat on port 9999 locally
    val lines = ssc.socketTextStream("127.0.0.1", 9999, StorageLevel.MEMORY_AND_DISK_SER)
    
    // Extract the request field from each log line
    val requests = lines.map(x => {val matcher:Matcher = pattern.matcher(x); if (matcher.matches()) matcher.group(5)})
    
    // Extract the URL from the request
    val urls = requests.map(x => {val arr = x.toString().split(" "); if (arr.size == 3) arr(1) else "[error]"})
    
    // Reduce by URL over a 5-minute window sliding every second
    val urlCounts = urls.map(x => (x, 1)).reduceByKeyAndWindow(_ + _, _ - _, Seconds(300), Seconds(1))
    
    // Sort and print the results
    val sortedResults = urlCounts.transform(rdd => rdd.sortBy(x => x._2, false))
    sortedResults.print()
    
    // Kick it off
    ssc.checkpoint("/Users/grace/workspace/")
    ssc.start()
    ssc.awaitTermination()
  }
}
/*
-------------------------------------------
Time: 1478151637000 ms
-------------------------------------------
(/xmlrpc.php,68494)
(/wp-login.php,1923)
(/,440)
(/blog/,138)
(/robots.txt,123)
(/post-sitemap.xml,118)
(/sitemap_index.xml,118)
(/category-sitemap.xml,117)
(/page-sitemap.xml,117)
(/orlando-headlines/,95)
...

-------------------------------------------
Time: 1478151638000 ms
-------------------------------------------
(/xmlrpc.php,68494)
(/wp-login.php,1923)
(/,440)
(/blog/,138)
(/robots.txt,123)
(/post-sitemap.xml,118)
(/sitemap_index.xml,118)
(/category-sitemap.xml,117)
(/page-sitemap.xml,117)
(/orlando-headlines/,95)
...
*/

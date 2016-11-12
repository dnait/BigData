Zip: Given two lists, to create a list of tuples of the corresponding elements
scala> dayIndices zip week
res52: List[(Int, String)] = List((1,Mon), (2,Tue), (3,Wed), (4,Thu), (5,Fri))

scala> week zip dayIndices
res53: List[(String, Int)] = List((Mon,1), (Tue,2), (Wed,3), (Thu,4), (Fri,5))



flatten: Given a list of lists, to combine into one list
scala> val days = List(week, weekends).flatten
days: List[String] = List(Mon, Tue, Wed, Thu, Fri, Sat, Sun)

scala> val days = List(week, weekends)
days: List[List[String]] = List(List(Mon, Tue, Wed, Thu, Fri), List(Sat, Sun))

List.reverse
scala> week.reverse
res54: List[String] = List(Fri, Thu, Wed, Tue, Mon)

scala> week.contains("Fri")
res55: Boolean = true

scala> week.contains("Jan")
res57: Boolean = false

scala> val dupweek = "Mon" :: week
dupweek: List[String] = List(Mon, Mon, Tue, Wed, Thu, Fri)

scala> dupweek.distinct
res58: List[String] = List(Mon, Tue, Wed, Thu, Fri)

scala> week drop 2
res60: List[String] = List(Wed, Thu, Fri)

//subset of a list
scala> week slice (2,4)
res62: List[String] = List(Wed, Thu)

scala> week.splitAt(3)
res63: (List[String], List[String]) = (List(Mon, Tue, Wed),List(Thu, Fri))

scala> week.take(2)
res64: List[String] = List(Mon, Tue)

scala> week.min
res66: String = Fri

scala> week.max
res67: String = Wed

scala> week.product
<console>:26: error: could not find implicit value for parameter num: Numeric[String]
       week.product
            ^

scala> val list = List(2,1,8,6)
list: List[Int] = List(2, 1, 8, 6)

scala> list.max
res69: Int = 8

scala> list.min
res70: Int = 1

scala> list.product
res71: Int = 96

map: each element in the list has a function
such as _ == “Mon”

scala> val weekDays = List("Mon","Tue","Wed","Thu","Fri")
weekDays: List[String] = List(Mon, Tue, Wed, Thu, Fri)

scala> weekDays.map( _ == "Mon")
res72: List[Boolean] = List(true, false, false, false, false)

scala> val ismanicMon = (x: String) =>  x == "Mon"
ismanicMon: String => Boolean = <function1>

scala> val ismanicMon = (x: String) => { x == "Mon"}: Boolean
ismanicMon: String => Boolean = <function1>

filter: function that returns true or false (see each else in the list that satisfied the predicate)
scala> weekDays.filter(_ != "Mon")
res74: List[String] = List(Tue, Wed, Thu, Fri)

scala> val isnotmanicMon = (x: String) => x !="Mon"
isnotmanicMon: String => Boolean = <function1>

scala> weekDays.filter(isnotmanicMon)
res75: List[String] = List(Tue, Wed, Thu, Fri)



//partition
take a predicate and return 2 lists- else that satisfy and those that don’t

scala> weekDays.partition(_ != "Mon")
res76: (List[String], List[String]) = (List(Tue, Wed, Thu, Fri),List(Mon))

scala> weekDays.partition(isnotmanicMon)
res77: (List[String], List[String]) = (List(Tue, Wed, Thu, Fri),List(Mon))

//sortBy  _(0) sort the list elements based on it

//sort by the first letter of the string
scala> weekDays.sortBy(_(0))
res93: List[String] = List(Fri, Mon, Tue, Thu, Wed)

scala> week.sortBy(_.length)
res84: List[String] = List(Mon, Tue, Wed, Thu, Fri)

scala> week.sortBy(_.toLowerCase)
res85: List[String] = List(Fri, Mon, Thu, Tue, Wed)

scala> val weeks = List("a", "b","c","d")
weeks: List[String] = List(a, b, c, d)

scala> weeks.sortBy(-_(0))
res89: List[String] = List(d, c, b, a)

//Scan, ScanLeft, ScanRight：(can see the process)
scala> val nums = List(10,20,30,40,50,60)
nums: List[Int] = List(10, 20, 30, 40, 50, 60)

scala> nums.scanRight(0)(_-_)
res94: List[Int] = List(-30, 40, -20, 50, -10, 60, 0)

scala> nums.scanLeft(0)(_-_)
res95: List[Int] = List(0, -10, -30, -60, -100, -150, -210)

//fold: very closely related to .scan, .scanLeft, .scanRight

scala> nums.scanRight(0)(_-_)
res98: List[Int] = List(-30, 40, -20, 50, -10, 60, 0)

scala> nums.foldRight(0)(_-_)
res100: Int = -30

//Reduce, ReduceLeft, ReduceRight

scala> nums.reduceRight(_-_)
res101: Int = -30
 
scala> val nums = List(10,20,30,40,50,60)
nums: List[Int] = List(10, 20, 30, 40, 50, 60)

scala> nums.foldLeft(0)(_-_)
res102: Int = -210

scala> nums.scanLeft(0)(_-_)
res103: List[Int] = List(0, -10, -30, -60, -100, -150, -210)

scala> nums.reduceLeft(_-_)
res104: Int = -190

 

reduce: 10-20 = -10 -> -40 -> -80 -> -130 -> -190

EndsWith / StarsWith 

scala> val weekDays = List("Mon","Tue","Wed","Thu","Fri")
weekDays: List[String] = List(Mon, Tue, Wed, Thu, Fri)

scala> val weekEnds = List("Sat","Sun")
weekEnds: List[String] = List(Sat, Sun)

scala> val allDays = weekDays ::: weekEnds
allDays: List[String] = List(Mon, Tue, Wed, Thu, Fri, Sat, Sun)

scala> allDays endsWith weekEnds
res105: Boolean = true

scala> weekDays endsWith weekEnds
res107: Boolean = false

scala> allDays startsWith weekEnds
res108: Boolean = false

scala> allDays startsWith weekDays
res110: Boolean = true

scala> allDays forall (_ != "Monday")
res111: Boolean = true

scala> allDays forall (_ != "Mon")
res112: Boolean = false

Map:
scala> val stateCodesmap = Map("California" -> "CA", ("Vermont", "VT"))
stateCoedsmap: scala.collection.immutable.Map[String,String] = Map(California -> CA, Vermont -> VT)

map.contains(key) will return true or false

scala> stateCodesmap.foreach((p: (String, String)) => println(p._1 + "=" + p._2))
California=CA
Vermont=VT
 (p: (String, String)) is 2-element tuples, the function must operate on key-value pairs, i.e. 2-element tuples

Convert two lists to map using zip and toMap
zip will create a list of 2-tuples from 2 lists
	toMap will create Map from that list of 2-tuples

scala> val states = List("California","New York","Vermont")
states: List[String] = List(California, New York, Vermont)

scala> val codes = List("CA","NY","VT")
codes: List[String] = List(CA, NY, VT)

scala> val stateCodes2 = (states zip codes).toMap
stateCodes2: scala.collection.immutable.Map[String,String] = Map(California -> CA, New York -> NY, Vermont -> VT)

//map转成List    用.keySet.toList 和.values.toList
scala> val states = stateCodesmap.keySet.toList
states: List[String] = List(California, Vermont)

scala> val codes = stateCodesmap.values.toList
codes: List[String] = List(CA, VT)


//Mutable Collections and Arrays
List, Set and Map are all immutable collections. 
They are corresponding mutable collections:
(Rarely used, these can be grown/shrunk, and the elements can be modified too)
the Array with fixed length, but elements can be modified.

Create immutable List / Map / Set

scala> val nums = collection.immutable.List(10,20,30,40)
nums: List[Int] = List(10, 20, 30, 40)

scala> val stateCodes = collection.immutable.Map("California" -> "CA",("Vermont","VT"))
stateCodes: scala.collection.immutable.Map[String,String] = Map(California -> CA, Vermont -> VT)

scala> val stateSet = collection.immutable.Set("California","Vermont")
stateSet: scala.collection.immutable.Set[String] = Set(California, Vermont)

Create immutable Buffer/ Map / Set (Attention: mutable has no List，only Buffer)
scala> val nums = collection.mutable.List(10,20,30)
<console>:23: error: object List is not a member of package scala.collection.mutable
       val nums = collection.mutable.List(10,20,30)
                                     ^
scala> val nums = collection.mutable.Buffer(10,20,30)
nums: scala.collection.mutable.Buffer[Int] = ArrayBuffer(10, 20, 30)

mutable  covert immutable , just use .toList, .toMap, .toSet


<console>:28: error: value split is not a member of Char
       val wordCounts = string.flatMap(s => s.split(" ")).map(word => (word, 1)).reduceByKey(_+_)

scala> val res = string.split(" ").map(x => (x,1)).reduceByKey(_+_)
<console>:30: error: value reduceByKey is not a member of Array[(String, Int)]
       val res = string.split(" ").map(x => (x,1)).reduceByKey(_+_)

scala> val wordCounts = string.flatMap(s => s.split(" ")).map(word => (word, 1)).reduceByKey(_+_)
<console>:28: error: value split is not a member of Char
       val wordCounts = string.flatMap(s => s.split(" ")).map(word => (word, 1)).reduceByKey(_+_)
    
scala> sqrt(2)
<console>:27: error: overloaded method value sqrt with alternatives:
  (colName: String)org.apache.spark.sql.Column <and>
  (e: org.apache.spark.sql.Column)org.apache.spark.sql.Column
 cannot be applied to (Int)
       sqrt(2)
       ^

scala> import scala.math._
import scala.math._

scala> sqrt(2)
res135: Double = 1.4142135623730951

scala> pow(2,4)
res136: Double = 16.0

scala> min(3,pi)
res137: Double = 3.0

scala> val arr = Array(1,2,3,4,5)
arr: Array[Int] = Array(1, 2, 3, 4, 5)

scala> for (i <- arr if i > 2) yield 2
res138: Array[Int] = Array(2, 2, 2)

scala> for (i <- arr if i > 2) yield i
res139: Array[Int] = Array(3, 4, 5)

scala> for (i <- arr by 2) yield i
<console>:32: error: value by is not a member of Array[Int]
       for (i <- arr by 2) yield i
                     ^

scala> val values = Array("one", "two","three","four","five")
values: Array[String] = Array(one, two, three, four, five)

scala> arr zip values
res141: Array[(Int, String)] = Array((1,one), (2,two), (3,three), (4,four), (5,five))

scala> (arr zip values).toMap
res142: scala.collection.immutable.Map[Int,String] = Map(5 -> five, 1 -> one, 2 -> two, 3 -> three, 4 -> four)

scala> val values2 = Array("one","two","zero","seven")
values2: Array[String] = Array(one, two, zero, seven)

scala> values union values2
res143: Array[String] = Array(one, two, three, four, five, one, two, zero, seven)

scala> value interaction values2
<console>:32: error: not found: value value
       value interaction values2
       ^

scala> values intersect values2
res145: Array[String] = Array(one, two)

scala> List("a","b","c").zipwithIndex
<console>:30: error: value zipwithIndex is not a member of List[String]
       List("a","b","c").zipwithIndex
                         ^

scala> List("a","b","c").zipWithIndex
res147: List[(String, Int)] = List((a,0), (b,1), (c,2))

scala> Array("a","b","c").zipWithIndex
res148: Array[(String, Int)] = Array((a,0), (b,1), (c,2))

scala> arr
res149: Array[Int] = Array(1, 2, 3, 4, 5)

scala> arr.update(2,200)

scala> arr
res151: Array[Int] = Array(1, 2, 200, 4, 5)

scala> Array(Array(1,2),Array(3,4)).deep.toString
res152: String = Array(Array(1, 2), Array(3, 4))

scala> import scala.math._
import scala.math._

scala> sqrt(2)
res135: Double = 1.4142135623730951

scala> sqrt(2)
res135: Double = 1.4142135623730951

scala> pow(2,4)
res136: Double = 16.0

scala> min(3,pi)
res137: Double = 3.0

scala> val arr =  Array(1, 2, 200, 4, 5)
res164: Array[Int] = Array(1, 2, 200, 4, 5)

scala> arr.clone()
res171: Array[Int] = Array(1, 2, 200, 4, 5)

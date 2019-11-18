package ScalaHandsOn

object basicScala {
  def main(args: Array[String]) {
    val s = "I love Yahoo"
    println(s.length)           //12 //java.s.length()  //python: len(s)
    println(s.substring(2,4))      //lo //java: s.substring(2,4)  // python: x[2:4] x[:-2] return "I love Yah"
    println(s.replace("o", "x"))    //I lxve Yahxx  //java: bbb".replace("bb", "c") //python:str.replace("is", "was") 
                                                    //str.replace("is", "was", 3) only the first one will be replaced
    
    //Strings can be dynamically constructed using interpolation. 
    //Scala uses the prefix s for this.
    //Note that usage of s before the string. 
    //The dynamic variables are substituted using the ${variable} syntax.
    val y = "phone"
    val g = s"I want a new ${y}"   //python: without s 
    println(g)   //g: String = i want a new phone, if forgot "s"before that, it will print s: String = I want a ${x}
    
    val d = sum(1, 10)
    println(d)      //11
    
    val d1 = sum1(2, 10)
    println(d1)
    
    //Anonymous Functions:
    //In Scala, An anonymous function is also known as a function literal. 
    //A function which does not contain a name is known as an anonymous function. 
    //An anonymous function provides a lightweight function definition. 
    val c = (x: Int) => x * x
    println("Result is " + c(10))
    
    //data structure:
    
	/* Python only has 4 data structures   
	List is a collection which is ordered and changeable. Allows duplicate members.
	Tuple is a collection which is ordered and unchangeable. Allows duplicate members.
	Set is a collection which is unordered and unindexed. No duplicate members.
	Dictionary is a collection which is unordered, changeable and indexed. No duplicate members.
	*/
    
  /* Scala has 6 basic data structures
  Arrays
	Lists
	Sets
	Tuple
	Maps
	Option
	*/
    
    //1. Array
    //scala: 
    val fruits = Array("apple", "orange", "grapes", "guava") 
    println(fruits(2))     //grapes
    //Java: String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
    //python only has list: cars = ["Ford", "Volvo", "BMW"] x = cars[0] i.e Ford
    
    //2. List:
    scala> val numbers = List(1, 2, 3, 4, 5, 1, 2, 3, 4, 5)
    scala> numbers(3)=4
    
    //3. Set
    val numbers = Set(1, 2, 3, 4, 5, 1, 2, 3, 4, 5)
    //python thisset = {"apple", "banana", "cherry"}
    /*java: Set set = new HashSet();
            set.add("123");
            set.add("456");
    */
    //4. Tuple:
    val hostPort = ("localhost", 80)
    scala> hostPort._1   ======> "localhost"
    scala> hostPort._2   ======> 80
    // python: thistuple = ("apple", "banana", "cherry")
    // print(thistuple[-1])  =====> "cherry"

    //tule match method
    val priceOfPlainDonut = hostPort.foreach { tuple => {
      tuple match {
        case ("localhost", port) => println(s"hostPort type = Plain hostPort, port = $port")
        case d if d._1 == "80" => println(s"hostPort type = ${d._0}, port = ${d._1}")
        case _ => None
      }
     }
					     

    
    //5. Map
    val a = Map("apple" -> "fruit", "cabbage" -> "vege", "peanut" -> "nut")
    //a: scala.collection.immutable.Map[String,String] = Map(apple -> fruit, cabbage -> vegetable, peanut -> nuts)
    //a("g") will result in exception java.util.NoSuchElementException: key not found g
    println(a("apple"))      //fruit
  }
	  
	  
   //6. python Dict
   thisdict = {
      "brand": "Ford",
      "model": "Mustang",
      "year": 1964
    }
    print(thisdict)
	  
	  
	  
  //Functions
  def sum(a: Int, b: Int): Int = { a + b }
  def sum1(a: Int, b: Int): Int = a + b
  
//Java
public class ListExample{  
    public static void main(String args[]){  
        List<String> al=new ArrayList<String>();  
            al.add("Amit");  
            al.add("Mike");  //al.get(index)
            System.out.println("An element at 2nd position: "+al.get(2));  
            for(String s:al){  
                System.out.println(s);  
            }  
    }
}

	  
python:	  
a = 33
b = 200
if b > a:
    print("b is greater than a")
	  
//Scala:	  
object Demo {
   def main(args: Array[String]) {
      var x = 10;
      if( x < 20 ){
         println("This is if statement");
      }
   }
}
------------------------------------------------ Functional Combinators --------------------------------------------------
1. Map
scala> val numbers = List(0,1, 2, 3, 4)
scala> numbers.map((x: Int) => x * x)   
or rewrite as:	  
scala> def times(x: Int): Int = x * x
scala> numbers.map(times)
res17: List[Int] = List(0, 1, 4, 9, 16)

//python:
>>> x = [x*x for x in nums ]
>>> x
[0, 1, 4, 9, 16]

2. filter
scala> numbers.filter((x: Int) => x % 2 == 0)
scala> def isEven(x:Int): Boolean = x % 2 == 0
scala> numbers.filter(isEven)
res19: List[Int] = List(0, 2, 4)

//python:
>>> nums= range(0,5)  //cannot use range(0,4), or '4' will not in the range
>>> x=[x for x in nums if x % 2 == 0]
>>> x
[0, 2, 4]
	  
3. Zip
scala> List(1, 2, 3).zip(List("a", "b", "c"))
res20: List[(Int, String)] = List((1,a), (2,b), (3,c))

scala> List(1, 2, 3).zip(List("a", "b"))
res21: List[(Int, String)] = List((1,a), (2,b))  

4. find
scala> numbers.find((i:Int) => i > 2)
res23: Option[Int] = Some(3)	

scala> x.find((x: String)=> x contains "app")
res25: Option[String] = Some(apple)
	  
scala> def findapp(x: String):Boolean = x contains "app"
findapp: (x: String)Boolean

scala> x.find(findapp)
res24: Option[String] = Some(apple)
  
	  
//python:
>>> x = range(0, 5)
>>> y = [i for i in x if i > 2]
>>> y
[3, 4]
//String contains
>>> x=["apple","mike","grape"]
>>> y = [i for i in x if "app" in i]
>>> y
['apple']
	  
	  
5. foldLeft = foldRight  
scala> numbers.foldLeft(0){(m: Int,n: Int) => println("m=" + m + " n="+n); m+n } 
m=0 n=0
m=0 n=1
m=1 n=2
m=3 n=3
m=6 n=4
res26: Int = 10

6. flatten
scala> val x = List(List(1,2), List(3,4)).flatten
x: List[Int] = List(1, 2, 3, 4)
------------------------------------------------ Functional Combinators End--------------------------------------------------	  

-------------------------------------------------- Spark Scala vs PySpark ----------------------------------------------------	   
	  

	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
-------------------------------------------------- Spark Scala vs PySpark END ----------------------------------------------------	  
//Shell script	  
INPUT_STRING=hello
while [ "$INPUT_STRING" != "bye" ]
do
  echo "Please type something in (bye to quit)"
  read INPUT_STRING
  echo "You typed: $INPUT_STRING"
done
	  
	  
echo "Bash version ${BASH_VERSION}..."
for i in {0..10..2}
  do 
     echo "Welcome $i times"
 done

Bash version 4.0.33(0)-release...
Welcome 0 times
Welcome 2 times
Welcome 4 times
Welcome 6 times
Welcome 8 times
Welcome 10 times

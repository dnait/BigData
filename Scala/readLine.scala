package ScalaHandsOn

object readLine {
  def main(args: Array[String]) = {
    Console.println("Enter string: ")
    
    val input = Console.readLine
    Console.println("The string you entered is: " + input)
  }
}
package ScalaHandsOn

class Point (xc: Int, yc: Int) {
  var x: Int = xc
  var y: Int = yc
  
  def move(dx: Int, dy: Int) {
    x = x + dx
    y = y + dy
    println("Point x location: " + x)
    println("Point y location: " + y)
  }  
}

object Pointmove {
  def main(args: Array[String]) {
    val pt = new Point(10,20);
    
    //Move to a new position
    pt.move(10,10)
  }
}
/*
Point x location: 20
Point y location: 30
*/
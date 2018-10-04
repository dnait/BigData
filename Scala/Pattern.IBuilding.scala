package com.scala.pattern.factory

trait IBuilding {
  def show()
}


case class SimpleBuilding(name: String)extends IBuilding {
  def show = println("SimpleBuilding " + name + " is building")
}
case class LuxuryBuilding(name: String) extends IBuilding{
  def show = println("LuxuryBuilding " + name + " is building")
}

object ConstructionFactory  {
  def createBuilding(kind: String): IBuilding =  kind match {
    case "Simple" =>   SimpleBuilding("Simple")
    case "Luxury" =>   LuxuryBuilding("Luxury")
  }
}

//object IBuilding {
//  def apply(kind: String): IBuilding = kind match {
//    case "Simple" =>   SimpleBuilding("Simple")
//    case "Luxury" =>   LuxuryBuilding("Luxury")
//  }
//}
// when using apply, easy to call
//val simpleBuilding: IBuilding = IBuilding("Simple")
//val luxuryBuilding: IBuilding = IBuilding("Luxury")
//simpleBuilding.show()
//luxuryBuilding.show

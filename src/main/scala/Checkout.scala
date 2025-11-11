import Fruit.{Apple, Orange}

import scala.language.postfixOps

enum Fruit(name: String, price: Int):
  def getPrice: Int = price
  case Apple extends Fruit("apple", 60)
  case Orange extends Fruit("orange", 25)
  case Unknown extends Fruit("unknown", 0)

object Checkout {

  private def toFruit(item: String): Fruit =  Option(item).map(_.toLowerCase) match {
    case Some("apple") => Fruit.Apple
    case Some("orange") => Fruit.Orange
    case _ => Fruit.Unknown
  }

  def applyOffer(fruit: Fruit, numberOfFruit: Int, offerThreshold: Int, discount: Int): Int = {
    val totalPrice = fruit.getPrice * numberOfFruit
    if(numberOfFruit >= offerThreshold) {
      totalPrice - ((numberOfFruit / offerThreshold) * (discount * fruit.getPrice))
    } else{
      totalPrice
    }
  }

  def scan(seq: Seq[String]): Int = {
    Option(seq) match {
      case Some(seq) =>
        val someFruit = seq.map(toFruit)
        val numberOfApples = someFruit.count(_ == Apple)
        val numberOfOranges = someFruit.count(_ == Orange)
        applyOffer(Apple, numberOfApples, 2, 1) + applyOffer(Orange, numberOfOranges, 3, 1)
      case _ => 0
    }
  }
}

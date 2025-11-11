import scala.language.postfixOps

object Checkout {

  private def getPriceOf(item: String): Int =  Option(item).map(_.toLowerCase) match {
    case Some("apple") => 60
    case Some("orange") => 25
    case _ => 0
  }

  def scan(seq: Seq[String]): Int = {
    Option(seq) match {
      case Some(seq) => seq.map(getPriceOf).sum
      case _ => 0
    }
  }
}

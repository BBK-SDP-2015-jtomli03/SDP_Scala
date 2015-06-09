package week7

/**
 * Created by Jo on 24/02/2015.
 */
object Towns extends App {

  val townsAndCounties = Map(
  "Essex" -> "Chelmsford",
  "Yorkshire" -> "Leeds",
  "Lancashire" -> "Madchester",
  "Devon" -> "Exeter"
  )

  println("Towns in Counties: ")
  println("Essex " + townsAndCounties.get("Essex"))
  println("Yorkshire " + townsAndCounties.get("Yorkshire"))

}

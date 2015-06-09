package Traits

/**
 * Created by Jo on 27/01/2015.
 */

sealed trait Aa

case class Ba() extends Aa

case class Ca() extends Aa

object PolySum {
  def f(a: Aa) =
    a match{
      case Ba() => ???
      case Ca() => ???
    }
}

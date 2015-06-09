package Traits

/**
 * Created by Jo on 27/01/2015.
 */

  trait B

  trait C

case class A(b:B, c:C)

  object PolyPatternMatch{
    def foo(a: A) =
      a match{
        case A(b,c) => ???
      }
  }


